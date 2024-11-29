package org.app.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.app.entities.Bout;
import org.app.services.interfaces.IBoutService;

import java.util.List;

/**
 * Implementation of {@link IBoutService} that provides service methods to manage {@link Bout} entities.
 *
 * <p>This class is responsible for handling operations like retrieving all bouts,
 * retrieving bouts by tourney or attacker, and inserting new bouts into the database using JPA's {@link EntityManager}.</p>
 *
 * <h2>Key Features:</h2>
 * <ul>
 *   <li>Supports complex query operations involving tournament and character-based filtering.</li>
 *   <li>Performs transactional writes for bout creation to ensure data consistency.</li>
 *   <li>Logs actions and errors using {@link Logger} from Log4j2.</li>
 *   <li>Implements the {@link IBoutService} interface to provide a standard contract for bout operations.</li>
 * </ul>
 *
 * @see Bout
 * @see IBoutService
 */
public class BoutService implements IBoutService {

    /** Logger for logging important events and errors. */
    private static final Logger logger = LogManager.getLogger(BoutService.class);

    /** EntityManagerFactory for managing database connections. */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("joustAsEasyPU");

    @Override
    public List<Bout> getAllBouts() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT b FROM Bout b", Bout.class).getResultList();
        } catch (Exception e) {
            logger.error("Error retrieving all bouts", e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Bout> getBoutsByTourney(String tourney) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT b FROM Bout b WHERE b.tourney = :tourney", Bout.class)
                    .setParameter("tourney", tourney)
                    .getResultList();
        } catch (Exception e) {
            logger.error("Error retrieving bouts for tourney: {}", tourney, e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Bout> getBoutsByTourneyAndAttacker(String tourney, String attackingCharacterKey) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                            "SELECT b FROM Bout b WHERE b.tourney = :tourney AND b.attacker.characterKey = :attackerKey",
                            Bout.class)
                    .setParameter("tourney", tourney)
                    .setParameter("attackerKey", attackingCharacterKey)
                    .getResultList();
        } catch (Exception e) {
            logger.error("Error retrieving bouts for tourney: {} and attacker: {}", tourney, attackingCharacterKey, e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Bout getBoutByBoutPreciseKey(String boutKey) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT b FROM Bout b WHERE b.boutKey = :boutKey", Bout.class)
                    .setParameter("boutKey", boutKey)
                    .getSingleResult();
        } catch (Exception e) {
            logger.error("Error retrieving bout with key: {}", boutKey, e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Bout> getBoutsByBoutPartialKey(String boutKey) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT b FROM Bout b WHERE b.boutKey LIKE :boutKey", Bout.class)
                    .setParameter("boutKey", boutKey + "%")
                    .getResultList();
        } catch (Exception e) {
            logger.error("Error retrieving bouts with partial key: {}", boutKey, e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void insertBout(Bout newBout) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(newBout);
            em.getTransaction().commit();
            logger.info("Inserted new bout: {}", newBout.getBoutKey());
        } catch (Exception e) {
            logger.error("Error inserting bout: {}", newBout.getBoutKey(), e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            logger.info("EntityManagerFactory closed.");
        }
    }
}
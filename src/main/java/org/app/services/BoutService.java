package org.app.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.app.entities.Bout;

import java.util.List;

/**
 * The {@code BoutService} class provides service methods to manage {@link Bout} entities.
 *
 * <p>This class is responsible for handling operations like retrieving all bouts,
 * retrieving bouts by tourney or attacker, and inserting new bouts into the database using JPA's {@link EntityManager}.</p>
 *
 * <h2>Key Features:</h2>
 * <ul>
 *   <li>Supports complex query operations involving tournament and character-based filtering.</li>
 *   <li>Performs transactional writes for bout creation to ensure data consistency.</li>
 *   <li>Logs actions and errors using {@link Logger} from Log4j2.</li>
 * </ul>
 */
public class BoutService {

    /** Logger for logging important events and errors. */
    private static final Logger logger = LogManager.getLogger(BoutService.class);

    /** EntityManagerFactory for managing database connections. */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("joustAsEasyPU");

    /**
     * Retrieves all bouts from the database.
     *
     * <p>This method uses JPQL to fetch all {@link Bout} entities from the database.</p>
     *
     * @return A list of all bouts, or {@code null} if an error occurs.
     */
    public List<Bout> getAllBouts() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT b FROM Bout b", Bout.class).getResultList();
        } catch (Exception e) {
            logger.error("Error retrieving all bouts", e);
            return null;
        } finally {
            em.close();  // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Retrieves bouts by the name of the tourney.
     *
     * <p>This method fetches bouts that took place in a specific tournament.</p>
     *
     * @param tourney The name of the tourney for which bouts should be retrieved.
     * @return A list of bouts for the given tourney, or {@code null} if an error occurs.
     */
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
            em.close();  // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Retrieves bouts for a specific tourney and attacker character.
     *
     * @param tourney The name of the tourney.
     * @param attackingCharacterKey The key of the character who was the attacker in the bout.
     * @return A list of bouts for the given attacker in the specified tourney, or {@code null} if an error occurs.
     */
    public List<Bout> getBoutsByTourneyAndAttacker(String tourney, String attackingCharacterKey) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT b FROM Bout b WHERE b.tourney = :tourney AND b.attacker.characterKey = :attackerKey", Bout.class)
                    .setParameter("tourney", tourney)
                    .setParameter("attackerKey", attackingCharacterKey)
                    .getResultList();
        } catch (Exception e) {
            logger.error("Error retrieving bouts for tourney: {} and attacker: {}", tourney, attackingCharacterKey, e);
            return null;
        } finally {
            em.close();  // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Retrieves a specific bout by its unique bout key.
     *
     * <p>This method fetches the bout with the exact given bout key.</p>
     *
     * @param boutKey The unique identifier of the bout.
     * @return The bout with the given key, or {@code null} if an error occurs or no such bout exists.
     */
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
            em.close();  // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Retrieves bouts using a partial bout key (e.g., for fuzzy searches).
     *
     * <p>This method uses the SQL {@code LIKE} operator to match bouts whose keys partially match the given key.</p>
     *
     * @param boutKey The partial key used to match bouts.
     * @return A list of bouts matching the partial key, or {@code null} if an error occurs.
     */
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
            em.close();  // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Inserts a new bout into the database.
     *
     * <p>This method opens a transaction, persists the new {@link Bout} entity, and commits the transaction.
     * If an error occurs, the transaction is rolled back.</p>
     *
     * @param newBout The {@code Bout} entity to be inserted into the database.
     */
    public void insertBout(Bout newBout) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();  // Start transaction
            em.persist(newBout);          // Insert bout into the database
            em.getTransaction().commit(); // Commit transaction
            logger.info("Inserted new bout: {}", newBout.getBoutKey());
        } catch (Exception e) {
            logger.error("Error inserting bout: {}", newBout.getBoutKey(), e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();  // Rollback transaction on error
            }
        } finally {
            em.close();  // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Closes the {@link EntityManagerFactory} when the service is no longer needed.
     *
     * <p>This method ensures that the {@code EntityManagerFactory} is closed to release any resources
     * held by the persistence unit.</p>
     */
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            logger.info("EntityManagerFactory closed.");
        }
    }
}

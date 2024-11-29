package org.app.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.app.entities.Character;
import org.app.services.interfaces.ICharacterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Implementation of {@link ICharacterService} that provides service methods to manage {@link Character} entities.
 *
 * <p>This class is responsible for handling operations like retrieving all characters,
 * retrieving characters by their associated house, and inserting new characters into the database
 * using JPA's {@link EntityManager}.</p>
 *
 * <h2>Key Features:</h2>
 * <ul>
 *   <li>Performs database operations related to characters.</li>
 *   <li>Supports transactions for safe database writes.</li>
 *   <li>Logs key actions and errors using {@link Logger} from Log4j2.</li>
 *   <li>Implements the {@link ICharacterService} interface to provide a standard contract for character operations.</li>
 * </ul>
 *
 * @see Character
 * @see ICharacterService
 */
public class CharacterService implements ICharacterService {

    private static final Logger logger = LogManager.getLogger(CharacterService.class);
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("joustAsEasyPU");

    @Override
    public List<Character> getAllCharacters() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Character c", Character.class).getResultList();
        } catch (Exception e) {
            logger.error("Error retrieving all characters", e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Character> getCharactersByHouseKey(String houseKey) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Character c WHERE c.house.houseKey = :houseKey", Character.class)
                    .setParameter("houseKey", houseKey)
                    .getResultList();
        } catch (Exception e) {
            logger.error("Error retrieving characters for houseKey: {}", houseKey, e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Character getCharacterByCharacterKey(String characterKey) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Character c WHERE c.characterKey = :characterKey", Character.class)
                    .setParameter("characterKey", characterKey)
                    .getSingleResult();
        } catch (Exception e) {
            logger.error("Error retrieving character with key: {}", characterKey, e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void insertCharacter(Character newCharacter) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(newCharacter);
            em.getTransaction().commit();
            logger.info("Inserted new character: {}", newCharacter.getName());
        } catch (Exception e) {
            logger.error("Error inserting character: {}", newCharacter.getName(), e);
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
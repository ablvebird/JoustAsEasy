package org.app.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.app.entities.Character;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * The {@code CharacterService} class provides service methods to manage {@link Character} entities.
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
 * </ul>
 *
 * @see Character
 */
public class CharacterService {

    /** Logger to log important information and error messages for character operations. */
    private static final Logger logger = LogManager.getLogger(CharacterService.class);

    /** The {@link EntityManagerFactory} for managing database connections. */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("joustAsEasyPU");

    /**
     * Retrieves all characters from the database.
     *
     * <p>This method uses a JPQL query to fetch all {@link Character} entities from the database.</p>
     *
     * @return A list of all characters, or {@code null} if an error occurs.
     */
    public List<Character> getAllCharacters() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Character c", Character.class).getResultList();
        } catch (Exception e) {
            logger.error("Error retrieving all characters", e);
            return null;
        } finally {
            em.close();  // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Retrieves all characters associated with a specific house, identified by its house key.
     *
     * <p>This method uses a JPQL query to find all {@link Character} entities that belong to the specified house.</p>
     *
     * @param houseKey The unique key of the house whose characters are to be retrieved.
     * @return A list of characters associated with the house, or {@code null} if an error occurs.
     */
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
            em.close();  // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Retrieves a specific character from the database by its unique character key.
     *
     * <p>This method uses a JPQL query to find the {@link Character} entity with the specified key.</p>
     *
     * @param characterKey The unique key of the character to be retrieved.
     * @return The character with the given key, or {@code null} if no such character is found or if an error occurs.
     */
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
            em.close();  // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Inserts a new character into the database.
     *
     * <p>This method opens a transaction, persists the new {@link Character} entity, and commits the transaction.
     * If an error occurs during the transaction, it is rolled back to ensure data integrity.</p>
     *
     * @param newCharacter The {@code Character} entity to be inserted into the database.
     */
    public void insertCharacter(Character newCharacter) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();  // Start transaction
            em.persist(newCharacter);     // Insert character into the database
            em.getTransaction().commit(); // Commit the transaction
            logger.info("Inserted new character: {}", newCharacter.getName());
        } catch (Exception e) {
            logger.error("Error inserting character: {}", newCharacter.getName(), e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();  // Rollback if an error occurs
            }
        } finally {
            em.close();  // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Closes the {@link EntityManagerFactory} when no longer needed.
     *
     * <p>This method ensures that the {@code EntityManagerFactory} is properly closed to release
     * any resources held by the persistence unit.</p>
     */
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            logger.info("EntityManagerFactory closed.");
        }
    }
}

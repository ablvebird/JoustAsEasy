package org.app.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.app.entities.House;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * The {@code HouseService} class provides service methods to manage {@link House} entities.
 *
 * <p>This class handles database operations such as retrieving all houses, retrieving a house by its key,
 * and inserting new houses into the database using JPA's {@link EntityManager}.</p>
 *
 * <h2>Key Features:</h2>
 * <ul>
 *   <li>Handles the lifecycle of {@link EntityManager} and performs transactions for house entities.</li>
 *   <li>Supports eager fetching of related characters using a {@code JOIN FETCH} query.</li>
 *   <li>Logs key actions, such as retrieval and insertion of houses, using the {@link Logger} from Log4j2.</li>
 * </ul>
 *
 * @see House
 */
public class HouseService {

    /** Logger for logging information and errors related to house operations. */
    private static final Logger logger = LogManager.getLogger(HouseService.class);

    /** The {@link EntityManagerFactory} for managing database connections. */
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("joustAsEasyPU");

    /**
     * Retrieves all houses from the database with their associated characters eagerly fetched.
     *
     * <p>This method uses a JPQL query with {@code LEFT JOIN FETCH} to retrieve houses along with their
     * characters in a single query, reducing the need for multiple database calls.</p>
     *
     * @return A list of all houses with their characters eagerly fetched, or {@code null} if an error occurs.
     */
    public List<House> getAllHouses() {
        EntityManager em = emf.createEntityManager();
        try {
            // Fetch houses with characters using JOIN FETCH to prevent lazy loading issues
            return em.createQuery("SELECT h FROM House h LEFT JOIN FETCH h.characters", House.class).getResultList();
        } catch (Exception e) {
            logger.error("Error retrieving all houses", e);
            return null;
        } finally {
            em.close(); // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Retrieves a house from the database by its unique house key.
     *
     * <p>This method uses a JPQL query to find the house based on its {@code houseKey}.</p>
     *
     * @param houseKey The unique key of the house to be retrieved.
     * @return The house with the given key, or {@code null} if no such house is found or if an error occurs.
     */
    public House getHouseByHouseKey(String houseKey) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT h FROM House h WHERE h.houseKey = :houseKey", House.class)
                    .setParameter("houseKey", houseKey)
                    .getSingleResult();
        } catch (Exception e) {
            logger.error("Error retrieving house with key: {}", houseKey, e);
            return null;
        } finally {
            em.close(); // Ensure the EntityManager is closed to free resources
        }
    }

    /**
     * Inserts a new house into the database.
     *
     * <p>This method opens a transaction, persists the new {@link House} entity, and commits the transaction.
     * If any error occurs, the transaction is rolled back.</p>
     *
     * @param newHouse The {@code House} entity to be inserted into the database.
     */
    public void insertHouse(House newHouse) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin(); // Start transaction
            em.persist(newHouse); // Insert the house into the database
            em.getTransaction().commit(); // Commit the transaction
            logger.info("Inserted new house: {}", newHouse.getName());
        } catch (Exception e) {
            logger.error("Error inserting house: {}", newHouse.getName(), e);
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Rollback if an error occurs
            }
        } finally {
            em.close(); // Ensure the EntityManager is closed to free resources
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

package org.app.services.interfaces;

import org.app.entities.House;
import java.util.List;

/**
 * Interface defining the contract for House-related operations.
 * This interface establishes all possible operations that can be performed with House entities,
 * providing a clear contract for any implementing class.
 */
public interface IHouseService {
    /**
     * Retrieves all houses from the data store.
     *
     * @return List of all houses with their associated characters, or null if an error occurs
     */
    List<House> getAllHouses();

    /**
     * Retrieves a specific house by its unique key.
     *
     * @param houseKey the unique identifier of the house
     * @return the house with the specified key, or null if not found or if an error occurs
     */
    House getHouseByHouseKey(String houseKey);

    /**
     * Persists a new house in the data store.
     *
     * @param house the house entity to be persisted
     */
    void insertHouse(House house);

    /**
     * Releases any resources held by the service.
     */
    void close();
}
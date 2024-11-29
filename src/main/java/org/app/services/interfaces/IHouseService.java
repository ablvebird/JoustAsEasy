package org.app.services.interfaces;

import org.app.entities.House;
import java.util.List;

/**
 * Service interface for managing House entities in the jousting system.
 * Provides core operations for retrieving and persisting house data,
 * including their associated characters relationships.
 */
public interface IHouseService {
    /**
     * Retrieves all houses with their associated characters.
     */
    List<House> getAllHouses();

    /**
     * Finds a specific house by its unique identifier.
     */
    House getHouseByHouseKey(String houseKey);

    /**
     * Saves a new house to the data store.
     */
    void insertHouse(House house);

    /**
     * Cleans up resources when the service is no longer needed.
     */
    void close();
}
package org.app.services.interfaces;

import org.app.entities.Character;
import java.util.List;

/**
 * Service interface for managing Character entities in the jousting system.
 * Provides operations for retrieving and persisting character data,
 * including queries based on house affiliations.
 */
public interface ICharacterService {
    /**
     * Retrieves all characters in the system.
     */
    List<Character> getAllCharacters();

    /**
     * Retrieves all characters belonging to a specific house.
     */
    List<Character> getCharactersByHouseKey(String houseKey);

    /**
     * Finds a specific character by their unique identifier.
     */
    Character getCharacterByCharacterKey(String characterKey);

    /**
     * Saves a new character to the data store.
     */
    void insertCharacter(Character character);

    /**
     * Cleans up resources when the service is no longer needed.
     */
    void close();
}
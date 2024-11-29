package org.app.services.interfaces;

import org.app.entities.Character;
import java.util.List;

/**
 * Interface defining the contract for Character-related operations.
 * This interface establishes all possible operations that can be performed with Character entities,
 * providing a clear contract for any implementing class.
 */
public interface ICharacterService {
    /**
     * Retrieves all characters from the data store.
     *
     * @return List of all characters, or null if an error occurs
     */
    List<Character> getAllCharacters();

    /**
     * Retrieves all characters associated with a specific house.
     *
     * @param houseKey The unique key of the house whose characters are to be retrieved
     * @return List of characters belonging to the specified house, or null if an error occurs
     */
    List<Character> getCharactersByHouseKey(String houseKey);

    /**
     * Retrieves a specific character by its unique key.
     *
     * @param characterKey The unique key of the character to retrieve
     * @return The character with the specified key, or null if not found or if an error occurs
     */
    Character getCharacterByCharacterKey(String characterKey);

    /**
     * Persists a new character in the data store.
     *
     * @param character The character entity to be persisted
     */
    void insertCharacter(Character character);

    /**
     * Releases any resources held by the service.
     */
    void close();
}

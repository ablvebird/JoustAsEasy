package org.app.services.interfaces;

import org.app.entities.Bout;
import java.util.List;

/**
 * Interface defining the contract for Bout-related operations.
 * This interface establishes all possible operations that can be performed with Bout entities,
 * providing a clear contract for any implementing class.
 *
 * <p>The interface supports various query operations specific to jousting tournaments,
 * including filtering by tourney name and attacker, as well as precise and partial key searches.</p>
 */
public interface IBoutService {
    /**
     * Retrieves all bouts from the data store.
     *
     * @return List of all bouts, or null if an error occurs
     */
    List<Bout> getAllBouts();

    /**
     * Retrieves bouts by tournament name.
     *
     * @param tourney The name of the tournament
     * @return List of bouts in the specified tournament, or null if an error occurs
     */
    List<Bout> getBoutsByTourney(String tourney);

    /**
     * Retrieves bouts for a specific tournament and attacker.
     *
     * @param tourney The name of the tournament
     * @param attackingCharacterKey The key of the attacking character
     * @return List of bouts matching both criteria, or null if an error occurs
     */
    List<Bout> getBoutsByTourneyAndAttacker(String tourney, String attackingCharacterKey);

    /**
     * Retrieves a bout by its exact key.
     *
     * @param boutKey The unique identifier of the bout
     * @return The bout with the specified key, or null if not found or if an error occurs
     */
    Bout getBoutByBoutPreciseKey(String boutKey);

    /**
     * Retrieves bouts by partial key match.
     *
     * @param boutKey The partial key to match against
     * @return List of bouts whose keys start with the specified partial key, or null if an error occurs
     */
    List<Bout> getBoutsByBoutPartialKey(String boutKey);

    /**
     * Persists a new bout in the data store.
     *
     * @param bout The bout entity to be persisted
     */
    void insertBout(Bout bout);

    /**
     * Releases any resources held by the service.
     */
    void close();
}
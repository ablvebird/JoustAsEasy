package org.app.model;

import org.app.entities.Character;

/**
 * The {@code BoutMaker} class is responsible for simulating the generation of points for characters during a bout.
 *
 * <p>The points are generated based on a random dice roll (1d20) multiplied by a character's skill level as a percentage of 100.</p>
 *
 * <h2>Usage:</h2>
 * <p>The {@link #generatePoints(Character)} method is used to generate the attack or defense points for a character in a jousting match.</p>
 */
public class BoutMaker {

    /**
     * Generates points for a character during a bout based on their skill level.
     *
     * <p>The points are determined by simulating a dice roll (1d20) and then multiplying the result by the character's skill level
     * divided by 10. The higher the character's skill level, the higher their potential points.</p>
     *
     * <p>This method introduces randomness to simulate the unpredictability of jousting, where even a skilled character
     * may have variable results.</p>
     *
     * @param character The {@link Character} for which points are being generated.
     * @return The calculated points for the character during a bout.
     */
    public static int generatePoints(Character character) {
        // Simulate 1d20 roll and multiply by (skillLevel / 100)
        return (int) ((Math.random() * 20 + 1) * (character.getSkillLevel() / 10.0));
    }
}

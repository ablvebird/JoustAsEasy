package org.data;

import java.util.List;
import java.util.Random;

import org.crud.BoutCRUD;
import org.entities.Bout;
import org.entities.Character;

public class BoutGenerator {


    /*Method that receives a list of character and:
    1) Divides them into houses with CharacterCRUD's public static List<Character> getCharactersByHouseKey(String houseKey)
    2) Each character from each house must face every other characters from the other houses (characters from the same House never face each other)
    3) Creates a new Bout with the tourney and characters info, adding the points of attacker and defender with a random number between 0 and 500
    4) The Bout is persisted in the database
    5) The Tourney is completed when each character from each house has faced as an attacker every other chracters from the other houses
    6) This can be divided into different methods for modularity, but they all need to be static, since they will be handled later from the Main class
     */

    public static void generateTourneyBouts(List<Character> characters, String tourneyName) {
        // Iterate over each character in the list as an attacker
        for (Character attacker : characters) {
            // For each attacker, iterate over all characters in the list as a defender
            for (Character defender : characters) {
                // Check if the attacker and defender are from different houses
                if (!attacker.getHouse().getHouseKey().equals(defender.getHouse().getHouseKey())) {
                    // If they are from different houses, generate a bout
                    generateBout(attacker, defender, tourneyName);
                }
            }
        }
    }

    private static void generateBout(Character attacker, Character defender, String tourneyName) {
       BoutCRUD.insertBout(new Bout(
               attacker.getCharacterKey()+defender.getCharacterKey()+"T01",
               tourneyName,
               generateRandomPoints(),
               generateRandomPoints(),
               attacker,
               defender
       ));
    }
    private static int generateRandomPoints() {
        // Generate a random number between 0 and 500 for points
        return new Random().nextInt(501);
    }
}

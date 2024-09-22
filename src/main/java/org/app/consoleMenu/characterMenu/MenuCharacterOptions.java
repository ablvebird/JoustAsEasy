package org.app.consoleMenu.characterMenu;

import org.app.entities.Character;
import org.app.entities.House;
import org.app.services.CharacterService;
import org.app.services.HouseService;

import java.util.List;
import java.util.Scanner;

/**
 * The {@code MenuCharacterOptions} class provides the logic for handling character-related operations
 * such as listing all characters, adding a new character, or querying characters by their house or character key.
 *
 * <p>This class interacts with the {@link CharacterService} to manage characters and {@link HouseService} to fetch houses
 * for associating characters with their respective houses.</p>
 */
public class MenuCharacterOptions {

    private final CharacterService characterService;
    private final HouseService houseService;

    /**
     * Constructs a new {@code MenuCharacterOptions} and initializes the {@link CharacterService} and {@link HouseService}.
     */
    public MenuCharacterOptions() {
        characterService = new CharacterService();
        houseService = new HouseService();  // Initialize HouseService here
    }

    /**
     * Lists all characters stored in the database by fetching them from the {@link CharacterService}.
     * Displays the characters in the console, or notifies the user if no characters are found.
     */
    public void listAllCharacters() {
        List<Character> characters = characterService.getAllCharacters();
        if (characters != null && !characters.isEmpty()) {
            System.out.println("\n--- Characters ---");
            for (Character character : characters) {
                System.out.println(character);
            }
        } else {
            System.out.println("No characters found.");
        }
    }

    /**
     * Adds a new character to the database. The user is prompted to input the character's key, name,
     * birthplace, weapon, skill level, and the house key to associate the character with a house.
     * If the house key is invalid, the character is not added.
     *
     * @param scanner {@link Scanner} for capturing user input.
     */
    public void addNewCharacter(Scanner scanner) {
        System.out.print("Enter character key: ");
        String characterKey = scanner.nextLine();
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();
        System.out.print("Enter birthplace: ");
        String birthplace = scanner.nextLine();
        System.out.print("Enter weapon: ");
        String weapon = scanner.nextLine();
        System.out.print("Enter skill level (integer): ");
        int skillLevel = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter house key (to assign character): ");
        String houseKey = scanner.nextLine();

        // Fetch house by key to associate the character with it
        House house = houseService.getHouseByHouseKey(houseKey);

        if (house != null) {
            Character newCharacter = new Character(characterKey, name, birthplace, weapon, skillLevel, house);
            characterService.insertCharacter(newCharacter);
            System.out.println("Character added successfully.");
        } else {
            System.out.println("House with key " + houseKey + " not found. Character not added.");
        }
    }

    /**
     * Queries and displays all characters associated with a specific house key. The user is prompted
     * to enter the house key, and the characters associated with the house are displayed.
     *
     * @param scanner {@link Scanner} for capturing user input.
     */
    public void queryCharactersByHouseKey(Scanner scanner) {
        System.out.print("Enter house key: ");
        String houseKey = scanner.nextLine();

        List<Character> characters = characterService.getCharactersByHouseKey(houseKey);
        if (characters != null && !characters.isEmpty()) {
            System.out.println("\nCharacters in House " + houseKey + ":");
            for (Character character : characters) {
                System.out.println(character);
            }
        } else {
            System.out.println("No characters found for the house key: " + houseKey);
        }
    }

    /**
     * Queries and displays a character by their unique character key. The user is prompted
     * to enter the character key, and the corresponding character is displayed if found.
     *
     * @param scanner {@link Scanner} for capturing user input.
     */
    public void queryCharacterByKey(Scanner scanner) {
        System.out.print("Enter character key: ");
        String characterKey = scanner.nextLine();

        Character character = characterService.getCharacterByCharacterKey(characterKey);
        if (character != null) {
            System.out.println("\nCharacter found: " + character);
        } else {
            System.out.println("Character with key '" + characterKey + "' not found.");
        }
    }
}

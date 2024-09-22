package org.app.consoleMenu.boutMenu;

import org.app.entities.Bout;
import org.app.model.BoutMaker;
import org.app.services.BoutService;
import org.app.services.CharacterService;
import org.app.entities.Character;

import java.util.List;
import java.util.Scanner;

/**
 * The {@code MenuBoutOptions} class provides the logic for handling bout-related operations
 * such as listing all bouts, adding new bouts, simulating a bout, or querying bouts by specific criteria.
 *
 * <p>This class interacts with the {@link BoutService} to manage bouts and {@link CharacterService} to fetch
 * characters that participate in bouts.</p>
 */
public class MenuBoutOptions {

    private final BoutService boutService;
    private final CharacterService characterService;

    /**
     * Constructs a new {@code MenuBoutOptions} and initializes the {@link BoutService} and {@link CharacterService}.
     */
    public MenuBoutOptions() {
        boutService = new BoutService();
        characterService = new CharacterService();
    }

    /**
     * Lists all bouts stored in the database by fetching them from the {@link BoutService}.
     * Displays the bouts in the console, or notifies the user if no bouts are found.
     */
    public void listAllBouts() {
        List<Bout> bouts = boutService.getAllBouts();
        if (bouts != null && !bouts.isEmpty()) {
            System.out.println("\n--- Bouts ---");
            for (Bout bout : bouts) {
                System.out.println(bout);
            }
        } else {
            System.out.println("No bouts found.");
        }
    }

    /**
     * Adds a new bout to the database. The user is prompted to input the bout's key, tourney name, attacker and defender keys,
     * and the points for both the attacker and defender. The bout is added if valid character keys are provided.
     *
     * @param scanner {@link Scanner} for capturing user input.
     */
    public void addNewBout(Scanner scanner) {
        System.out.print("Enter bout key: ");
        String boutKey = scanner.nextLine();
        System.out.print("Enter tourney name: ");
        String tourney = scanner.nextLine();
        System.out.print("Enter attacker key: ");
        String attackerKey = scanner.nextLine();
        System.out.print("Enter defender key: ");
        String defenderKey = scanner.nextLine();
        System.out.print("Enter attacker points (integer): ");
        int attackerPoints = scanner.nextInt();
        System.out.print("Enter defender points (integer): ");
        int defenderPoints = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Fetch attacker and defender by their character keys
        Character attacker = characterService.getCharacterByCharacterKey(attackerKey);
        Character defender = characterService.getCharacterByCharacterKey(defenderKey);

        // If valid characters, create a new bout
        if (attacker != null && defender != null) {
            Bout newBout = new Bout(boutKey, tourney, attackerPoints, defenderPoints, attacker, defender);
            boutService.insertBout(newBout);
            System.out.println("Bout added successfully.");
        } else {
            System.out.println("Invalid attacker or defender key. Please try again.");
        }
    }

    /**
     * Simulates a bout by generating points for the attacker and defender using the {@link BoutMaker} class.
     * The user is prompted to enter bout details such as keys for both the attacker and defender.
     *
     * @param scanner {@link Scanner} for capturing user input.
     */
    public void simulateBout(Scanner scanner) {
        System.out.print("Enter bout key: ");
        String boutKey = scanner.nextLine();
        System.out.print("Enter tourney name: ");
        String tourney = scanner.nextLine();
        System.out.print("Enter attacker key: ");
        String attackerKey = scanner.nextLine();
        System.out.print("Enter defender key: ");
        String defenderKey = scanner.nextLine();

        // Generate points for attacker and defender
        int attackerPoints = BoutMaker.generatePoints(characterService.getCharacterByCharacterKey(attackerKey));
        int defenderPoints = BoutMaker.generatePoints(characterService.getCharacterByCharacterKey(defenderKey));

        Character attacker = characterService.getCharacterByCharacterKey(attackerKey);
        Character defender = characterService.getCharacterByCharacterKey(defenderKey);

        if (attacker != null && defender != null) {
            Bout newBout = new Bout(boutKey, tourney, attackerPoints, defenderPoints, attacker, defender);
            boutService.insertBout(newBout);
            System.out.println("Simulated bout added successfully.");
        } else {
            System.out.println("Invalid attacker or defender key. Please try again.");
        }
    }

    /**
     * Queries and displays all bouts in a specific tourney. The user is prompted
     * to enter the tourney name, and the corresponding bouts are displayed.
     *
     * @param scanner {@link Scanner} for capturing user input.
     */
    public void queryBoutsByTourney(Scanner scanner) {
        System.out.print("Enter tourney name: ");
        String tourney = scanner.nextLine();

        List<Bout> bouts = boutService.getBoutsByTourney(tourney);
        if (bouts != null && !bouts.isEmpty()) {
            System.out.println("\nBouts in Tourney '" + tourney + "':");
            for (Bout bout : bouts) {
                System.out.println(bout);
            }
        } else {
            System.out.println("No bouts found for tourney: " + tourney);
        }
    }

    /**
     * Queries and displays all bouts in a specific tourney where a given character is the attacker.
     * The user is prompted to enter the tourney name and the attacker's key.
     *
     * @param scanner {@link Scanner} for capturing user input.
     */
    public void queryBoutsByTourneyAndAttacker(Scanner scanner) {
        System.out.print("Enter tourney name: ");
        String tourney = scanner.nextLine();
        System.out.print("Enter attacker key: ");
        String attackerKey = scanner.nextLine();

        List<Bout> bouts = boutService.getBoutsByTourneyAndAttacker(tourney, attackerKey);
        if (bouts != null && !bouts.isEmpty()) {
            System.out.println("\nBouts in Tourney '" + tourney + "' with Attacker '" + attackerKey + "':");
            for (Bout bout : bouts) {
                System.out.println(bout);
            }
        } else {
            System.out.println("No bouts found for tourney: " + tourney + " and attacker: " + attackerKey);
        }
    }

    /**
     * Queries and displays a bout by its unique bout key. The user is prompted
     * to enter the bout key, and the corresponding bout is displayed if found.
     *
     * @param scanner {@link Scanner} for capturing user input.
     */
    public void queryBoutByKey(Scanner scanner) {
        System.out.print("Enter bout key: ");
        String boutKey = scanner.nextLine();

        Bout bout = boutService.getBoutByBoutPreciseKey(boutKey);
        if (bout != null) {
            System.out.println("\nBout found: " + bout);
        } else {
            System.out.println("Bout with key '" + boutKey + "' not found.");
        }
    }
}

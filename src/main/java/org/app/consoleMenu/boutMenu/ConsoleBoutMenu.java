package org.app.consoleMenu.boutMenu;

import java.util.Scanner;

public class ConsoleBoutMenu {

    private final MenuBoutOptions boutOptions;

    public ConsoleBoutMenu() {
        boutOptions = new MenuBoutOptions();
    }

    public void showBoutMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Bout Menu ---");
            System.out.println("1. List all Bouts");
            System.out.println("2. Add a new Bout");
            System.out.println("3. Simulate a new Bout");
            System.out.println("4. Query Bouts by Tourney");
            System.out.println("5. Query Bouts by Tourney and Attacker");
            System.out.println("6. Query Bout by Bout Key");
            System.out.println("7. Back to Main Menu");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    boutOptions.listAllBouts();
                    break;
                case 2:
                    boutOptions.addNewBout(scanner);
                    break;
                case 3:
                    boutOptions.simulateBout(scanner);
                    break;
                case 4:
                    boutOptions.queryBoutsByTourney(scanner);
                    break;
                case 5:
                    boutOptions.queryBoutsByTourneyAndAttacker(scanner);
                    break;
                case 6:
                    boutOptions.queryBoutByKey(scanner);
                    break;
                case 7:
                    System.out.println("Returning to Main Menu...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

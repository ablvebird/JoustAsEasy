package org.app.consoleMenu.characterMenu;

import java.util.Scanner;

public class ConsoleCharacterMenu {

    private final MenuCharacterOptions characterOptions;

    public ConsoleCharacterMenu() {
        characterOptions = new MenuCharacterOptions();
    }

    public void showCharacterMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Character Menu ---");
            System.out.println("1. List all Characters");
            System.out.println("2. Add a new Character");
            System.out.println("3. Query Characters by House Key");
            System.out.println("4. Query Character by Character Key");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    characterOptions.listAllCharacters();
                    break;
                case 2:
                    characterOptions.addNewCharacter(scanner);
                    break;
                case 3:
                    characterOptions.queryCharactersByHouseKey(scanner);
                    break;
                case 4:
                    characterOptions.queryCharacterByKey(scanner);
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

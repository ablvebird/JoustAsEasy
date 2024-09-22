package org.app.consoleMenu;

import java.util.Scanner;

/**
 * The {@code ConsoleMainMenu} class is responsible for displaying the main menu in the console application.
 * It allows users to navigate to different service menus such as House, Character, and Bout services, or to exit the application.
 *
 * <p>This class interacts with {@link MenuMainOptions}, which handles the logic for displaying and managing the options for each service.</p>
 *
 * <h2>Usage:</h2>
 * <p>Create an instance of {@code ConsoleMainMenu} and call {@link #showMainMenu()} to display the main menu to the user.</p>
 */
public class ConsoleMainMenu {

    private final MenuMainOptions mainOptions;

    /**
     * Constructs a new {@code ConsoleMainMenu} and initializes the main options.
     */
    public ConsoleMainMenu() {
        mainOptions = new MenuMainOptions();
    }

    /**
     * Displays the main menu and handles user input to navigate to the corresponding service menus.
     *
     * <p>This method continuously displays the main menu until the user chooses the "Exit" option.</p>
     */
    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. House Services");
            System.out.println("2. Character Services");
            System.out.println("3. Bout Services");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    mainOptions.showHouseOptions();
                    break;
                case 2:
                    mainOptions.showCharacterOptions();
                    break;
                case 3:
                    mainOptions.showBoutOptions();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close(); // Closes the scanner to prevent resource leaks
    }
}

package org.app.consoleMenu.houseMenu;

import java.util.Scanner;

/**
 * The {@code ConsoleHouseMenu} class handles the display of the house-related menu and manages user interactions for house services.
 * This class interacts with the {@link MenuHouseOptions} class to execute operations such as listing all houses, adding a new house,
 * or querying a house by its key.
 *
 * <p>It provides a simple console-based interface where users can select various house-related options. The input is handled using a {@link Scanner},
 * and the selected option triggers the corresponding method in {@link MenuHouseOptions}.</p>
 *
 * <h2>Usage:</h2>
 * <p>To display the house menu and allow users to interact with it, the {@link #showHouseMenu()} method is invoked. This method will loop
 * until the user chooses to exit the house services section.</p>
 */
public class ConsoleHouseMenu {

    private final MenuHouseOptions houseOptions;

    /**
     * Constructs a new {@code ConsoleHouseMenu} and initializes the {@link MenuHouseOptions}.
     */
    public ConsoleHouseMenu() {
        houseOptions = new MenuHouseOptions();
    }

    /**
     * Displays the house-related menu options and handles user input.
     * The menu allows users to list all houses, add a new house, query a house by key, or return to the main menu.
     * The user input is gathered using the {@link Scanner} class.
     */
    public void showHouseMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Display the menu options
            System.out.println("\n--- House Services ---");
            System.out.println("1. List all Houses");
            System.out.println("2. Add a new House");
            System.out.println("3. Query House by Key");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");

            // Get user input
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline after integer input

            // Handle the selected option
            switch (option) {
                case 1:
                    // List all houses
                    houseOptions.listAllHouses();
                    break;
                case 2:
                    // Add a new house
                    houseOptions.addNewHouse(scanner);
                    break;
                case 3:
                    // Query a house by its key
                    houseOptions.queryHouseByKey(scanner);
                    break;
                case 4:
                    // Exit the house menu
                    exit = true;
                    break;
                default:
                    // Handle invalid input
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

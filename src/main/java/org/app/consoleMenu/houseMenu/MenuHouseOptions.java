package org.app.consoleMenu.houseMenu;

import org.app.services.HouseService;
import org.app.entities.House;

import java.util.Scanner;

/**
 * The {@code MenuHouseOptions} class handles all operations related to house management.
 * It interacts with the {@link HouseService} to retrieve, add, and query house data.
 *
 * <p>This class provides methods that are triggered by the console menu options to display all houses,
 * add a new house, or search for a house by its key.</p>
 *
 * <h2>Usage:</h2>
 * <p>The class is called by the main menu, where each option corresponds to a specific method in this class.
 * The {@link Scanner} object is used to gather input from the user for operations like adding or querying a house.</p>
 */
public class MenuHouseOptions {

    private final HouseService houseService;

    /**
     * Constructs a new {@code MenuHouseOptions} and initializes the {@link HouseService}.
     */
    public MenuHouseOptions() {
        houseService = new HouseService();
    }

    /**
     * Lists all houses by calling the {@link HouseService#getAllHouses()} method.
     * If houses are found, they are printed to the console; otherwise, a message indicating that no houses were found is displayed.
     */
    public void listAllHouses() {
        var houses = houseService.getAllHouses();
        if (houses != null && !houses.isEmpty()) {
            System.out.println("\n--- Houses ---");
            for (House house : houses) {
                System.out.println(house);
            }
        } else {
            System.out.println("No houses found.");
        }
    }

    /**
     * Adds a new house to the system based on user input.
     * The method prompts the user to enter details such as the house key, name, founder, and region.
     * This information is then used to create a new {@link House} object, which is passed to the {@link HouseService#insertHouse(House)} method.
     *
     * @param scanner The {@link Scanner} object used to gather input from the user.
     */
    public void addNewHouse(Scanner scanner) {
        System.out.print("Enter house key: ");
        String houseKey = scanner.nextLine();
        System.out.print("Enter house name: ");
        String name = scanner.nextLine();
        System.out.print("Enter house founder: ");
        String founder = scanner.nextLine();
        System.out.print("Enter house region: ");
        String region = scanner.nextLine();

        House newHouse = new House(founder, name, region, houseKey);
        houseService.insertHouse(newHouse);
    }

    /**
     * Queries the system for a house based on the house key provided by the user.
     * If a matching house is found, it is printed to the console; otherwise, a message indicating the house was not found is displayed.
     *
     * @param scanner The {@link Scanner} object used to gather input from the user.
     */
    public void queryHouseByKey(Scanner scanner) {
        System.out.print("Enter house key: ");
        String houseKey = scanner.nextLine();

        House house = houseService.getHouseByHouseKey(houseKey);
        if (house != null) {
            System.out.println("\nHouse found: " + house);
        } else {
            System.out.println("House with key '" + houseKey + "' not found.");
        }
    }
}

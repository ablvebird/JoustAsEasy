package org.app.consoleMenu;

import org.app.consoleMenu.boutMenu.ConsoleBoutMenu;
import org.app.consoleMenu.characterMenu.ConsoleCharacterMenu;
import org.app.consoleMenu.houseMenu.ConsoleHouseMenu;

/**
 * The {@code MenuMainOptions} class manages the display and navigation between the different service options
 * in the application's main menu.
 *
 * <p>This class connects the main menu with specific sub-menus for House, Character, and Bout services. It instantiates
 * the relevant console menu classes and delegates the display of menu options to each of them.</p>
 *
 * <h2>Usage:</h2>
 * <p>Call the {@link #showHouseOptions()}, {@link #showCharacterOptions()}, or {@link #showBoutOptions()} methods to navigate
 * to the respective service menus from the main menu.</p>
 */
public class MenuMainOptions {

    private final ConsoleBoutMenu consoleBoutMenu;
    private final ConsoleHouseMenu consoleHouseMenu;
    private final ConsoleCharacterMenu consoleCharacterMenu;

    /**
     * Constructs a new {@code MenuMainOptions} object and initializes the sub-menu options for House, Character, and Bout services.
     */
    public MenuMainOptions() {
        consoleBoutMenu = new ConsoleBoutMenu();
        consoleHouseMenu = new ConsoleHouseMenu();
        consoleCharacterMenu = new ConsoleCharacterMenu();
    }

    /**
     * Displays the House Services menu.
     *
     * <p>This method delegates to the {@code ConsoleHouseMenu} class to handle the display and actions of the House Services menu.</p>
     */
    public void showHouseOptions() {
        System.out.println("\n--- House Services ---");
        consoleHouseMenu.showHouseMenu();
    }

    /**
     * Displays the Character Services menu.
     *
     * <p>This method delegates to the {@code ConsoleCharacterMenu} class to handle the display and actions of the Character Services menu.</p>
     */
    public void showCharacterOptions() {
        System.out.println("\n--- Character Services ---");
        consoleCharacterMenu.showCharacterMenu();
    }

    /**
     * Displays the Bout Services menu.
     *
     * <p>This method delegates to the {@code ConsoleBoutMenu} class to handle the display and actions of the Bout Services menu.</p>
     */
    public void showBoutOptions() {
        System.out.println("\n--- Bout Services ---");
        consoleBoutMenu.showBoutMenu();
    }
}

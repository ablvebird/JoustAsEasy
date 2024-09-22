package org.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.app.consoleMenu.ConsoleMainMenu;

/**
 * Main class responsible for launching the application.
 *
 * <p>This is the entry point of the program. It initializes and displays the main console menu,
 * providing the user with options to interact with the system.
 *
 * <h2>Logging</h2>
 * The application uses Log4j 2 for logging. This allows us to monitor key events like the
 * application start, important actions, and errors.
 *
 * <h2>Logging Levels:</h2>
 * <ul>
 *  <li><strong>INFO:</strong> Indicates the successful initialization and normal operation of the application.</li>
 *  <li><strong>ERROR:</strong> Reserved for critical issues during the application runtime.</li>
 * </ul>
 *
 * <p>Make sure to configure Log4j properly by setting up the <code>log4j2.properties</code>
 * file in the <code>src/main/resources</code> directory for a consistent and effective logging environment.</p>
 *
 * <h3>Example Log Output:</h3>
 * <pre>
 * [INFO] Iniciando la aplicación...
 * [INFO] Usuario ha seleccionado la opción 1: House Services
 * [ERROR] Error al intentar persistir la entidad de House.
 * </pre>
 *
 * @see org.app.consoleMenu.ConsoleMainMenu
 */
public class Main {

    /**
     * The logger for this class. Uses Log4j 2 to log application events and errors.
     */
    private static final Logger logger = LogManager.getLogger(Main.class);

    /**
     * The main method serves as the entry point for the application.
     *
     * <p>It initializes the main console menu and invokes it to interact with the user.
     * The logging system is also initialized here to track application events.
     * </p>
     *
     * @param args Command-line arguments (currently not in use).
     */
    public static void main(String[] args) {
        // Log the initialization of the application
        logger.info("Iniciando la aplicación...");

        // Instantiate and display the main menu for user interaction
        ConsoleMainMenu mainMenu = new ConsoleMainMenu();
        mainMenu.showMainMenu();
    }
}

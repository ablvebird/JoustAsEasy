package org.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.app.consoleMenu.ConsoleMainMenu;

/**
 * Application entry point that launches the main console menu system.
 * Utilizes Log4j 2 for event tracking and error monitoring.
 * Configuration details can be found in log4j2.properties.
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    /**
     * Initializes the console menu interface and logging system.
     */
    public static void main(String[] args) {
        logger.info("Iniciando la aplicación...");
        ConsoleMainMenu mainMenu = new ConsoleMainMenu();
        mainMenu.showMainMenu();
    }
}
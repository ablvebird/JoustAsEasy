package org.gui;

import org.crud.BoutCRUD;
import org.crud.CharacterCRUD;
import org.crud.HouseCRUD;
import org.crud.StatCRUD;
import org.data.BoutGenerator;
import org.data.InitialData;
import org.data.Printer;
import org.data.ScannerGenerator;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class MainMenu extends JFrame {

    private JPanel mainPanel;
    private JLabel imageLabel;
    private JPanel imagePanel;
    private JPanel housePanel;
    private JButton createInitialDataButton;
    private JButton selectHousesButton;
    private JButton getHouseByHouseButton;
    private JButton insertHouseButton;
    private JPanel characterPanel;
    private JButton createInitialDataButton1;
    private JButton getAllCharactersButton;
    private JButton getCharactersByHouseButton;
    private JButton insertCharacterButton;
    private JButton createInitialDataButton2;
    private JButton createInitialDataButton3;
    private JButton getAllStatsButton;
    private JButton getStatsByCharacterButton;
    private JButton insertStatsButton;
    private JButton getAllBoutsButton;
    private JButton getBoutsByTourneyButton;
    private JButton getBoutsByAttackerButton;
    private JButton getCharacterByCharacterButton;
    private JButton getStatsByHouseButton;
    private JButton characterNavigationButton;
    private JButton exitButton;
    final String IMAGEPATH = "src/main/resources/logoSized.jpg";
    final String ICONPATH = "src/main/resources/appIcon.png";

    public MainMenu(){

        setListeners();

        // Set JFrame icon
        ImageIcon frameIcon = new ImageIcon(ICONPATH);
        setIconImage(frameIcon.getImage());

        // Set image label icon
        ImageIcon imageIcon = new ImageIcon(IMAGEPATH);
        imageLabel.setIcon(imageIcon);

        setTitle("Joust as Easy");
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setListeners(){
        setHouseListeners();
        setCharacterListeners();
        setStatListeners();
        setBoutListeners();
    }


    public void setHouseListeners(){
        createInitialDataButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                InitialData.createHouses();
            }
        });
        selectHousesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Printer.printHouseList(HouseCRUD.getAllHouses());
            }
        });
        getHouseByHouseButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Enter House key:\n STR --> Stark \n LNN --> Lannister \n TRG --> Targaryen \n MRT --> Martell \n ");
                Printer.printHouse(HouseCRUD.getHouseByHouseKey(new Scanner(System.in).nextLine()));
            }
        });
        insertHouseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ScannerGenerator.createHouse();
            }
        });
    }

    public void setCharacterListeners() {
        createInitialDataButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                InitialData.createAllCharacters();
            }
        });

        getAllCharactersButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Printer.printCharacterList(CharacterCRUD.getAllCharacters());
            }
        });

        getCharactersByHouseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Enter House key: ");
                Printer.printCharacterList(CharacterCRUD.getCharactersByHouseKey(new Scanner(System.in).nextLine()));
            }
        });

        getCharacterByCharacterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Enter Character key: ");
                Printer.printCharacter(CharacterCRUD.getCharacterByCharacterKey(new Scanner(System.in).nextLine()));
            }
        });

        insertCharacterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ScannerGenerator.createCharacter();
            }
        });

        characterNavigationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new CharacterNavigation();
            }
        });
    }

    public void setStatListeners() {
        createInitialDataButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                InitialData.createAllStats();
            }
        });

        getAllStatsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Printer.printStatList(StatCRUD.getAllStats());
            }
        });

        getStatsByCharacterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Enter Character key: ");
                Printer.printStatList(StatCRUD.getStatsByCharacterKey(new Scanner(System.in).nextLine()));
            }
        });

        getStatsByHouseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Enter House key: ");
                Printer.printStatList(StatCRUD.getStatsByHouseKey(new Scanner(System.in).nextLine()));
            }
        });

        insertStatsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ScannerGenerator.createStat();
            }
        });
    }

    public void setBoutListeners() {
        createInitialDataButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                BoutGenerator.generateTourneyBouts(CharacterCRUD.getAllCharacters(), "Tourney 01");
            }
        });

        getAllBoutsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Printer.printBoutList(BoutCRUD.getAllBouts());
            }
        });

        getBoutsByTourneyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Enter tourney name (Example: Tourney 01): ");
                Printer.printBoutList(BoutCRUD.getBoutByTourney(new Scanner(System.in).nextLine()));
            }
        });

        getBoutsByAttackerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Enter tourney name (Example: Tourney 01): ");
                String tourney = new Scanner(System.in).nextLine();

                System.out.println("Enter character key (Example: NED): ");
                String characterKey = new Scanner(System.in).nextLine();


                Printer.printBoutList(BoutCRUD.getBoutByTourneyAndAttacker(tourney, characterKey));
            }
        });
    }

}

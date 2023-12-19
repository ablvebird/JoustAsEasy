package org.main;

import org.crud.BoutCRUD;
import org.crud.CharacterCRUD;
import org.crud.HouseCRUD;
import org.crud.StatCRUD;
import org.data.BoutGenerator;
import org.data.InitialData;
import org.data.Printer;
import org.entities.Character;
import org.entities.House;
import org.entities.Stat;
import org.gui.CharacterNavigation;
import org.gui.MainMenu;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //START
        System.out.println("Welcome to Joust as Easy!");


        //HOUSE DATA
        System.out.println("1) Create initial house data");
        InitialData.createHouses();

        System.out.println("2) Print all houses in DB");
        List<House> houseList = HouseCRUD.getAllHouses();
        Printer.printHouseList(houseList);

        System.out.println("3) Select House via house_key and print it");
        House houseStark = HouseCRUD.getHouseByHouseKey("STR");
        Printer.printHouse(houseStark);

        //CHARACTER DATA
        System.out.println("4) Create initial character data");
        InitialData.createStarkCharacters();
        InitialData.createLannisterCharacters();
        InitialData.createTargaryenCharacters();
        InitialData.createMartellCharacters();

        System.out.println("5) Print all characters in DB");
        List<Character> characterList = CharacterCRUD.getAllCharacters();
        Printer.printCharacterList(characterList);

        System.out.println("6) Select characters from house via house_key in DB");
        List<Character> starkList = CharacterCRUD.getCharactersByHouseKey("STR");
        List<Character> lannisterList = CharacterCRUD.getCharactersByHouseKey("LNN");
        List<Character> targaryenList = CharacterCRUD.getCharactersByHouseKey("TRG");
        List<Character> martellList = CharacterCRUD.getCharactersByHouseKey("MRT");
        Printer.printCharacterList(starkList);

        //STATS
        System.out.println("7) Create initial stat data");
        InitialData.createStarkStats();
        InitialData.createLannisterStats();
        InitialData.createTargaryenStats();
        InitialData.createMartellStats();

        System.out.println("8) Print all stat data");
        List<Stat> statList = StatCRUD.getAllStats();
        Printer.printStatList(statList);

        System.out.println("9) Print stat data from character");
        List<Stat> nedStats = StatCRUD.getStatsByCharacterKey("NED");
        Printer.printStatList(nedStats);

        //BOUTS
        System.out.println("10) Create bout data with BoutGenerator");
        BoutGenerator.generateTourneyBouts(characterList, "Tourney 01");

        System.out.println("11) Print all bout data");
        Printer.printBoutList(BoutCRUD.getAllBouts());

        System.out.println("12) Print bout data by tourney");
        Printer.printBoutList(BoutCRUD.getBoutByTourney("Tourney 01"));

        System.out.println("13) Print attacker bout data");
        Printer.printBoutList(BoutCRUD.getBoutByTourneyAndAttacker("Tourney 01", "NED"));


        new MainMenu();

    }
}
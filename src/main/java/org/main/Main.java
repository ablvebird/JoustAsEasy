package org.main;

import org.crud.CharacterCRUD;
import org.crud.HouseCRUD;
import org.data.InitialData;
import org.data.Printer;
import org.entities.Character;
import org.entities.House;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Joust as Easy!");

        System.out.println("1) Create initial house data");
        InitialData.createHouses();

        System.out.println("2) Print all houses in DB");
        List<House> houseList = HouseCRUD.getAllHouses();
        Printer.printHouseList(houseList);

        System.out.println("3) Select House via house_key and print it");
        House houseStark = HouseCRUD.getHouseByHouseKey("STR");
        Printer.printHouse(houseStark);

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
        Printer.printCharacterList(starkList);

        System.out.println("4) Create initial stat data");


    }
}
package org.data;

import org.entities.House;
import org.entities.Character;
import java.util.List;
import java.util.Set;

public class Printer {

    //HOUSE
    public static void printHouseList(List<House> houses){
        for(House house : houses){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("House Key: " + house.getHouseKey());
            System.out.println("Name: " + house.getName());
            System.out.println("Founder: " + house.getFounder());
            System.out.println("Region: " + house.getRegion());
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        }
    }
    public static void printHouse(House house){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("House Key: " + house.getHouseKey());
            System.out.println("Name: " + house.getName());
            System.out.println("Founder: " + house.getFounder());
            System.out.println("Region: " + house.getRegion());
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }

    //CHARACTER
    public static void printCharacterList(List<Character> characters) {
        for (Character character : characters) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Character Key: " + character.getCharacterKey());
            System.out.println("Name: " + character.getName());
            System.out.println("House: " + character.getHouse().getName()); // Assuming you have a getName() method in the House class
            System.out.println("Birthplace: " + character.getBirthplace());
            System.out.println("Height: " + character.getHeight());
            System.out.println("Weight: " + character.getWeight());
            System.out.println("Weapon: " + character.getWeapon());
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        }
    }

    public static void printCharacter(Character character) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Character Key: " + character.getCharacterKey());
        System.out.println("Name: " + character.getName());
        System.out.println("House: " + character.getHouse().getName()); // Assuming you have a getName() method in the House class
        System.out.println("Birthplace: " + character.getBirthplace());
        System.out.println("Height: " + character.getHeight());
        System.out.println("Weight: " + character.getWeight());
        System.out.println("Weapon: " + character.getWeapon());
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }
}

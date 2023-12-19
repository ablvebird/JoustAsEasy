package org.data;

import org.entities.Bout;
import org.entities.House;
import org.entities.Character;
import org.entities.Stat;

import java.util.List;
import java.util.Set;

public class Printer {

    //HOUSE
    public static void printHouseList(List<House> houses){
        for(House house : houses){
            printHouse(house);
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
            printCharacter(character);
        }
    }
    public static void printCharacter(Character character) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Character Key: " + character.getCharacterKey());
        System.out.println("Name: " + character.getName());
        System.out.println("House: " + character.getHouse().getName());
        System.out.println("Birthplace: " + character.getBirthplace());
        System.out.println("Height: " + character.getHeight());
        System.out.println("Weight: " + character.getWeight());
        System.out.println("Weapon: " + character.getWeapon());
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }


    //STAT
    public static void printStatList(List<Stat> stats){
        for (Stat stat : stats){
            printStat(stat);
        }
    }
    public static void printStat(Stat stat){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Stat Key: " + stat.getStatKey());
        System.out.println("Tourney: " + stat.getTourney());
        System.out.println("Beheadings per bout: " + stat.getBeheadingsPerBout());
        System.out.println("Guttings per bout: " + stat.getGuttingsPerBout());
        System.out.println("Maimings per bout: " + stat.getMaimingsPerBout());
        System.out.println("Ransoms per bout: " + stat.getRansomsPerBout());
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }

    //BOUT
    public static void printBoutList(List<Bout> bouts) {
        for (Bout bout : bouts) {
            printBout(bout);
        }
    }

    public static void printBout(Bout bout) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Bout Key: " + bout.getBoutKey());
        System.out.println("Tourney: " + bout.getTourney());
        System.out.println("Attacker Points: " + bout.getAttackerPoints());
        System.out.println("Defender Points: " + bout.getDefenderPoints());

        // Print information about the attacking character
        System.out.println("Attacking Character: ");
        printCharacter(bout.getAttackingCharacter());

        // Print information about the defending character
        System.out.println("Defending Character: ");
        printCharacter(bout.getDefendingCharacter());

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    }
}

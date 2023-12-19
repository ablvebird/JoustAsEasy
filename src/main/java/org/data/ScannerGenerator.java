package org.data;

import org.crud.CharacterCRUD;
import org.crud.HouseCRUD;
import org.entities.House;
import org.entities.Character;
import org.entities.Stat;
import org.entities.Bout;

import java.util.Scanner;

public class ScannerGenerator {

    // HOUSES
    public static House createHouse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter House Key (Example: Stark --> STR):");
        String houseKey = sc.nextLine();

        System.out.println("Enter Name:");
        String name = sc.nextLine();

        System.out.println("Enter Founder:");
        String founder = sc.nextLine();

        System.out.println("Enter Region:");
        String region = sc.nextLine();

        return new House(houseKey, name, founder, region);
    }

    // CHARACTERS
    public static Character createCharacter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Character Key:");
        String characterKey = sc.nextLine();

        System.out.println("Enter Name:");
        String name = sc.nextLine();

        System.out.println("Enter Birthplace:");
        String birthplace = sc.nextLine();

        System.out.println("Enter Height:");
        double height = sc.nextDouble();
        sc.nextLine(); // consume the newline character

        System.out.println("Enter Weight:");
        double weight = sc.nextDouble();
        sc.nextLine(); // consume the newline character

        System.out.println("Enter Weapon:");
        String weapon = sc.nextLine();

        System.out.println("Enter House Key:");
        House house = HouseCRUD.getHouseByHouseKey(sc.nextLine());

        return new Character(characterKey, name, birthplace, height, weight, weapon, house);
    }

    // STATS
    public static Stat createStat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Stat Key:");
        String statKey = sc.nextLine();

        System.out.println("Enter Tourney:");
        String tourney = sc.nextLine();

        System.out.println("Enter Beheadings per Bout:");
        double beheadingsPerBout = sc.nextDouble();
        sc.nextLine(); // consume the newline character

        System.out.println("Enter Guttings per Bout:");
        double guttingsPerBout = sc.nextDouble();
        sc.nextLine(); // consume the newline character

        System.out.println("Enter Maimings per Bout:");
        double maimingsPerBout = sc.nextDouble();
        sc.nextLine(); // consume the newline character

        System.out.println("Enter Ransoms per Bout:");
        double ransomsPerBout = sc.nextDouble();
        sc.nextLine(); // consume the newline character

        System.out.println("Enter Character Key:");
        Character character = CharacterCRUD.getCharacterByCharacterKey(sc.nextLine());

        return new Stat(statKey, tourney, beheadingsPerBout, guttingsPerBout, maimingsPerBout, ransomsPerBout, character);
    }

    // BOUTS
    public static Bout createBout() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bout Key:");
        String boutKey = sc.nextLine();

        System.out.println("Enter Tourney:");
        String tourney = sc.nextLine();

        System.out.println("Enter Attacker Points:");
        int attackerPoints = sc.nextInt();
        sc.nextLine(); // consume the newline character

        System.out.println("Enter Defender Points:");
        int defenderPoints = sc.nextInt();
        sc.nextLine(); // consume the newline character

        System.out.println("Enter Character Key:");
        Character attackingCharacter = CharacterCRUD.getCharacterByCharacterKey(sc.nextLine());

        System.out.println("Enter Character Key:");
        Character defendingCharacter = CharacterCRUD.getCharacterByCharacterKey(sc.nextLine());

        return new Bout(boutKey, tourney, attackerPoints, defenderPoints, attackingCharacter, defendingCharacter);
    }
}

package org.data;

import org.crud.CharacterCRUD;
import org.crud.HouseCRUD;
import org.crud.StatCRUD;
import org.entities.Character;
import org.entities.House;
import org.entities.Stat;

public class InitialData {

    public static void createHouses(){
        HouseCRUD.insertHouse(new House(
                "STR",
                "House Stark",
                "Brandon the Builder",
                "The North"
        ));
        HouseCRUD.insertHouse(new House(
                "LNN",
                "House Lannister",
                "Lann the Clever",
                "The Westerlands"
        ));
        HouseCRUD.insertHouse(new House(
                "TRG",
                "House Targaryen",
                "Aegon the Conqueror",
                "Dragonstone"
        ));
        HouseCRUD.insertHouse(new House(
                "MRT",
                "House Martell",
                "The Yellow Toad",
                "Dorne"
        ));
    }

    public static void createStarkCharacters(){
        CharacterCRUD.insertCharacter(new Character(
                "NED",
                "Eddard Stark",
                "Winterfell",
                1.70,
                90.5,
                "Greatsword",
                HouseCRUD.getHouseByHouseKey("STR")
        ));
        CharacterCRUD.insertCharacter(new Character(
                "HOW",
                "Howland Reed",
                "Greywater Watch",
                1.68,
                75.5,
                "Bow and Arrow",
                HouseCRUD.getHouseByHouseKey("STR")
        ));
        CharacterCRUD.insertCharacter(new Character(
                "ROD",
                "Rodrik Cassel",
                "Winterfell",
                1.80,
                85.0,
                "Axe",
                HouseCRUD.getHouseByHouseKey("STR")
        ));
        CharacterCRUD.insertCharacter(new Character(
                "GRT",
                "Greatjon Umber",
                "Last Hearth",
                1.90,
                100.0,
                "Great Axe",
                HouseCRUD.getHouseByHouseKey("STR")
        ));
        CharacterCRUD.insertCharacter(new Character(
                "ETH",
                "Ethan Glover",
                "Deepwood Motte",
                1.90,
                100.0,
                "Sword",
                HouseCRUD.getHouseByHouseKey("STR")
        ));
    }

    public static void createLannisterCharacters(){
        CharacterCRUD.insertCharacter(new Character(
                "JAI",
                "Jaime Lannister",
                "Casterly Rock",
                1.85,
                85.0,
                "Valyrian Steel Sword",
                HouseCRUD.getHouseByHouseKey("LNN")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "SAN",
                "Sandor Clegane",
                "Casterly Rock",
                1.95,
                110.0,
                "Greatsword",
                HouseCRUD.getHouseByHouseKey("LNN")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "FLE",
                "Flemment Brax",
                "Casterly Rock",
                1.78,
                75.5,
                "Axe",
                HouseCRUD.getHouseByHouseKey("LNN")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "ADA",
                "Adan Marbrand",
                "Casterly Rock",
                1.80,
                82.0,
                "Sword",
                HouseCRUD.getHouseByHouseKey("LNN")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "LYL",
                "Lyle Crakehall",
                "Casterly Rock",
                1.92,
                95.0,
                "Morningstar",
                HouseCRUD.getHouseByHouseKey("LNN")
        ));
    }

    public static void createTargaryenCharacters(){
        CharacterCRUD.insertCharacter(new Character(
                "JOR",
                "Jorah Mormont",
                "Dragonstone",
                1.85,
                90.0,
                "Longsword",
                HouseCRUD.getHouseByHouseKey("TRG")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "DAA",
                "Daario Naharis",
                "Dragonstone",
                1.78,
                80.5,
                "Arakh",
                HouseCRUD.getHouseByHouseKey("TRG")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "GRW",
                "Grey Worm",
                "Dragonstone",
                1.75,
                75.0,
                "Spear",
                HouseCRUD.getHouseByHouseKey("TRG")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "ROR",
                "Rory Duckfield",
                "Dragonstone",
                1.90,
                95.0,
                "Crossbow",
                HouseCRUD.getHouseByHouseKey("TRG")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "JON",
                "Jon Connington",
                "Dragonstone",
                1.88,
                92.0,
                "Broad Sword",
                HouseCRUD.getHouseByHouseKey("TRG")
        ));
    }

    public static void createMartellCharacters(){
        CharacterCRUD.insertCharacter(new Character(
                "OBE",
                "Oberyn Martell",
                "Sunspear",
                1.82,
                78.0,
                "Spear",
                HouseCRUD.getHouseByHouseKey("MRT")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "AND",
                "Anders Yronwood",
                "Sunspear",
                1.88,
                85.5,
                "Greatsword",
                HouseCRUD.getHouseByHouseKey("MRT")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "ARE",
                "Areo Hotah",
                "Sunspear",
                1.90,
                95.0,
                "Axe",
                HouseCRUD.getHouseByHouseKey("MRT")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "NYM",
                "Nymeria Martell",
                "Sunspear",
                1.75,
                70.0,
                "Whip",
                HouseCRUD.getHouseByHouseKey("MRT")
        ));

        CharacterCRUD.insertCharacter(new Character(
                "DEZ",
                "Deziel Dalt",
                "Sunspear",
                1.78,
                80.0,
                "Dagger",
                HouseCRUD.getHouseByHouseKey("MRT")
        ));
    }

    public static void createStarkStats(){
        StatCRUD.insertStat(
                new Stat(
                        "NED01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("NED")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "HOW01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("NED")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "ROD01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("NED")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "GRT01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("NED")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "ETH01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("NED")
                )
        );
    }

    public static void createLannisterStats(){
        StatCRUD.insertStat(
                new Stat(
                        "JAI01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("LNN")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "SAN01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("LNN")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "FLE01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("LNN")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "ADA01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("LNN")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "LYL01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("LNN")
                )
        );
    }

    public static void createTargaryenStats(){
        StatCRUD.insertStat(
                new Stat(
                        "JOR01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("TRG")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "DAA01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("TRG")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "GRW01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("TRG")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "ROR01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("TRG")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "JON01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("TRG")
                )
        );
    }

    public static void createMartellStats(){
        StatCRUD.insertStat(
                new Stat(
                        "OBE01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("MRT")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "AND01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("MRT")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "ARE01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("MRT")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "NYM01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("MRT")
                )
        );
        StatCRUD.insertStat(
                new Stat(
                        "DEZ01",
                        "Tourney 01",
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateCasualtiesPerBout(),
                        DataGenerator.generateRansomsPerBout(),
                        CharacterCRUD.getCharacterByCharacterKey("MRT")
                )
        );
    }
}

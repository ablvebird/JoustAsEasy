package org.app.entities;

import jakarta.persistence.*;

/**
 * Entity representing a character in the jousting system, such as knights or nobles.
 * Each character belongs to a noble house and has attributes like combat skill and preferred weapon.
 * Uses JPA annotations for database mapping with a many-to-one relationship to House entity.
 */
@Entity
@Table
public class Character {

    @Id
    @Column
    private String characterKey;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birthplace;

    @Column(nullable = false)
    private String weapon;

    /**
     * Combat skill rating from 0 to 100. Used in bout calculations to determine success probability.
     */
    @Column(nullable = false)
    private int skillLevel;

    /**
     * The noble house this character belongs to. Required relationship.
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private House house;

    protected Character() {}

    /**
     * Creates a new character with required attributes and house affiliation.
     */
    public Character(String characterKey, String name, String birthplace, String weapon, int skillLevel, House house) {
        this.characterKey = characterKey;
        this.name = name;
        this.birthplace = birthplace;
        this.weapon = weapon;
        this.skillLevel = skillLevel;
        this.house = house;
    }

    @Override
    public String toString() {
        return String.format("Character[Key=%s, Name=%s, Birthplace=%s, Weapon=%s, Skill Level=%d, House=%s]",
                this.characterKey,
                this.name,
                this.birthplace,
                this.weapon,
                this.skillLevel,
                this.house != null ? this.house.getName() : "No House");
    }

    // Standard getters and setters

    public String getCharacterKey() { return characterKey; }
    public void setCharacterKey(String characterKey) { this.characterKey = characterKey; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBirthplace() { return birthplace; }
    public void setBirthplace(String birthplace) { this.birthplace = birthplace; }

    public String getWeapon() { return weapon; }
    public void setWeapon(String weapon) { this.weapon = weapon; }

    public int getSkillLevel() { return skillLevel; }
    public void setSkillLevel(int skillLevel) { this.skillLevel = skillLevel; }

    public House getHouse() { return house; }
    public void setHouse(House house) { this.house = house; }
}
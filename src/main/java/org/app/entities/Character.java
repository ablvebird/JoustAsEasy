package org.app.entities;

import jakarta.persistence.*;

/**
 * The {@code Character} class represents a character entity in the jousting system.
 *
 * <p>This entity is mapped to the "characters" table in the database using JPA annotations.
 * Each character is associated with a {@link House} and represents a member of that noble house.</p>
 *
 * <h2>JPA Annotations</h2>
 * <ul>
 *   <li>{@link Entity}: Marks this class as a JPA entity mapped to a database table.</li>
 *   <li>{@link Table}: Defines the database table to which this entity is mapped ("characters").</li>
 *   <li>{@link Id}: Specifies the primary key of the entity.</li>
 *   <li>{@link Column}: Customizes the columns of the entity with constraints (e.g., {@code nullable = false}).</li>
 *   <li>{@link ManyToOne}: Defines the many-to-one relationship between {@code Character} and {@link House}.</li>
 *   <li>{@link JoinColumn}: Specifies the foreign key constraint linking a character to its house.</li>
 * </ul>
 *
 * <h2>Relationships</h2>
 * <p>Each character belongs to exactly one house, represented by a {@link House} entity. This is a
 * many-to-one relationship where multiple characters can belong to a single house, but each character
 * is associated with only one house.</p>
 *
 * <h3>Key Fields:</h3>
 * <ul>
 *   <li><strong>characterKey:</strong> The unique identifier for the character entity.</li>
 *   <li><strong>name:</strong> The character's name.</li>
 *   <li><strong>birthplace:</strong> The birthplace of the character (e.g., "Winterfell").</li>
 *   <li><strong>weapon:</strong> The primary weapon used by the character (e.g., "Sword").</li>
 *   <li><strong>skillLevel:</strong> The character's combat skill level, represented as an integer between 0-100.</li>
 *   <li><strong>house:</strong> A reference to the {@link House} to which the character belongs.</li>
 * </ul>
 *
 * @see org.app.entities.House
 */
@Entity
@Table
public class Character {

    /** The primary key that uniquely identifies the character in the database. */
    @Id
    @Column
    private String characterKey;

    /** The name of the character (e.g., "Eddard Stark"). This field is mandatory. */
    @Column(nullable = false)
    private String name;

    /** The birthplace of the character (e.g., "Winterfell"). This field is mandatory. */
    @Column(nullable = false)
    private String birthplace;

    /** The primary weapon used by the character in combat (e.g., "Greatsword"). This field is mandatory. */
    @Column(nullable = false)
    private String weapon;

    /** The skill level of the character, measured on a scale of 0-100. This field is mandatory. */
    @Column(nullable = false)
    private int skillLevel;

    /**
     * Many-to-one relationship with the {@link House} entity.
     * Each character belongs to exactly one house.
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private House house;

    /**
     * Default no-argument constructor.
     * Required by JPA for entity initialization.
     */
    public Character() {}

    /**
     * Constructor for creating a new {@code Character} with all attributes.
     *
     * @param characterKey The unique key identifying the character.
     * @param name The name of the character.
     * @param birthplace The birthplace of the character.
     * @param weapon The weapon used by the character.
     * @param skillLevel The character's skill level (0-100).
     * @param house The {@link House} to which the character belongs.
     */
    public Character(String characterKey, String name, String birthplace, String weapon, int skillLevel, House house) {
        this.characterKey = characterKey;
        this.name = name;
        this.birthplace = birthplace;
        this.weapon = weapon;
        this.skillLevel = skillLevel;
        this.house = house;
    }

    /**
     * Returns a string representation of the character, including key attributes like name, birthplace, weapon, and house.
     *
     * @return A formatted string representing the character.
     */
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

    // GETTERS & SETTERS

    /**
     * Returns the unique key of the character.
     *
     * @return The character's unique key.
     */
    public String getCharacterKey() {
        return characterKey;
    }
    /**
     * Sets the unique key of the character.
     *
     * @param characterKey The character's unique key.
     */
    public void setCharacterKey(String characterKey) {
        this.characterKey = characterKey;
    }

    /**
     * Returns the name of the character.
     *
     * @return The character's name.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the character.
     *
     * @param name The character's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the birthplace of the character.
     *
     * @return The character's birthplace.
     */
    public String getBirthplace() {
        return birthplace;
    }
    /**
     * Sets the birthplace of the character.
     *
     * @param birthplace The character's birthplace.
     */
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    /**
     * Returns the weapon used by the character.
     *
     * @return The character's weapon.
     */
    public String getWeapon() {
        return weapon;
    }
    /**
     * Sets the weapon used by the character.
     *
     * @param weapon The character's weapon.
     */
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    /**
     * Returns the skill level of the character.
     *
     * @return The character's skill level.
     */
    public int getSkillLevel() {
        return skillLevel;
    }
    /**
     * Sets the skill level of the character.
     *
     * @param skillLevel The character's skill level.
     */
    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    /**
     * Returns the {@link House} to which the character belongs.
     *
     * @return The house associated with this character.
     */
    public House getHouse() {
        return house;
    }
    /**
     * Sets the {@link House} to which the character belongs.
     *
     * @param house The house to associate with this character.
     */
    public void setHouse(House house) {
        this.house = house;
    }
}

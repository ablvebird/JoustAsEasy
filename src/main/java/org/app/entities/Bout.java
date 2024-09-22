package org.app.entities;

import jakarta.persistence.*;

/**
 * The {@code Bout} class represents a jousting match between two characters in the system.
 *
 * <p>This entity is mapped to the "bouts" table in the database using JPA annotations.
 * Each bout represents a competition between two characters: an attacker and a defender.</p>
 *
 * <h2>JPA Annotations</h2>
 * <ul>
 *   <li>{@link Entity}: Marks this class as a JPA entity mapped to a database table.</li>
 *   <li>{@link Table}: Specifies the database table ("bouts") to which this entity is mapped.</li>
 *   <li>{@link Id}: Defines the primary key of the entity.</li>
 *   <li>{@link Column}: Customizes the columns of the entity with constraints (e.g., {@code nullable = false}).</li>
 *   <li>{@link ManyToOne}: Defines many-to-one relationships with {@link Character} for both the attacker and defender.</li>
 *   <li>{@link JoinColumn}: Specifies the foreign key relationships to associate the bout with attacking and defending characters.</li>
 * </ul>
 *
 * <h2>Relationships</h2>
 * <p>Each bout involves two characters: one attacker and one defender, both of which are represented by {@link Character} entities.
 * This creates two many-to-one relationships where a bout has a reference to two distinct characters.</p>
 *
 * <h3>Key Fields:</h3>
 * <ul>
 *   <li><strong>boutKey:</strong> The unique identifier for the bout entity.</li>
 *   <li><strong>tourney:</strong> The name of the tourney in which the bout takes place.</li>
 *   <li><strong>attackerPoints:</strong> The points scored by the attacking character in the bout.</li>
 *   <li><strong>defenderPoints:</strong> The points scored by the defending character in the bout.</li>
 *   <li><strong>attacker:</strong> A reference to the {@link Character} who is the attacker in the bout.</li>
 *   <li><strong>defender:</strong> A reference to the {@link Character} who is the defender in the bout.</li>
 * </ul>
 *
 * @see org.app.entities.Character
 */
@Entity
@Table
public class Bout {

    /** The primary key that uniquely identifies the bout in the database. */
    @Id
    @Column(unique = true)
    private String boutKey;

    /** The name of the tourney where this bout takes place. This field is mandatory. */
    @Column(nullable = false)
    private String tourney;

    /**
     * Many-to-one relationship with the {@link Character} entity representing the attacker.
     * A bout has exactly one attacking character.
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private Character attacker;

    /**
     * Many-to-one relationship with the {@link Character} entity representing the defender.
     * A bout has exactly one defending character.
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private Character defender;

    /** The points scored by the attacking character during the bout. This field is mandatory. */
    @Column(nullable = false)
    private int attackerPoints;

    /** The points scored by the defending character during the bout. This field is mandatory. */
    @Column(nullable = false)
    private int defenderPoints;

    /**
     * Default no-argument constructor required by JPA for entity initialization.
     */
    public Bout() {}

    /**
     * Constructor for creating a {@code Bout} with all relevant attributes.
     *
     * @param boutKey The unique key identifying the bout.
     * @param tourney The name of the tourney.
     * @param attackerPoints The points scored by the attacker.
     * @param defenderPoints The points scored by the defender.
     * @param attacker The {@link Character} who is attacking in the bout.
     * @param defender The {@link Character} who is defending in the bout.
     */
    public Bout(String boutKey, String tourney, int attackerPoints, int defenderPoints, Character attacker, Character defender) {
        this.boutKey = boutKey;
        this.tourney = tourney;
        this.attackerPoints = attackerPoints;
        this.defenderPoints = defenderPoints;
        this.attacker = attacker;
        this.defender = defender;
    }

    /**
     * Provides a string representation of the bout, including key information such as the bout key, tourney, and both characters.
     *
     * @return A formatted string representing the bout.
     */
    @Override
    public String toString() {
        return String.format("Bout[Key=%s, Tourney=%s, Attacker Points=%d, Defender Points=%d, Attacker=%s, Defender=%s]",
                this.boutKey,
                this.tourney,
                this.attackerPoints,
                this.defenderPoints,
                this.attacker != null ? this.attacker.getName() : "Unknown",
                this.defender != null ? this.defender.getName() : "Unknown");
    }

    // GETTERS & SETTERS

    /**
     * Returns the unique key of the bout.
     *
     * @return The bout's unique key.
     */
    public String getBoutKey() {
        return boutKey;
    }

    /**
     * Sets the unique key of the bout.
     *
     * @param boutKey The bout's unique key.
     */
    public void setBoutKey(String boutKey) {
        this.boutKey = boutKey;
    }

    /**
     * Returns the name of the tourney where the bout takes place.
     *
     * @return The tourney name.
     */
    public String getTourney() {
        return tourney;
    }

    /**
     * Sets the name of the tourney where the bout takes place.
     *
     * @param tourney The tourney name.
     */
    public void setTourney(String tourney) {
        this.tourney = tourney;
    }

    /**
     * Returns the points scored by the attacking character.
     *
     * @return The attacker points.
     */
    public int getAttackerPoints() {
        return attackerPoints;
    }

    /**
     * Sets the points scored by the attacking character.
     *
     * @param attackerPoints The attacker points.
     */
    public void setAttackerPoints(int attackerPoints) {
        this.attackerPoints = attackerPoints;
    }

    /**
     * Returns the points scored by the defending character.
     *
     * @return The defender points.
     */
    public int getDefenderPoints() {
        return defenderPoints;
    }

    /**
     * Sets the points scored by the defending character.
     *
     * @param defenderPoints The defender points.
     */
    public void setDefenderPoints(int defenderPoints) {
        this.defenderPoints = defenderPoints;
    }

    /**
     * Returns the {@link Character} who is attacking in the bout.
     *
     * @return The attacking character.
     */
    public Character getAttacker() {
        return attacker;
    }

    /**
     * Sets the {@link Character} who is attacking in the bout.
     *
     * @param attacker The attacking character.
     */
    public void setAttacker(Character attacker) {
        this.attacker = attacker;
    }

    /**
     * Returns the {@link Character} who is defending in the bout.
     *
     * @return The defending character.
     */
    public Character getDefender() {
        return defender;
    }

    /**
     * Sets the {@link Character} who is defending in the bout.
     *
     * @param defender The defending character.
     */
    public void setDefender(Character defender) {
        this.defender = defender;
    }
}

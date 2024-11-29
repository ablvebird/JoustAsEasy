package org.app.entities;

import jakarta.persistence.*;

/**
 * Entity representing a jousting match (bout) between two characters.
 * Each bout is part of a tournament and tracks the performance points of both participants.
 * Uses JPA annotations for database mapping with two many-to-one relationships to Character entities,
 * one for the attacker and another for the defender.
 */
@Entity
@Table
public class Bout {

    @Id
    @Column(unique = true)
    private String boutKey;

    @Column(nullable = false)
    private String tourney;

    /**
     * Character initiating the joust. Required relationship.
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private Character attacker;

    /**
     * Character receiving the attack. Required relationship.
     */
    @ManyToOne
    @JoinColumn(nullable = false)
    private Character defender;

    /**
     * Points calculated based on attacker's performance.
     */
    @Column(nullable = false)
    private int attackerPoints;

    /**
     * Points calculated based on defender's performance.
     */
    @Column(nullable = false)
    private int defenderPoints;

    protected Bout() {}

    /**
     * Creates a new bout with all required match information.
     */
    public Bout(String boutKey, String tourney, int attackerPoints, int defenderPoints,
                Character attacker, Character defender) {
        this.boutKey = boutKey;
        this.tourney = tourney;
        this.attackerPoints = attackerPoints;
        this.defenderPoints = defenderPoints;
        this.attacker = attacker;
        this.defender = defender;
    }

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

    // Standard getters and setters

    public String getBoutKey() { return boutKey; }
    public void setBoutKey(String boutKey) { this.boutKey = boutKey; }

    public String getTourney() { return tourney; }
    public void setTourney(String tourney) { this.tourney = tourney; }

    public int getAttackerPoints() { return attackerPoints; }
    public void setAttackerPoints(int attackerPoints) { this.attackerPoints = attackerPoints; }

    public int getDefenderPoints() { return defenderPoints; }
    public void setDefenderPoints(int defenderPoints) { this.defenderPoints = defenderPoints; }

    public Character getAttacker() { return attacker; }
    public void setAttacker(Character attacker) { this.attacker = attacker; }

    public Character getDefender() { return defender; }
    public void setDefender(Character defender) { this.defender = defender; }
}
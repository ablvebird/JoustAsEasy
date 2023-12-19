package org.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bouts")
public class Bout {

    //PK
    @Id
    @Column(name = "bout_key", unique = true)
    private String boutKey;

    //ATTRIBUTES
    @Column(name = "tourney", nullable = false)
    private String tourney;

    @Column(name="attacker_points")
    private int attackerPoints;

    @Column(name="defender_points")
    private int defenderPoints;

    //FK
    @ManyToOne
    @JoinColumn(name = "attacking_character")
    private Character attackingCharacter;

    @ManyToOne
    @JoinColumn(name = "defending_character")
    private Character defendingCharacter;

    //CONSTRUCTORS
    public Bout() {}
    public Bout(String boutKey, String tourney, int attackerPoints, int defenderPoints,
                Character attackingCharacter, Character defendingCharacter) {
        this.boutKey = boutKey;
        this.tourney = tourney;
        this.attackerPoints = attackerPoints;
        this.defenderPoints = defenderPoints;
        this.attackingCharacter = attackingCharacter;
        this.defendingCharacter = defendingCharacter;
    }

    //GETTERS & SETTERS
    public String getBoutKey() {
        return boutKey;
    }
    public void setBoutKey(String boutKey) {
        this.boutKey = boutKey;
    }
    public String getTourney() {
        return tourney;
    }
    public void setTourney(String tourney) {
        this.tourney = tourney;
    }
    public int getAttackerPoints() {
        return attackerPoints;
    }
    public void setAttackerPoints(int attackerPoints) {
        this.attackerPoints = attackerPoints;
    }
    public int getDefenderPoints() {
        return defenderPoints;
    }
    public void setDefenderPoints(int defenderPoints) {
        this.defenderPoints = defenderPoints;
    }
    public Character getAttackingCharacter() {
        return attackingCharacter;
    }
    public void setAttackingCharacter(Character attackingCharacter) {
        this.attackingCharacter = attackingCharacter;
    }
    public Character getDefendingCharacter() {
        return defendingCharacter;
    }
    public void setDefendingCharacter(Character defendingCharacter) {
        this.defendingCharacter = defendingCharacter;
    }
}

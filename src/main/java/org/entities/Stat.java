package org.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "stats")
public class Stat {

    //PK
    @Id
    @Column(name = "stat_key")
    private String statKey;

    //ATTRIBUTES
    @Column(nullable = false)
    private String tourney;

    @Column(nullable = false, name="beheadings_per_bout")
    private double beheadingsPerBout;

    @Column(nullable = false, name="guttings_per_bout")
    private double guttingsPerBout;

    @Column(nullable = false, name="maimings_per_bout")
    private double maimingsPerBout;

    @Column(nullable = false, name="ransom_per_bout")
    private double ransomsPerBout;

    //FK
    @ManyToOne
    @JoinColumn(name="character_key", nullable=true)
    private Character character;

    //CONSTRUCTORS
    public Stat(){}

    public Stat(String statKey, String tourney, double beheadingsPerBout, double guttingsPerBout, double maimingsPerBout, double ransomsPerBout, Character character) {
        this.statKey = statKey;
        this.tourney = tourney;
        this.beheadingsPerBout = beheadingsPerBout;
        this.guttingsPerBout = guttingsPerBout;
        this.maimingsPerBout = maimingsPerBout;
        this.ransomsPerBout = ransomsPerBout;
        this.character = character;
    }

    //GETTERS & SETTERS
    public String getStatKey() {
        return statKey;
    }

    public void setStatKey(String statKey) {
        this.statKey = statKey;
    }

    public String getTourney() {
        return tourney;
    }

    public void setTourney(String tourney) {
        this.tourney = tourney;
    }

    public double getBeheadingsPerBout() {
        return beheadingsPerBout;
    }

    public void setBeheadingsPerBout(double beheadingsPerBout) {
        this.beheadingsPerBout = beheadingsPerBout;
    }

    public double getGuttingsPerBout() {
        return guttingsPerBout;
    }

    public void setGuttingsPerBout(double guttingsPerBout) {
        this.guttingsPerBout = guttingsPerBout;
    }

    public double getMaimingsPerBout() {
        return maimingsPerBout;
    }

    public void setMaimingsPerBout(double maimingsPerBout) {
        this.maimingsPerBout = maimingsPerBout;
    }

    public double getRansomsPerBout() {
        return ransomsPerBout;
    }

    public void setRansomsPerBout(double ransomsPerBout) {
        this.ransomsPerBout = ransomsPerBout;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}

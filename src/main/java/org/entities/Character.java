package org.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "characters")
public class Character {

    //PK
    @Id
    @Column(name = "character_key")
    private String characterKey;

    //ATTRIBUTES
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthplace", nullable = false)
    private String birthplace;

    @Column(name = "height", nullable = false)
    private double height;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "weapon", nullable = false)
    private String weapon;

    //FK
    @ManyToOne
    @JoinColumn(name="house_key", nullable=false)
    private House house;

    @OneToMany(mappedBy="character")
    private Set<Stat> stats;

    //CONSTRUCTORS
    public Character(){}

    public Character(String characterKey, String name, String birthplace, double height, double weight, String weapon, House house) {
        this.characterKey = characterKey;
        this.name = name;
        this.birthplace = birthplace;
        this.height = height;
        this.weight = weight;
        this.weapon = weapon;
        this.house = house;
    }

    //GETTERS & SETTERS
    public String getCharacterKey() {
        return characterKey;
    }

    public void setCharacterKey(String characterKey) {
        this.characterKey = characterKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Set<Stat> getStats() {
        return stats;
    }

    public void setStats(Set<Stat> stats) {
        this.stats = stats;
    }
}

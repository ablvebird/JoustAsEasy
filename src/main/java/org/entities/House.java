package org.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "houses")
public class House {

    //PK
    @Id
    @Column(name = "house_key")
    private String houseKey;

    //ATTRIBUTES
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "founder", nullable = false)
    private String founder;

    @Column(name = "region", nullable = false)
    private String region;

    //FK
    @OneToMany(mappedBy = "house")
    private Set<Character> characters;


    //CONSTRUCTORS
    public House(){}

    public House(String houseKey, String name, String founder, String region) {
        this.houseKey = houseKey;
        this.name = name;
        this.founder = founder;
        this.region = region;
    }

    //GETTERS & SETTERS

    public String getHouseKey() {
        return houseKey;
    }

    public void setHouseKey(String houseKey) {
        this.houseKey = houseKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }
}

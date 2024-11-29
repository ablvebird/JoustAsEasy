package org.app.entities;

import jakarta.persistence.*;
import java.util.Set;

/**
 * Entity representing a noble house in the game world, such as House Stark or Lannister.
 * Contains basic house information and maintains a relationship with its associated characters.
 * Uses JPA annotations for database mapping with a one-to-many relationship to Character entities.
 */
@Entity
@Table
public class House {

    @Id
    @Column
    private String houseKey;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String founder;

    @Column(nullable = false)
    private String region;

    /**
     * Characters belonging to this house. Mapped by the house field in Character entity.
     */
    @OneToMany(mappedBy = "house")
    private Set<Character> characters;

    protected House() {}

    /**
     * Creates a new house with required fields.
     */
    public House(String founder, String name, String region, String houseKey) {
        this.houseKey = houseKey;
        this.name = name;
        this.founder = founder;
        this.region = region;
    }

    @Override
    public String toString() {
        return String.format("House[Key=%s, Name=%s, Founder=%s, Region=%s, Characters=%d]",
                this.houseKey,
                this.name,
                this.founder,
                this.region,
                this.characters != null ? this.characters.size() : 0);
    }

    // Standard getters and setters

    public String getHouseKey() { return houseKey; }
    public void setHouseKey(String houseKey) { this.houseKey = houseKey; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFounder() { return founder; }
    public void setFounder(String founder) { this.founder = founder; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public Set<Character> getCharacters() { return characters; }
    public void setCharacters(Set<Character> characters) { this.characters = characters; }
}
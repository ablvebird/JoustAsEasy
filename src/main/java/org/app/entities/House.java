package org.app.entities;

import jakarta.persistence.*;
import java.util.Set;

/**
 * The {@code House} class represents a noble house entity in the system.
 *
 * <p>This entity is mapped to the "houses" table in the database using JPA annotations.
 * Each house can have multiple characters associated with it through a one-to-many relationship.</p>
 *
 * <h2>JPA Annotations</h2>
 * <ul>
 *   <li>{@link Entity}: Marks this class as a JPA entity mapped to a database table.</li>
 *   <li>{@link Table}: Defines the database table to which this entity is mapped.</li>
 *   <li>{@link Id}: Specifies the primary key of the entity.</li>
 *   <li>{@link Column}: Customizes individual columns of the entity.</li>
 *   <li>{@link OneToMany}: Defines a one-to-many relationship with the {@link Character} entity.</li>
 *   <li>{@link JoinColumn}: Links the foreign key between the two entities.</li>
 * </ul>
 *
 * <h2>Relationships</h2>
 * <p>This class has a bi-directional one-to-many relationship with the {@code Character} class.
 * A house can be associated with many characters, but each character belongs to only one house.</p>
 *
 * <h3>Key Fields:</h3>
 * <ul>
 *   <li><strong>houseKey:</strong> The unique identifier for the house entity.</li>
 *   <li><strong>name:</strong> The name of the house (e.g., "House Stark").</li>
 *   <li><strong>founder:</strong> The founder of the house.</li>
 *   <li><strong>region:</strong> The region where the house is located.</li>
 *   <li><strong>characters:</strong> A set of {@link Character} objects representing characters in the house.</li>
 * </ul>
 *
 * @see org.app.entities.Character
 */
@Entity
@Table
public class House {

    /** The unique key representing the house. This is the primary key in the database. */
    @Id
    @Column
    private String houseKey;

    /** The name of the house (e.g., "House Stark"). This field is mandatory. */
    @Column(nullable = false)
    private String name;

    /** The founder of the house (e.g., "Brandon the Builder"). This field is mandatory. */
    @Column(nullable = false)
    private String founder;

    /** The region where the house is located (e.g., "The North"). This field is mandatory. */
    @Column(nullable = false)
    private String region;

    /**
     * A set of characters belonging to this house.
     *
     * <p>This is a one-to-many relationship, with the {@code House} being the "one" side and the
     * {@code Character} being the "many" side. The {@code mappedBy} attribute indicates that
     * the {@code house} field in the {@link Character} class owns the relationship.</p>
     */
    @OneToMany(mappedBy = "house")
    private Set<Character> characters;

    // CONSTRUCTORS

    /**
     * Default no-argument constructor.
     * Required by JPA for entity initialization.
     */
    public House() {}

    /**
     * Constructor for creating a new {@code House} with all required fields.
     *
     * @param founder The name of the founder of the house.
     * @param name The name of the house.
     * @param region The region where the house is located.
     * @param houseKey The unique key identifying the house.
     */
    public House(String founder, String name, String region, String houseKey) {
        this.houseKey = houseKey;
        this.name = name;
        this.founder = founder;
        this.region = region;
    }

    /**
     * Returns a string representation of the house, including its key, name, founder, region, and the number of characters.
     *
     * @return A formatted string representing the house.
     */
    @Override
    public String toString() {
        return String.format("House[Key=%s, Name=%s, Founder=%s, Region=%s, Characters=%d]",
                this.houseKey,
                this.name,
                this.founder,
                this.region,
                this.characters != null ? this.characters.size() : 0);
    }

    // GETTERS & SETTERS

    /**
     * Returns the unique key of the house.
     *
     * @return The house's unique key.
     */
    public String getHouseKey() {
        return houseKey;
    }
    /**
     * Sets the unique key of the house.
     *
     * @param houseKey The house's unique key.
     */
    public void setHouseKey(String houseKey) {
        this.houseKey = houseKey;
    }

    /**
     * Returns the name of the house.
     *
     * @return The house's name.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the house.
     *
     * @param name The house's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the house's founder.
     *
     * @return The founder's name.
     */
    public String getFounder() {
        return founder;
    }
    /**
     * Sets the name of the house's founder.
     *
     * @param founder The founder's name.
     */
    public void setFounder(String founder) {
        this.founder = founder;
    }

    /**
     * Returns the region where the house is located.
     *
     * @return The house's region.
     */
    public String getRegion() {
        return region;
    }
    /**
     * Sets the region where the house is located.
     *
     * @param region The house's region.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Returns the set of characters belonging to the house.
     *
     * @return A set of {@link Character} objects.
     */
    public Set<Character> getCharacters() {
        return characters;
    }
    /**
     * Sets the characters belonging to the house.
     *
     * @param characters A set of {@link Character} objects.
     */
    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }
}

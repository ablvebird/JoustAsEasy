package org.crud;

import org.entities.Character;
import org.entities.House;
import org.hibernate.HibernateSettings;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CharacterCRUD {

    //SELECT
    public static List<Character> getAllCharacters() {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select all characters
            String hql = "from Character ";
            Query<Character> query = session.createQuery(hql, Character.class);

            // Execute the query and return the list of characters
            return query.getResultList();
        }
    }

    public static List<Character> getCharactersByHouseKey(String houseKey) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select a house by its houseKey
            String hql = "from Character where house.houseKey = :house_key";
            Query<Character> query = session.createQuery(hql, Character.class);
            query.setParameter("house_key", houseKey);

            // Execute the query and return the characters from the house
            return query.getResultList();
        }
    }

    public static Character getCharacterByCharacterKey(String characterKey) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select a house by its houseKey
            String hql = "from Character where characterKey = :character_key";
            Query<Character> query = session.createQuery(hql, Character.class);
            query.setParameter("character_key", characterKey);

            // Execute the query and return the single house or null if not found
            List<Character> resultList = query.getResultList();
            return resultList.isEmpty() ? null : resultList.get(0);
        }
    }



    //INSERT
    public static void insertCharacter(Character newCharacter) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // If no existing house with the same code, proceed with the insertion
            session.beginTransaction();
            session.persist(newCharacter);
            session.getTransaction().commit();
        }
    }

}

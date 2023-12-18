package org.crud;

import org.entities.Character;
import org.entities.Stat;
import org.hibernate.HibernateSettings;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StatCRUD {

    //SELECT
    public static List<Stat> getAllStats() {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select all stats
            String hql = "from Stat ";
            Query<Stat> query = session.createQuery(hql, Stat.class);

            // Execute the query and return the list of stats
            return query.getResultList();
        }
    }
    public static List<Stat> getStatsByCharacterKey(String characterKey) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select stats by characterKey
            String hql = "from Stat where character.characterKey = :character_key";
            Query<Stat> query = session.createQuery(hql, Stat.class);
            query.setParameter("character_key", characterKey);

            // Execute the query and return the stats for the character
            return query.getResultList();
        }
    }



    //INSERT
    public static void insertStat(Stat newStat) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // If no existing stat with the same code, proceed with the insertion
            session.beginTransaction();
            session.persist(newStat);
            session.getTransaction().commit();
        }
    }
}

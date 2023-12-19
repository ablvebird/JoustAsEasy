package org.crud;

import org.entities.Bout;
import org.entities.Character;
import org.entities.House;
import org.hibernate.HibernateSettings;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BoutCRUD {

    //SELECT
    public static List<Bout> getAllBouts() {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select all bouts
            String hql = "from Bout";
            Query<Bout> query = session.createQuery(hql, Bout.class);

            // Execute the query and return the list of bout
            return query.getResultList();
        }
    }
    public static List<Bout> getBoutByTourney(String tourney) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select a bout by its tourney
            String hql = "from Bout where tourney = :tourney";
            Query<Bout> query = session.createQuery(hql, Bout.class);
            query.setParameter("tourney", tourney);

            return query.getResultList();
        }
    }
    public static List<Bout> getBoutByTourneyAndAttacker(String tourney, String attackingCharacterKey) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select a bout by its tourney and attacker's key
            String hql = "from Bout where tourney = :tourney and attackingCharacter.characterKey = :attackingCharacter";
            Query<Bout> query = session.createQuery(hql, Bout.class);
            query.setParameter("tourney", tourney);
            query.setParameter("attackingCharacter", attackingCharacterKey);

            return query.getResultList();
        }
    }

    public static Bout getBoutByBoutPreciseKey(String boutKey) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select a bout by its boutKey
            String hql = "from Bout where boutKey = :bout_key";
            Query<Bout> query = session.createQuery(hql, Bout.class);
            query.setParameter("bout_key", boutKey);

            // Execute the query and return the single bout or null if not found
            List<Bout> resultList = query.getResultList();
            return resultList.isEmpty() ? null : resultList.get(0);
        }
    }
    public static List<Bout> getBoutsByBoutPartialKey(String boutKey) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select bouts by partial boutKey
            String hql = "from Bout where boutKey = :bout_key";
            Query<Bout> query = session.createQuery(hql, Bout.class);
            query.setParameter("bout_key", boutKey);

            // Execute the query and return the single bout or null if not found
            return query.getResultList();
        }
    }

    //INSERT
    public static void insertBout(Bout newBout) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // If no existing house with the same code, proceed with the insertion
            session.beginTransaction();
            session.persist(newBout);
            session.getTransaction().commit();
        }
    }



}

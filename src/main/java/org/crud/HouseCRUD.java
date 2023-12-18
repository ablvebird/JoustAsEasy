package org.crud;

import org.entities.House;
import org.hibernate.HibernateSettings;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class HouseCRUD {

    //SELECT
    public static List<House> getAllHouses() {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select all houses
            String hql = "from House";
            Query<House> query = session.createQuery(hql, House.class);

            // Execute the query and return the list of houses
            return query.getResultList();
        }
    }

    public static House getHouseByHouseKey(String houseKey) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // HQL query to select a house by its houseKey
            String hql = "from House where houseKey = :house_key";
            Query<House> query = session.createQuery(hql, House.class);
            query.setParameter("house_key", houseKey);

            // Execute the query and return the single house or null if not found
            List<House> resultList = query.getResultList();
            return resultList.isEmpty() ? null : resultList.get(0);
        }
    }



    //INSERT
    public static void insertHouse(House newHouse) {
        try (Session session = HibernateSettings.getSessionFactory().openSession()) {
            // If no existing house with the same code, proceed with the insertion
            session.beginTransaction();
            session.save(newHouse);
            session.getTransaction().commit();
        }
    }


}

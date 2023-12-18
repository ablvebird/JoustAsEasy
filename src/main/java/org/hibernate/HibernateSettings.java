package org.hibernate;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSettings {

    // The single instance of the Hibernate SessionFactory
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Build the Hibernate SessionFactory by configuring it based on hibernate.cfg.xml.
     *
     * @return The configured Hibernate SessionFactory.
     * @throws RuntimeException if initialization fails.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            System.out.println("Initializing Hibernate SessionFactory...");

            // Create the Hibernate StandardServiceRegistry using hibernate.cfg.xml
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

            // Build the Metadata object from the StandardServiceRegistry
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

            // Build and return the SessionFactory from the Metadata
            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

            System.out.println("Hibernate SessionFactory initialized successfully.");

            return sessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Hibernate SessionFactory");
        }
    }

    /**
     * Get the configured Hibernate SessionFactory.
     *
     * @return The Hibernate SessionFactory.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Shutdown the Hibernate SessionFactory.
     * Call this method when the application is shutting down.
     */
    public static void shutdown() {
        System.out.println("Shutting down Hibernate SessionFactory...");
        getSessionFactory().close();
        System.out.println("Hibernate SessionFactory closed.");
    }

}

package com.inventory.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HibernateUtil class
 * This class is responsible for creating and managing the Hibernate SessionFactory.
 * SessionFactory is a thread-safe object that is used to create Session instances.
 */
public class HibernateUtil {
    
    private static SessionFactory factory;
    
    // Static block to initialize SessionFactory once when class is loaded
    static {
        try {
            // Load hibernate.cfg.xml configuration
            factory = new Configuration().configure().buildSessionFactory();
            System.out.println("SessionFactory created successfully!");
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /**
     * Returns the SessionFactory instance
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return factory;
    }
    
    /**
     * Shuts down the SessionFactory
     */
    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}


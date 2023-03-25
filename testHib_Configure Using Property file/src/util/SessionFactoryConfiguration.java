package util;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * Singleton design pattern used
 */
public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration sessionFactoryConfiguration;
    private final Session session;

    private SessionFactoryConfiguration() {
        Configuration configuration = new Configuration();
        // configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);

        /** Configuration using property file */
        Properties property = new Properties();
        try {
            property.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            System.out.println("Property file not found!");
        }
        configuration.mergeProperties(property).buildSessionFactory();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static SessionFactoryConfiguration getInstance() {
        return (sessionFactoryConfiguration == null) ?
                sessionFactoryConfiguration = new SessionFactoryConfiguration() :
                sessionFactoryConfiguration;
    }

    public Session getSession() {
        return session;
    }
}


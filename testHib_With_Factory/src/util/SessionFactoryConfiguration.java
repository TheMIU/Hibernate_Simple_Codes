package util;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Singleton design pattern used
 */
public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration sessionFactoryConfiguration;
    private final Session session;

    private SessionFactoryConfiguration() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);

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


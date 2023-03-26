import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        /*
        Customer c1 = new Customer();
        c1.setCusID("C001");
        c1.setName("John");
        c1.setAddress("New York");

        session.save(c1);
        */

        /** First Level Caching */
        // Session 01
        Session session1 = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction1 = session1.beginTransaction();

        Customer customer = session1.get(Customer.class, "C001"); // execute query
        System.out.println(customer);

        Customer customerTest = session1.get(Customer.class, "C001");  // fetch data using cache
        System.out.println(customerTest);

        transaction1.commit();
        session1.close();

        // Session 02
        Session session2 = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction2 = session2.beginTransaction();

        Customer customerNextSession = session2.get(Customer.class, "C001"); // execute query
        System.out.println(customerNextSession);

        transaction2.commit();
        session2.close();
    }
}

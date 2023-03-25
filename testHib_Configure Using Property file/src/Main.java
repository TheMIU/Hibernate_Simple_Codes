import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        /** Configuration demo using property file */

        Customer c1 = new Customer();
        c1.setCusID("C001");
        c1.setName("John");
        c1.setAddress("New York");

        // Persist to DB
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(c1);

        transaction.commit();
        session.close();
    }
}

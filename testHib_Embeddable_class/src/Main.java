import embeddable.CustomerName;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer c1 = new Customer();
        c1.setId(1);
        /** adding Sub-properties using embeddable class */
        c1.setName(new CustomerName("John","Wick"));

        session.save(c1);

        transaction.commit();
        session.close();
    }
}

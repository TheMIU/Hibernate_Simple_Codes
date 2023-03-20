import entity.Customer;
import entity.CustomerDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /** One To One */

        Customer c1 = new Customer();
        c1.setCusId("C001");
        c1.setName("John");
        c1.setAddress("New York");

        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setBookID("B001");
        customerDetail.setAge(25);
        customerDetail.setPhoneNum("0123456789");

        customerDetail.setCustomer(c1);

        session.save(c1);
        session.save(customerDetail);

        transaction.commit();
        session.close();
    }
}

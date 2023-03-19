import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class Main {
    public static void main(String[] args) {

        /** Basic CRUD Operations with Hibernate
         * C - CREATE   --> save()    <-- Persist data from DB
         * R - READ     --> get()     <-- Fetch data from DB
         * U - UPDATE   --> update()
         * D - DELETE   --> delete()
         * */

        /////////////////////////////
        /**  save();  */
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer c1 = new Customer();
        c1.setId(1);
        c1.setName("John");

        // or, using constructor
        Customer c2 = new Customer(2, "Porter");

        session.save(c1);
        session.save(c2);

        transaction.commit();
        session.close();

        /////////////////////////////
        /**  get();  */
        /*
        Session session = SessionFactoryConfiguration.getInstance().getSession();

        Customer customer = session.get(Customer.class, 1);
        System.out.println(customer.getName());
        System.out.println(customer);

        session.close();
        */

        /////////////////////////////
        /**  update();  */
        /*
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 1);
        customer.setName("John Wick");

        session.update(customer);

        transaction.commit();
        session.close();
        */

        /////////////////////////////
        /**  delete();  */
        /*
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 2);

        session.delete(customer);

        transaction.commit();
        session.close();
        */
    }
}

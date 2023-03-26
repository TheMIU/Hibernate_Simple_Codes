import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class Main {
    public static void main(String[] args) {

        /** Hibernate Life Cycle - state 4
                1* Transient
                2* Persistent
                3* Detach
                4* Removed
         */

        Session session1 = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction1 = session1.beginTransaction();

        System.out.println("\n============== Transient State --> Persistent State ==============");

        Customer c1 = new Customer(); // Transient State
        c1.setCusID("C001");
        c1.setName("John");
        c1.setAddress("New York");

        session1.save(c1); // Persistent State
        System.out.println("Check 1 : "+ session1.get(Customer.class,"C001"));

        transaction1.commit();
        session1.close();

        System.out.println("\n============== Detached State --> Persistent State ==============");

        Session session2 = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction2 = session2.beginTransaction();

        session2.detach(c1);
        c1.setAddress("Roswell"); // Detached State (not saved in DB)
        System.out.println("Check 2 : "+ session2.get(Customer.class,"C001"));

        //session2.delete(c1);  <<-- Can't remove detached state object

        session2.merge(c1); // Detached State --> Persistent State
        System.out.println("Check 3 : "+ session2.get(Customer.class,"C001"));

        transaction2.commit();
        session2.close();

        System.out.println("\n============== Persistent State --> Removed State ==============");

        Session session3 = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction3 = session3.beginTransaction();

        session3.delete(session3.get(Customer.class,"C001")); // Removed State

        transaction3.commit();
        session3.close();
    }
}

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

public class Main {
    public static void main(String[] args) {

        /**  get() vs load()
         * get  <-- Eager
                කෙලින්ම DB එකට යනො. (query එක ගහල)
         * load <-- Lazy
                කෙලින්ම DB එකට යන්නෙ නෑ  (Lazy), Data එක හොයාගන්න ඕන වෙන වෙලාවට DB එකට යනෝ query එක ගහල.
         */

        /*Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(new Customer("C001","John","New York"));

        transaction.commit();
        session.close();*/

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("\n=======get()=======");
        Customer getCustomer = session.get(Customer.class,"C001");
        System.out.println("ID: "+ getCustomer.getCusID());
        System.out.println("Address: "+getCustomer.getAddress());

        transaction.commit();
        session.close();

        //============================

        Session session2 = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction2 = session2.beginTransaction();

        System.out.println("\n=======load()=======");
        Customer loadCustomer = session2.load(Customer.class,"C001");
        System.out.println("ID: "+ loadCustomer.getCusID());
        System.out.println("Address: "+loadCustomer.getAddress());

        transaction2.commit();
        session2.close();
    }
}

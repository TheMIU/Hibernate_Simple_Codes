import entity.Customer;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /** One To Many */

        Customer c1 = new Customer();
        c1.setCusId("C001");
        c1.setName("John");
        c1.setAddress("New York");

        List<Orders> ordersList = new ArrayList<>();
        Orders order1 = new Orders("O001", LocalDate.now(),c1);
        Orders order2 = new Orders("O002", LocalDate.now(),c1);

        ordersList.add(order1);
        ordersList.add(order2);
        c1.setOrdersList(ordersList);

        session.save(c1);
        session.save(order1);
        session.save(order2);

        transaction.commit();
        session.close();
    }
}

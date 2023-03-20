import entity.Item;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        /** Many To Many
         * method 01 (Without entity for Associate table) */

        Item item = new Item();
        item.setItemCode("I001");
        item.setDescription("Soap");
        item.setQtyOnHand(10);
        item.setUnitPrice(100);

        Orders orders = new Orders();
        orders.setOrderId("O001");
        orders.setCustomerID("C001");
        orders.setDate(LocalDate.now());

        /** add to array list */
            // long way
            /*ArrayList<Item> itemsList = new ArrayList<>();
            itemsList.add(item);

            ArrayList<Orders> ordersList = new ArrayList<>();
            ordersList.add(orders);

            item.setOrdersList(ordersList);
            orders.setItemList(itemsList);*/

            // short way
            item.getOrdersList().add(orders);
            orders.getItemList().add(item);


        // Persist to DB
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(orders);
        session.save(item);

        transaction.commit();
        session.close();
    }
}

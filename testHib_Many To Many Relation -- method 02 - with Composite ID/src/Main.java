import embeddable.OrderDetailPK;
import entity.Item;
import entity.OrderDetails;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryConfiguration;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        /** Many To Many
         * method 02 (With entity for Associate table)
         * Composite ID */

        Item item = new Item();
        item.setItemCode("I001");
        item.setDescription("Soap");
        item.setQtyOnHand(10);
        item.setUnitPrice(100);

        Orders orders = new Orders();
        orders.setOrderId("O001");
        orders.setCustomerID("C001");
        orders.setDate(LocalDate.now());

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderDetailPK( new OrderDetailPK(item.getItemCode(),orders.getOrderId())); // set composite ID
        orderDetails.setUnitPrice(item.getUnitPrice());
        orderDetails.setQty(1);

        // add to array list
        item.getOrderDetailsList().add(orderDetails);
        orders.getOrderDetailsList().add(orderDetails);

        // Persist to DB
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(orders);
        session.save(item);
        session.save(orderDetails);

        transaction.commit();
        session.close();
    }
}

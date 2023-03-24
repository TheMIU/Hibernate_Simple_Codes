import entity.Customer;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.SessionFactoryConfiguration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

       /* Customer c1 = new Customer();
        c1.setCusId("C001");
        c1.setName("John");
        c1.setAddress("New York");

        Customer c2 = new Customer();
        c2.setCusId("C002");
        c2.setName("Jessy");
        c2.setAddress("Tokyo");

        Customer c3 = new Customer();
        c3.setCusId("C003");
        c3.setName("Henry");
        c3.setAddress("Moscow");

        List<Orders> ordersList = new ArrayList<>();
        Orders order1 = new Orders("O001", LocalDate.now(),c1);
        Orders order2 = new Orders("O002", LocalDate.now(),c1);

        ordersList.add(order1);
        ordersList.add(order2);
        c1.setOrdersList(ordersList);

        session.save(c1);
        session.save(c2);
        session.save(c3);
        session.save(order1);
        session.save(order2);*/

        /** HQL , SQL  + Hibernate */
//=====================================================================

        /**================== HQL ======================= */
        // SELECT
        /*String hql = "FROM Customer";
        Query query = session.createQuery(hql);
        List<Customer> customers = query.list();

        for (Customer c : customers) {
            System.out.println(c);
        }*/

        // SELECT an attribute
        /*String hql = "SELECT name FROM Customer";
        Query query = session.createQuery(hql);
        List<String> customerNames = query.list();

        for (String names: customerNames) {
            System.out.println(names);
        }*/

        // WHERE
        /*String hql = "FROM Customer WHERE name LIKE 'J%' ";
        List<Customer> customers = session.createQuery(hql).list();

        for (Customer c : customers) {
            System.out.println(c);
        }*/

        // ORDER BY
        /*String hql = "FROM Customer ORDER BY id DESC";
        List<Customer> customers = session.createQuery(hql).list();

        for (Customer c : customers) {
            System.out.println(c);
        }*/

        /** Using name parameters  */

        // SELECT
        /*String name = "John";
        String hql = "FROM Customer WHERE name = :cus_name";
        Query query = session.createQuery(hql);
        query.setParameter("cus_name",name);
        List<Customer> customers = query.list();

        for (Customer c : customers) {
            System.out.println(c);
        }*/

        //UPDATE
        /*String name = "John Wick";
        String id = "C001";

        String hql = "UPDATE Customer SET name = :cus_name WHERE id = :cus_id";
        Query query = session.createQuery(hql);

        query.setParameter("cus_name", name);
        query.setParameter("cus_id", id);

        int rowCount = query.executeUpdate();
        System.out.println(rowCount > 0 ? "Succeed!" : "Error");*/

        //DELETE
        /*String name = "Henry";

        String hql = "DELETE FROM Customer WHERE name = :cus_name";
        Query query = session.createQuery(hql);

        query.setParameter("cus_name",name);

        System.out.println(query.executeUpdate() > 0 ? "Deleted!" : "Error!");*/

        /** JOIN QUERY */
        /*String hql = "SELECT C.id , C.name, O.id FROM Customer C INNER JOIN Orders O ON C.id = O.customer";
        Query query = session.createQuery(hql);

        List<Object[]> resultList = query.list();

        for (Object[] obj : resultList) {
            System.out.println(obj[0] + " : " + obj[1] + " : " + obj[2]);
        }*/


        /**================== SQL ======================= */
        // SELECT
        String SQL = "SELECT * FROM Customer";
        NativeQuery sqlQuery = session.createSQLQuery(SQL);

        sqlQuery.addEntity(Customer.class);

        List<Customer> customers = sqlQuery.list();

        for (Customer c:customers) {
            System.out.println(c.getCusId() +" : "+c.getName() +" : "+ c.getAddress());
        }


        transaction.commit();
        session.close();
    }
}

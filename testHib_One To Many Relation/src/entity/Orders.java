package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;

@Entity
public class Orders {
    @Id
    private String orderId;
    private LocalDate date;

    @ManyToOne
    private Customer customer;

    public Orders() {
    }

    public Orders(String orderId, LocalDate date, Customer customer) {
        this.orderId = orderId;
        this.date = date;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                '}';
    }
}

package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id
    private String orderId;
    private LocalDate date;
    private String customerID;

    @ManyToMany(mappedBy = "ordersList")
    private List<Item> itemList =  new ArrayList<>();

    public Orders() {
    }

    public Orders(String orderId, LocalDate date, String customerID, List<Item> itemList) {
        this.orderId = orderId;
        this.date = date;
        this.customerID = customerID;
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
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

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}

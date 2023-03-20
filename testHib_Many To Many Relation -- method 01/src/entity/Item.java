package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
    private String ItemCode;
    private String description;
    private double UnitPrice;
    private int QtyOnHand;

    @ManyToMany
    private List<Orders> ordersList =  new ArrayList<>();

    public Item() {
    }

    public Item(String itemCode, String description, double unitPrice, int qtyOnHand, List<Orders> ordersList) {
        ItemCode = itemCode;
        this.description = description;
        UnitPrice = unitPrice;
        QtyOnHand = qtyOnHand;
        this.ordersList = ordersList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        QtyOnHand = qtyOnHand;
    }
}

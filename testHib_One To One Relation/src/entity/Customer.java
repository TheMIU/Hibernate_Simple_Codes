package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "customer")
public class Customer {
    @Id
    private String cusId;
    private String name;
    private String address;

    public Customer() {
    }

    public Customer(String cusId, String name, String address) {
        this.cusId = cusId;
        this.name = name;
        this.address = address;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "customer_detail")
public class CustomerDetail {
    @Id
    private String bookID;
    private int age;
    private String phoneNum;

    @OneToOne
    private Customer customer;

    public CustomerDetail() {
    }

    public CustomerDetail(String bookID, int age, String phoneNum, Customer customer) {
        this.bookID = bookID;
        this.age = age;
        this.phoneNum = phoneNum;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}

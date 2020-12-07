package com.joshua.pim.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productID;
    private String productName;
    @ManyToOne
    @JoinColumn(name = "addedby", referencedColumnName = "userName")
    private Users users;
    private String created_on = generateDateTime();


    private String generateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy hh:mm:ss a");
        return LocalDateTime.now().format(formatter);
    }
    public Product(){

    }

    public Product(long productID, String productName, Users users) {
        this.productID = productID;
        this.productName = productName;
        this.users = users;
    }

    public long getProductID() {
        return productID;
    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", users=" + users +
                ", created_on='" + created_on + '\'' +
                '}';
    }
}

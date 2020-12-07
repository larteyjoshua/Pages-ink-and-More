package com.joshua.pim.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Stock")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long stockID;
    @ManyToOne
    @JoinColumn(name = "productName", referencedColumnName = "productName")
    private Product product;
    private int quantity;
    private double price;
    @ManyToOne
    @JoinColumn(name = "departName", referencedColumnName = "departName")
    private Department department;
    private String updated_on = generateDateTime();


    private String generateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy hh:mm:ss a");
        return LocalDateTime.now().format(formatter);
    }
    public Stock (){


    }

    public Stock(long stockID, Product product, int quantity, double price, Department department) {
        this.stockID = stockID;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.department = department;
    }

    public long getStockID() {
        return stockID;
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(String updated_on) {
        this.updated_on = updated_on;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockID=" + stockID +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", department=" + department +
                ", updated_on='" + updated_on + '\'' +
                '}';
    }
}

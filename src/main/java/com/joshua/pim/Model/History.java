package com.joshua.pim.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "History")
public class History implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long historyID;
    @ManyToOne
    @JoinColumn(name = "productName", referencedColumnName = "productName")
    private Product product;
    private int productQantity;
    private double subtotal;
    private String created_on =generateDateTime();
    @ManyToOne
    @JoinColumn(name = "departName", referencedColumnName = "departName")
    private Department department;

    public  History() {
    }

    public History(Product product, int productQantity, double subtotal, Department department) {
        this.product = product;
        this.productQantity = productQantity;
        this.subtotal = subtotal;
        this.department = department;
    }

    private String generateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy hh:mm:ss a");
        return LocalDateTime.now().format(formatter);
    }

    public long getHistoryID() {
        return historyID;
    }

    public void setHistoryID(long historyID) {
        this.historyID = historyID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductQantity() {
        return productQantity;
    }

    public void setProductQantity(int productQantity) {
        this.productQantity = productQantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "History{" +
                "historyID=" + historyID +
                ", product=" + product +
                ", productQantity=" + productQantity +
                ", subtotal=" + subtotal +
                ", created_on='" + created_on + '\'' +
                ", department=" + department +
                '}';
    }
}

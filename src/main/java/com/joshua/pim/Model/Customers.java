package com.joshua.pim.Model;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "Customers")

public class Customers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerID;
    private String customerName;
    private String mobileNumber;
    private String created_on = generateDateTime();

    public Customers() {
    }
    public Customers(long customerID, String customerName, String mobileNumber) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
    }
    private String generateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy hh:mm:ss a");
        return LocalDateTime.now().format(formatter);
    }

    public long getCustomerID() {
        return customerID;
    }



    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return customerID == customers.customerID &&
                Objects.equals(customerName, customers.customerName) &&
                Objects.equals(mobileNumber, customers.mobileNumber) &&
                Objects.equals(created_on, customers.created_on);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, customerName, mobileNumber, created_on);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", created_on='" + created_on + '\'' +
                '}';
    }


}

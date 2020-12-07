package com.joshua.pim.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="Department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departID;
    private String departName;
    private String created_on = generateDateTime();
    @ManyToOne
    @JoinColumn(name = "createdby", referencedColumnName = "userName")
    private Users users;

    private String generateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy hh:mm:ss a");
        return LocalDateTime.now().format(formatter);
    }

    public Department(){

    }

    public Department(String departName, Users users) {
        this.departName = departName;
        this.users = users;
    }

    public long getDepartID() {
        return departID;
    }

    public void setDepartID(long departID) {
        this.departID = departID;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departID=" + departID +
                ", departName='" + departName + '\'' +
                ", created_on='" + created_on + '\'' +
                ", users=" + users +
                '}';
    }
}

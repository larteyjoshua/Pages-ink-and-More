package com.joshua.pim.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userID;
    private String userName;

    @Column(unique = true, name = "email")
    private String email;
    private String created_on =generateDateTime() ;
    private String password;

    public Users(){

    }

    public Users( String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    private String generateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy hh:mm:ss a");
        return LocalDateTime.now().format(formatter);
    }

    public long getUserID() {
        return userID;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getUserID() == users.getUserID() &&
                Objects.equals(getUserName(), users.getUserName()) &&
                Objects.equals(getEmail(), users.getEmail()) &&
                Objects.equals(getCreated_on(), users.getCreated_on()) &&
                Objects.equals(getPassword(), users.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getUserName(), getEmail(), getCreated_on(), getPassword());
    }

    @Override
    public String toString() {
        return "Users{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", created_on='" + created_on + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

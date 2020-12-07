package com.joshua.pim.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name= "UserRole")
public class UserRole  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long userroleID;
    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @JsonIgnore
    private Users users;

    @OneToOne
    @JoinColumn(name = "roleID", referencedColumnName = "roleID")
    @JsonIgnore
    private Roles roles;

    public UserRole(){

    }
    public UserRole(long userroleID, Users users, Roles roles) {
        this.userroleID = userroleID;
        this.users = users;
        this.roles = roles;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "users=" + users +
                ", roles=" + roles +
                '}';
    }
}

package com.joshua.pim.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name ="Roles")
public class Roles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleID;
    private String roleName;
    private String created_on = generateDateTime();

    private String generateDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy hh:mm:ss a");
        return LocalDateTime.now().format(formatter);
    }

    public Roles(){


    }
    public Roles(long roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public long getRoleID() {
        return roleID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roles)) return false;
        Roles roles = (Roles) o;
        return getRoleID() == roles.getRoleID() &&
                Objects.equals(getRoleName(), roles.getRoleName()) &&
                Objects.equals(getCreated_on(), roles.getCreated_on());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleID(), getRoleName(), getCreated_on());
    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleID=" + roleID +
                ", roleName='" + roleName + '\'' +
                ", created_on='" + created_on + '\'' +
                '}';
    }
}

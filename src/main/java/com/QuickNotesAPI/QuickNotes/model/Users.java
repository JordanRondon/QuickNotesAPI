package com.QuickNotesAPI.QuickNotes.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "users_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usersId;

    @Column(name = "users_role")
    private String role;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true, name = "email")
    private String email;
    @Column(name = "users_password")
    private String usersPassword;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "visible")
    private boolean visible;

    public Users() {
    }

    public Users(int usersId, String role, String firstName, String lastName, String email, String usersPassword,
            LocalDateTime creationDate, boolean visible) {
        this.usersId = usersId;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.usersPassword = usersPassword;
        this.creationDate = creationDate;
        this.visible = visible;
    }

    public void setUsersId(int users_id) {
        this.usersId = users_id;
    }

    public int getUsersId() {
        return this.usersId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setUsersPassword(String users_password) {
        this.usersPassword = users_password;
    }

    public String getUsersPassword() {
        return this.usersPassword;
    }

    public void setCreationDate(LocalDateTime creation_date) {
        this.creationDate = creation_date;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getVisible() {
        return this.visible;
    }
}

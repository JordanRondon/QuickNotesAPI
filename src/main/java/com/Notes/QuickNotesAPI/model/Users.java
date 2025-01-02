package com.Notes.QuickNotesAPI.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usersId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String usersPassword;
    @Column(nullable = false)
    private LocalDateTime creationDate;

    public Users() {
    }

    public Users(int usersId, String firstName, String lastName, String email, String usersPassword,
            LocalDateTime creationDate) {
        this.usersId = usersId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.usersPassword = usersPassword;
        this.creationDate = creationDate;
    }

    public void setUsersId(int users_id) {
        this.usersId = users_id;
    }

    public int getUsersId() {
        return this.usersId;
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
}

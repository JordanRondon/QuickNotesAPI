package com.QuickNotesAPI.QuickNotes.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a user in the QuickNotes system.
 * This class is mapped to the "users" table in the database.
 */
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

    /**
     * Parameterized constructor for creating a user instance.
     *
     * @param usersId       the unique identifier of the user
     * @param role          the role of the user
     * @param firstName     the first name of the user
     * @param lastName      the last name of the user
     * @param email         the email of the user
     * @param usersPassword the password of the user
     * @param creationDate  the date and time of user creation
     * @param visible       whether the user is visible/active
     */
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

    /**
     * Sets the user ID.
     *
     * @param users_id the unique identifier of the user
     */
    public void setUsersId(int users_id) {
        this.usersId = users_id;
    }

    /**
     * Gets the user ID.
     *
     * @return the unique identifier of the user
     */
    public int getUsersId() {
        return this.usersId;
    }

    /**
     * Sets the role of the user.
     *
     * @param role the role of the user
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the role of the user.
     *
     * @return the role of the user
     */
    public String getRole() {
        return this.role;
    }

    /**
     * Sets the first name of the user.
     *
     * @param first_name the first name of the user
     */
    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    /**
     * Gets the first name of the user.
     *
     * @return the first name of the user
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param last_name the last name of the user
     */
    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    /**
     * Gets the last name of the user.
     *
     * @return the last name of the user
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the password of the user.
     *
     * @param users_password the password of the user
     */
    public void setUsersPassword(String users_password) {
        this.usersPassword = users_password;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    public String getUsersPassword() {
        return this.usersPassword;
    }

    /**
     * Sets the creation date of the user.
     *
     * @param creation_date the date and time of user creation
     */
    public void setCreationDate(LocalDateTime creation_date) {
        this.creationDate = creation_date;
    }

    /**
     * Gets the creation date of the user.
     *
     * @return the date and time of user creation
     */
    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the visibility status of the user.
     *
     * @param visible whether the user is visible/active
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Gets the visibility status of the user.
     *
     * @return true if the user is visible/active, false otherwise
     */
    public boolean getVisible() {
        return this.visible;
    }
}

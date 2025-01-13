package com.QuickNotesAPI.QuickNotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.QuickNotesAPI.QuickNotes.model.Users;

import jakarta.transaction.Transactional;

/**
 * Repository interface for performing CRUD operations and custom queries on the
 * Users entity.
 */
public interface IUsersRepository extends JpaRepository<Users, Integer> {

    /**
     * Retrieves a list of users whose last names start with the specified initial.
     *
     * @param lastNameInitial the initial of the last name to search for
     * @return a list of users matching the criteria
     */
    @Query("SELECT us FROM Users us WHERE us.lastName LIKE CONCAT(:lastNameInitial, '%')")
    public List<Users> getListUsersByLastNameInit(@Param("lastNameInitial") String lastNameInitial);

    /**
     * Finds a user by their email if the user is marked as visible.
     *
     * @param email the email of the user to search for
     * @return the user matching the email, or null if not found or not visible
     */
    @Query("SELECT us FROM Users us WHERE us.email = :email AND us.visible = true")
    public Users findByEmail(@Param("email") String email);

    /**
     * Disables a user by setting their visible attribute to false.
     *
     * This operation is transactional and modifies the database.
     *
     * @param userId the ID of the user to disable
     */
    @Modifying
    @Transactional
    @Query("UPDATE Users us SET us.visible = false WHERE us.usersId = :userId")
    public void disable(@Param("userId") int userId);

}

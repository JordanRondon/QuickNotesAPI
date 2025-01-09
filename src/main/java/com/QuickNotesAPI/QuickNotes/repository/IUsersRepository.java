package com.QuickNotesAPI.QuickNotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.QuickNotesAPI.QuickNotes.model.Users;

import jakarta.transaction.Transactional;

public interface IUsersRepository extends JpaRepository<Users, Integer> {

    @Query("SELECT us FROM Users us WHERE us.lastName LIKE CONCAT(:lastNameInitial, '%')")
    public List<Users> getListUsersByLastNameInit(@Param("lastNameInitial") String lastNameInitial);

    @Query("SELECT us FROM Users us WHERE us.email = :email AND us.visible = true")
    public Users findByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query("UPDATE Users us SET us.visible = false WHERE us.usersId = :userId")
    public void disable(@Param("userId") int userId);

}

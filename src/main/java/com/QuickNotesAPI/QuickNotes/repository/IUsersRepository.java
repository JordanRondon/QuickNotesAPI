package com.QuickNotesAPI.QuickNotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.QuickNotesAPI.QuickNotes.model.Users;

public interface IUsersRepository extends JpaRepository<Users, Integer> {

    @Query("SELECT us FROM Users us WHERE us.lastName LIKE CONCAT(:lastNameInitial, '%')")
    public List<Users> getListUsersByLastNameInit(@Param("lastNameInitial") String lastNameInitial);

}
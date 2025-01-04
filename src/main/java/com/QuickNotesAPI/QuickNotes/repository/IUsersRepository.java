package com.QuickNotesAPI.QuickNotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuickNotesAPI.QuickNotes.model.Users;

public interface IUsersRepository extends JpaRepository<Users, Integer> {

}

package com.Notes.QuickNotesAPI.service.Interface;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.Notes.QuickNotesAPI.model.Users;

public interface IUsersService {

    public Users getUsersById(int UserId);

    public List<Users> listUsers();

    public List<User> getUsersByLastNameInit(String lastNameInitial);

    public boolean AuthenticateUser(String email, String password);
}

package com.Notes.QuickNotesAPI.service;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.Notes.QuickNotesAPI.model.Users;
import com.Notes.QuickNotesAPI.service.Interface.IUsersService;

@Service
public class UsersService implements IUsersService {

    @Override
    public Users getUsersById(int UserId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsersById'");
    }

    @Override
    public List<Users> listUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listUsers'");
    }

    @Override
    public List<User> getUsersByLastNameInit(String lastNameInitial) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsersByLastNameInit'");
    }

    @Override
    public boolean AuthenticateUser(String email, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AuthenticateUser'");
    }

}

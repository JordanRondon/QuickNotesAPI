package com.Notes.QuickNotesAPI.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Repository;

import com.Notes.QuickNotesAPI.model.Users;
import com.Notes.QuickNotesAPI.repository.Interface.IUsersRepository;

@Repository
public class UsersRepository implements IUsersRepository {

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

package com.QuickNotesAPI.QuickNotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuickNotesAPI.QuickNotes.model.Users;
import com.QuickNotesAPI.QuickNotes.repository.IUsersRepository;
import com.QuickNotesAPI.QuickNotes.service.Interface.IUsersService;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private IUsersRepository usersRepository;

    @Override
    public List<Users> getListUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserById(int userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

}

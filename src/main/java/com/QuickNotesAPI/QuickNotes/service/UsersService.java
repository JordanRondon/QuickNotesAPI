package com.QuickNotesAPI.QuickNotes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.QuickNotesAPI.QuickNotes.model.Users;
import com.QuickNotesAPI.QuickNotes.repository.IUsersRepository;
import com.QuickNotesAPI.QuickNotes.service.Interface.IUsersService;

public class UsersService implements IUsersService {

    @Autowired
    private IUsersRepository usersRepository;

    @Override
    public Users getUserById(int userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

}

package com.QuickNotesAPI.QuickNotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.QuickNotesAPI.QuickNotes.model.Users;
import com.QuickNotesAPI.QuickNotes.repository.IUsersRepository;
import com.QuickNotesAPI.QuickNotes.service.Interface.IUsersService;
import com.QuickNotesAPI.QuickNotes.util.JwtUtil;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public List<Users> getListUsers() {
        return usersRepository.findAll();
    }

    @Override
    public List<Users> getListUsersByLastNameInitial(String lastNameInitial) {
        return usersRepository.getListUsersByLastNameInit(lastNameInitial);
    }

    @Override
    public Users getUserById(int userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    @Override
    public void register(Users user) {
        String encodedPassword = passwordEncoder.encode(user.getUsersPassword());
        user.setUsersPassword(encodedPassword);
        usersRepository.save(user);
    }

    @Override
    public String login(String email, String password) {
        Users userDetails = usersRepository.findByEmail(email);

        if (userDetails == null) {
            throw new RuntimeException("Invalid mail");
        }

        if (!passwordEncoder.matches(password, userDetails.getUsersPassword())) {
            throw new RuntimeException("Incorrect password");
        }

        return jwtUtil.generateJWT(userDetails);
    }

    @Override
    public void disable(int userId) {
        usersRepository.disable(userId);
    }

}

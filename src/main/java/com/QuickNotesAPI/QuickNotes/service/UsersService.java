package com.QuickNotesAPI.QuickNotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.QuickNotesAPI.QuickNotes.model.Users;
import com.QuickNotesAPI.QuickNotes.repository.IUsersRepository;
import com.QuickNotesAPI.QuickNotes.service.Interface.IUsersService;
import com.QuickNotesAPI.QuickNotes.util.JwtUtil;

/**
 * Service class that implements the business logic for managing users.
 */
@Service
public class UsersService implements IUsersService {

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Retrieves a list of all users.
     *
     * @return a list of all users in the system
     */
    @Override
    public List<Users> getListUsers() {
        return usersRepository.findAll();
    }

    /**
     * Retrieves a list of users whose last names start with a specific initial.
     *
     * @param lastNameInitial the initial of the last name to search for
     * @return a list of users matching the criteria
     */
    @Override
    public List<Users> getListUsersByLastNameInitial(String lastNameInitial) {
        return usersRepository.getListUsersByLastNameInit(lastNameInitial);
    }

    /**
     * Retrieves a user by their unique ID.
     *
     * @param userId the ID of the user to retrieve
     * @return the user matching the ID
     * @throws RuntimeException if no user is found with the given ID
     */
    @Override
    public Users getUserById(int userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    /**
     * Registers a new user in the system, encoding their password before saving.
     *
     * @param user the user to register
     */
    @Override
    public void register(Users user) {
        String encodedPassword = passwordEncoder.encode(user.getUsersPassword());
        user.setUsersPassword(encodedPassword);
        usersRepository.save(user);
    }

    /**
     * Authenticates a user by their email and password, returning a JWT if
     * successful.
     *
     * @param email    the email of the user
     * @param password the password of the user
     * @return a JWT for the authenticated user
     * @throws RuntimeException if the email is invalid or the password is incorrect
     */
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

    /**
     * Disables a user by setting their visibility to false.
     *
     * @param userId the ID of the user to disable
     */
    @Override
    public void disable(int userId) {
        usersRepository.disable(userId);
    }

}

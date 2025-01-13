package com.QuickNotesAPI.QuickNotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuickNotesAPI.QuickNotes.model.Users;
import com.QuickNotesAPI.QuickNotes.service.UsersService;

/**
 * REST controller for handling authentication-related operations, such as user
 * registration and login.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsersService usersService;

    /**
     * Registers a new user in the system.
     *
     * @param user the user to register, provided in the request body
     * @return a response entity with a success message and HTTP status 201 if the
     *         user is registered successfully,
     *         or an error message and HTTP status 500 if an exception occurs
     */
    @PostMapping("/register")
    private ResponseEntity<String> register(@RequestBody Users user) {
        try {
            usersService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    /**
     * Authenticates a user by validating their email and password, and returns a
     * JWT upon successful login.
     *
     * @param user the user credentials, including email and password, provided in
     *             the request body
     * @return a response entity with the JWT token and HTTP status 200 if login is
     *         successful,
     *         or an error message and HTTP status 500 if an exception occurs
     */
    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody Users user) {
        try {
            String email = user.getEmail();
            String password = user.getUsersPassword();
            String jwt = usersService.login(email, password);
            return ResponseEntity.ok(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }
}

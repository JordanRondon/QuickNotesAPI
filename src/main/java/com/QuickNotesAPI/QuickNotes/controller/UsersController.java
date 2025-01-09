package com.QuickNotesAPI.QuickNotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuickNotesAPI.QuickNotes.model.Users;
import com.QuickNotesAPI.QuickNotes.service.UsersService;

@RestController
@RequestMapping("/api/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/list")
    private ResponseEntity<List<Users>> getListUsers() {
        try {
            List<Users> listUsers = usersService.getListUsers();
            return ResponseEntity.ok(listUsers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/list/{lastNameInitial}")
    private ResponseEntity<List<Users>> getListUsersByLastNameInitial(@PathVariable String lastNameInitial) {
        try {
            List<Users> listUsers = usersService.getListUsersByLastNameInitial(lastNameInitial);
            return ResponseEntity.ok(listUsers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{userId}")
    private ResponseEntity<Users> getUserById(@PathVariable int userId) {
        try {
            Users user = usersService.getUserById(userId);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

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

    @PatchMapping("/disable/{userId}")
    private ResponseEntity<String> disable(@PathVariable int userId) {
        try {
            usersService.disable(userId);
            return ResponseEntity.status(HttpStatus.CREATED).body("User successfully disabled");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }
}

package com.QuickNotesAPI.QuickNotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuickNotesAPI.QuickNotes.model.Users;
import com.QuickNotesAPI.QuickNotes.service.UsersService;

/**
 * REST controller that handles HTTP requests related to users.
 * Provides basic CRUD operations to interact with user data.
 */
@RestController
@RequestMapping("/api/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * Method that gets the list of all users.
     *
     * @return Returns a list of users if the operation is successful,
     *         or a 404 error if something goes wrong.
     */
    @GetMapping("/list")
    private ResponseEntity<List<Users>> getListUsers() {
        try {
            List<Users> listUsers = usersService.getListUsers();
            return ResponseEntity.ok(listUsers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Method that gets a list of users filtered by the initial of their last name.
     *
     * @param lastNameInitial: The initial of the last name that is used to filter
     *                         the users.
     * @return list of filtered users if the operation is successful,
     *         or a 404 error if a problem occurs.
     */
    @GetMapping("/list/{lastNameInitial}")
    private ResponseEntity<List<Users>> getListUsersByLastNameInitial(@PathVariable String lastNameInitial) {
        try {
            List<Users> listUsers = usersService.getListUsersByLastNameInitial(lastNameInitial);
            return ResponseEntity.ok(listUsers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Method that gets a specific user by its ID.
     *
     * @param userId: The ID of the user to search for.
     * @return user if found, or a 404 error if not found.
     */
    @GetMapping("/{userId}")
    private ResponseEntity<Users> getUserById(@PathVariable int userId) {
        try {
            Users user = usersService.getUserById(userId);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Method that deactivates a user given their ID.
     *
     * @param userId: The ID of the user to be deactivated.
     * @return a success message if the operation is successful,
     *         or a 500 error if an unexpected problem occurs.
     */
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

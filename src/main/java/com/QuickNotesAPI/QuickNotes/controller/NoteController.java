package com.QuickNotesAPI.QuickNotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuickNotesAPI.QuickNotes.model.Note;
import com.QuickNotesAPI.QuickNotes.service.NoteService;

/**
 * REST controller that handles HTTP requests related to user notes.
 * Provides basic CRUD operations to interact with notes associated with a user.
 */
@RestController
@RequestMapping("/api/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    /**
     * Method that gets the list of notes associated with a user given their ID.
     *
     * @param userId: The ID of the user whose list of notes you want to get.
     * @return list of notes if the operation is successful,
     *         or a 404 error if a problem occurs.
     */
    @GetMapping("/list/{userId}")
    private ResponseEntity<List<Note>> getListNoteByUserId(@PathVariable int userId) {
        try {
            List<Note> listNote = noteService.getListNoteByUserId(userId);
            return ResponseEntity.ok(listNote);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Method that saves a new note associated with a user given their ID.
     *
     * @param note:   The note to be saved.
     * @param userId: The ID of the user to whom the note will be associated.
     * @return success message if the operation is successful,
     *         or a 500 error if an unexpected problem occurs.
     */
    @PostMapping("/save/{userId}")
    private ResponseEntity<String> saveByUserId(@RequestBody Note note, @PathVariable int userId) {
        try {
            noteService.saveByUserId(note, userId);
            return ResponseEntity.status(HttpStatus.CREATED).body("Note registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    /**
     * Method that updates an existing note.
     *
     * @param note: The note with the updated data.
     * @return success message if the operation is successful,
     *         or a 500 error if an unexpected problem occurs.
     */
    @PutMapping("/update")
    private ResponseEntity<String> updateById(@RequestBody Note note) {
        try {
            noteService.updateById(note);
            return ResponseEntity.status(HttpStatus.CREATED).body("Note successfully updated");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    /**
     * Method that deletes a note given its ID.
     *
     * @param noteId: The ID of the note to be deleted.
     * @return a success message if the operation is successful,
     *         or a 500 error if an unexpected problem occurs.
     */
    @DeleteMapping("/delete/{noteId}")
    private ResponseEntity<String> deleteById(@PathVariable int noteId) {
        try {
            noteService.deleteById(noteId);
            return ResponseEntity.status(HttpStatus.CREATED).body("Note successfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

}

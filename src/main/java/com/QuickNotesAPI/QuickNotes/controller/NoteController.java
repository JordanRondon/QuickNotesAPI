package com.QuickNotesAPI.QuickNotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuickNotesAPI.QuickNotes.model.Note;
import com.QuickNotesAPI.QuickNotes.service.NoteService;

@RestController
@RequestMapping("/api/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/list/{userId}")
    private ResponseEntity<List<Note>> getListNoteByUserId(@PathVariable int userId) {
        try {
            List<Note> listNote = noteService.getListNoteByUserId(userId);
            return ResponseEntity.ok(listNote);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/save/{userId}")
    private ResponseEntity<String> save(@RequestBody Note note, @PathVariable int userId) {
        try {
            noteService.save(note, userId);
            return ResponseEntity.status(HttpStatus.CREATED).body("Note registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    private ResponseEntity<String> update(@RequestBody Note note) {
        try {
            noteService.update(note);
            return ResponseEntity.status(HttpStatus.CREATED).body("Note successfully updated");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

}

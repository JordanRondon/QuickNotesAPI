package com.QuickNotesAPI.QuickNotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuickNotesAPI.QuickNotes.model.Note;
import com.QuickNotesAPI.QuickNotes.model.Users;
import com.QuickNotesAPI.QuickNotes.repository.INoteRepository;
import com.QuickNotesAPI.QuickNotes.service.Interface.INoteService;
import com.QuickNotesAPI.QuickNotes.service.Interface.IUsersService;

/**
 * Service class that implements the business logic for managing notes.
 */
@Service
public class NoteService implements INoteService {

    @Autowired
    private INoteRepository noteRepository;

    @Autowired
    private IUsersService usersService;

    /**
     * Retrieves a list of notes associated with a specific user.
     *
     * @param userId the ID of the user whose notes are to be retrieved
     * @return a list of notes for the specified user
     */
    @Override
    public List<Note> getListNoteByUserId(int userId) {
        return noteRepository.getListNoteByUserId(userId);
    }

    /**
     * Saves a new note and associates it with a specific user.
     *
     * @param note   the note to be saved
     * @param userId the ID of the user to associate with the note
     */
    @Override
    public void saveByUserId(Note note, int userId) {
        Users user = usersService.getUserById(userId);
        note.setUser(user);
        noteRepository.save(note);
    }

    /**
     * Updates an existing note by its ID with new details.
     *
     * @param modifiedNote the note containing the updated details
     * @throws RuntimeException if no note is found with the specified ID
     */
    @Override
    public void updateById(Note modifiedNote) {
        int noteId = modifiedNote.getNoteId();
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + noteId));
        note.setTitle(modifiedNote.getTitle());
        note.setTextNote(modifiedNote.getTextNote());
        note.setCreationDate(modifiedNote.getCreationDate());
        note.setNumberCharacters(modifiedNote.getTextNote().length());
        noteRepository.save(note);
    }

    /**
     * Deletes a note by its ID.
     *
     * @param noteId the ID of the note to delete
     */
    @Override
    public void deleteById(int noteId) {
        noteRepository.deleteById(noteId);
    }

}

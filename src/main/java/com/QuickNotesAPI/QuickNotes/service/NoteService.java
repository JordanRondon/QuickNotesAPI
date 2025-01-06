package com.QuickNotesAPI.QuickNotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuickNotesAPI.QuickNotes.model.Note;
import com.QuickNotesAPI.QuickNotes.model.Users;
import com.QuickNotesAPI.QuickNotes.repository.INoteRepository;
import com.QuickNotesAPI.QuickNotes.service.Interface.INoteService;
import com.QuickNotesAPI.QuickNotes.service.Interface.IUsersService;

@Service
public class NoteService implements INoteService {

    @Autowired
    private INoteRepository noteRepository;

    @Autowired
    private IUsersService usersService;

    @Override
    public List<Note> getListNoteByUserId(int userId) {
        return noteRepository.getListNoteByUserId(userId);
    }

    @Override
    public void saveByUserId(Note note, int userId) {
        Users user = usersService.getUserById(userId);
        note.setUser(user);
        noteRepository.save(note);
    }

    @Override
    public void updateById(Note modifiedNote) {
        int noteId = modifiedNote.getNoteId();
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + noteId));
        note.setTitle(modifiedNote.getTitle());
        note.setTextNote(modifiedNote.getTextNote());
        note.setCreationDate(modifiedNote.getCreationDate());
        noteRepository.save(note);
    }

    @Override
    public void deleteById(int noteId) {
        noteRepository.deleteById(noteId);
    }

}

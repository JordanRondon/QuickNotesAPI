package com.QuickNotesAPI.QuickNotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuickNotesAPI.QuickNotes.model.Note;
import com.QuickNotesAPI.QuickNotes.repository.INoteRepository;
import com.QuickNotesAPI.QuickNotes.service.Interface.INoteService;

@Service
public class NoteService implements INoteService {

    @Autowired
    private INoteRepository noteRepository;

    @Override
    public List<Note> getListNoteByUserId(int userId) {
        return noteRepository.getListNoteByUserId(userId);
    }

}

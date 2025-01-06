package com.QuickNotesAPI.QuickNotes.service.Interface;

import java.util.List;

import com.QuickNotesAPI.QuickNotes.model.Note;

public interface INoteService {

    public List<Note> getListNoteByUserId(int userId);

    public void save(Note note, int userId);

    public void update(Note note);

    public void delete(int noteId);

}

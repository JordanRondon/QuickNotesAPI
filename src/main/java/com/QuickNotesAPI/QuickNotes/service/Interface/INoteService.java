package com.QuickNotesAPI.QuickNotes.service.Interface;

import java.util.List;

import com.QuickNotesAPI.QuickNotes.model.Note;

public interface INoteService {

    public List<Note> getListNoteByUserId(int userId);

    public void saveByUserId(Note note, int userId);

    public void updateById(Note note);

    public void deleteById(int noteId);

}

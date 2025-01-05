package com.QuickNotesAPI.QuickNotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.QuickNotesAPI.QuickNotes.model.Note;

public interface INoteRepository extends JpaRepository<Note, Integer> {

    @Query("""
            SELECT nt FROM Note nt
            WHERE nt.user.usersId = :userId
            AND nt.user.visible = true
            AND nt.visible = true
                """)
    public List<Note> getListNoteByUserId(@Param("userId") int userId);

}

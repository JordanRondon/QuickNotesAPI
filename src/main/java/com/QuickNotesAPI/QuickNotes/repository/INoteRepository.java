package com.QuickNotesAPI.QuickNotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.QuickNotesAPI.QuickNotes.model.Note;

/**
 * Repository interface to perform CRUD operations integrating JpaRepository
 * and custom queries on the Note entity.
 */
public interface INoteRepository extends JpaRepository<Note, Integer> {

    /**
     * Retrieves a list of notes created by a specific user whose visibility is set
     * to true.
     *
     * @param userId the ID of the user whose notes are to be retrieved
     * @return a list of notes associated with the user
     */
    @Query("""
            SELECT nt FROM Note nt
            WHERE nt.user.usersId = :userId
            AND nt.user.visible = true
                """)
    public List<Note> getListNoteByUserId(@Param("userId") int userId);

}

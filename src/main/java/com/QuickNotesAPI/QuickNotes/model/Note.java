package com.QuickNotesAPI.QuickNotes.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represents a note in the QuickNotes system.
 * This class is mapped to the "note" table in the database.
 */
@Entity
@Table(name = "note")
public class Note {
    @Id
    @Column(name = "note_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    @Column(name = "title")
    private String title;
    @Column(name = "text_note")
    private String textNote;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "number_characters")
    private int numberCharacters;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private Users user;

    public Note() {

    }

    /**
     * Parameterized constructor for creating a note instance.
     *
     * @param noteId           the unique identifier of the note
     * @param title            the title of the note
     * @param textNote         the content of the note
     * @param creationDate     the date and time of note creation
     * @param numberCharacters the number of characters in the note
     * @param user             the user who created the note
     */
    public Note(int noteId, String title, String textNote, LocalDateTime creationDate, int numberCharacters,
            Users user) {
        this.noteId = noteId;
        this.title = title;
        this.textNote = textNote;
        this.creationDate = creationDate;
        this.numberCharacters = numberCharacters;
        this.user = user;
    }

    /**
     * Sets the note ID.
     *
     * @param noteId the unique identifier of the note
     */
    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    /**
     * Gets the note ID.
     *
     * @return the unique identifier of the note
     */
    public int getNoteId() {
        return this.noteId;
    }

    /**
     * Sets the title of the note.
     *
     * @param title the title of the note
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the title of the note.
     *
     * @return the title of the note
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the content of the note.
     *
     * @param textNote the content of the note
     */
    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    /**
     * Gets the content of the note.
     *
     * @return the content of the note
     */
    public String getTextNote() {
        return this.textNote;
    }

    /**
     * Sets the creation date of the note.
     *
     * @param creationDate the date and time of note creation
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets the creation date of the note.
     *
     * @return the date and time of note creation
     */
    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets the number of characters in the note content.
     *
     * @param numberCharacters the number of characters in the note
     */
    public void setNumberCharacters(int numberCharacters) {
        this.numberCharacters = numberCharacters;
    }

    /**
     * Gets the number of characters in the note content.
     *
     * @return the number of characters in the note
     */
    public int getNumberCharacters() {
        return this.numberCharacters;
    }

    /**
     * Sets the user who created the note.
     *
     * @param user the user who created the note
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * Gets the user who created the note.
     *
     * @return the user who created the note
     */
    public Users getUser() {
        return this.user;
    }

}

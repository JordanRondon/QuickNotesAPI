package com.Notes.QuickNotesAPI.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;
    @Column(nullable = true)
    private String title;
    @Column(nullable = false)
    private String textNote;
    @Column(nullable = false)
    private LocalDateTime creationDate;
    @Column(nullable = false)
    private int numberCharacters;

    @ManyToOne
    private Users user;

    public Note() {

    }

    public Note(int noteId, String title, String textNote, LocalDateTime creationDate, int numberCharacters,
            Users user) {
        this.noteId = noteId;
        this.title = title;
        this.textNote = textNote;
        this.creationDate = creationDate;
        this.numberCharacters = numberCharacters;
        this.user = user;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getNoteId() {
        return this.noteId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    public String getTextNote() {
        return this.textNote;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public void setNumberCharacters(int numberCharacters) {
        this.numberCharacters = numberCharacters;
    }

    public int getNumberCharacters() {
        return this.numberCharacters;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUser() {
        return this.user;
    }
}

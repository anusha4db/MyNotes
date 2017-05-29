package com.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "repositories")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userId")
    @NotEmpty
    private String userId;

    @Column(name = "title")
    @NotEmpty
    private String title;

    @Column(name = "noteContent")
    @NotEmpty
    private String noteContent;


    public Note(String title, String noteContent) {
        this.title = title;
        this.noteContent = noteContent;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", noteContent='" + noteContent + '\'' +
                '}';
    }
}

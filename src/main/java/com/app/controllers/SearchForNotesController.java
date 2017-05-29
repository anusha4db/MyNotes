package com.app.controllers;

import com.app.model.Note;
import com.app.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SearchForNotesController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping(value = "/searchForNotes")
    public List<Note> searchForNotes(
            @RequestParam String noteTitle) {
        List<Note> result = noteRepository.findByTitleContainingIgnoreCase(noteTitle);

        if (result.isEmpty()) {
            this.getNotes();
        }

        return result;
    }


    private List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();

        noteRepository.findAll().forEach(notes::add);
        return notes;
    }

}

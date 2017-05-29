package com.app.controllers;

import com.app.model.Note;
import com.app.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CreateNoteController {

    @Autowired
    private NoteRepository noteRepository;


    @PutMapping(value = "/CreateNote")
    public Note createNote(
            @RequestParam String title,
            @RequestParam String content) {
        Note note = new Note(title, content);

        noteRepository.save(note);

        return note;
    }


}

package com.app.service;

import com.app.model.UserNote;
import com.app.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyNotesService {

    @Autowired
    NoteRepository noteRepository;

    public List<UserNote> getAllUserNotes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        List<UserNote> notesList = noteRepository.findAllByUsernameOrderByTitle(authentication.getName());

        return notesList;
    }


}

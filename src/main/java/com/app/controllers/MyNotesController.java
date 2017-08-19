package com.app.controllers;

import com.app.service.MyNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyNotesController {

    @Autowired
    MyNotesService myNotesService;

    @GetMapping(value = "/myNotes")
    public String getNotes(Model model) {

        model.addAttribute("notesList", myNotesService.getAllUserNotes());

        return "myNotes";
    }

}

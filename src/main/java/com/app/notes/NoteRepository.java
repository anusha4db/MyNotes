package com.app.notes;


import com.app.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByTitleContainingIgnoreCase(String Title);

}

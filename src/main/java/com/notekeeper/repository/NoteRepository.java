package com.notekeeper.repository;

import com.notekeeper.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Integer> {
}

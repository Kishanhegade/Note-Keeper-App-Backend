package com.notekeeper.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "notes")
@Getter
@Setter
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Integer noteId;

    @Column(name="title")
    private String title;

    @Column(name="details")
    private String content;
}

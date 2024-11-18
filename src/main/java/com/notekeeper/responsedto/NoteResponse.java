package com.notekeeper.responsedto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteResponse {

    private Integer noteId;
    private String title;
    private String content;
}

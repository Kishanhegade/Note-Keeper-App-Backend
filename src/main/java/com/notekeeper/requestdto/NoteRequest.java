package com.notekeeper.requestdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequest {

    private String title;
    private String content;
}

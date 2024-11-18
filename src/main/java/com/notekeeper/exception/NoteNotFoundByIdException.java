package com.notekeeper.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoteNotFoundByIdException extends RuntimeException {
    private String message;

    @Override
    public String getMessage() {
        return this.message;
    }

}

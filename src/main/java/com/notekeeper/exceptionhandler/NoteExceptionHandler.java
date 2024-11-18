package com.notekeeper.exceptionhandler;

import com.notekeeper.exception.NoteNotFoundByIdException;
import com.notekeeper.utility.AppResponseBuilder;
import com.notekeeper.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class NoteExceptionHandler {
    private AppResponseBuilder responseBuilder;

    @ExceptionHandler(NoteNotFoundByIdException.class)
    public ResponseEntity<ErrorStructure<String>> handleNoteNotFoundById(NoteNotFoundByIdException ex) {
        return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Note not found by given Id");
    }
}

package com.notekeeper.controller;

import com.notekeeper.requestdto.NoteRequest;
import com.notekeeper.responsedto.NoteResponse;
import com.notekeeper.service.NoteService;
import com.notekeeper.utility.AppResponseBuilder;
import com.notekeeper.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class NoteController {

    private NoteService noteService;
    private AppResponseBuilder responseBuilder;

    @GetMapping("/notes")
    public ResponseEntity<ResponseStructure<List<NoteResponse>>> getAllNotes() {
        List<NoteResponse> noteResponses = noteService.getAllNotes();
        return responseBuilder.success(HttpStatus.OK,"notes fetched", noteResponses);
    }
    @PostMapping("/notes")
    public ResponseEntity<ResponseStructure<NoteResponse>> saveNote(@RequestBody NoteRequest noteRequest) {
        NoteResponse noteResponse = noteService.saveNote(noteRequest);
        return responseBuilder.success(HttpStatus.CREATED,"note created",noteResponse);
    }
    @PutMapping("/notes/{noteId}")
    public ResponseEntity<ResponseStructure<NoteResponse>> updateNote(@PathVariable Integer noteId, @RequestBody NoteRequest noteRequest) {
        NoteResponse noteResponse = noteService.updateNote(noteId, noteRequest);
        return responseBuilder.success(HttpStatus.OK,"note updated", noteResponse);
    }
    @DeleteMapping("/notes/{noteId}")
    public ResponseEntity<ResponseStructure<NoteResponse>> deleteNote(@PathVariable Integer noteId) {
        NoteResponse noteResponse = noteService.deleteNote(noteId);
        return responseBuilder.success(HttpStatus.OK,"note deleted", noteResponse);
    }

}

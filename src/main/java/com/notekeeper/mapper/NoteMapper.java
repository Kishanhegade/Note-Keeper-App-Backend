package com.notekeeper.mapper;

import com.notekeeper.model.Note;
import com.notekeeper.requestdto.NoteRequest;
import com.notekeeper.responsedto.NoteResponse;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public Note mapToNoteEntity(NoteRequest noteRequest, Note notes) {
        notes.setTitle(noteRequest.getTitle());
        notes.setContent(noteRequest.getContent());
        return notes;
    }

    public NoteResponse mapToNoteResponse(Note notes) {
        NoteResponse noteResponse = new NoteResponse();
        noteResponse.setNoteId(notes.getNoteId());
        noteResponse.setContent(notes.getContent());
        noteResponse.setTitle(notes.getTitle());
        return noteResponse;
    }
}

package com.notekeeper.service;

import com.notekeeper.exception.NoteNotFoundByIdException;
import com.notekeeper.mapper.NoteMapper;
import com.notekeeper.model.Note;
import com.notekeeper.repository.NoteRepository;
import com.notekeeper.requestdto.NoteRequest;
import com.notekeeper.responsedto.NoteResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {

    private NoteRepository noteRepo;
    private NoteMapper noteMapper;

    public List<NoteResponse> getAllNotes() {
        return noteRepo.findAll().stream().map(note->noteMapper.mapToNoteResponse(note)).toList();
    }

    public NoteResponse saveNote(NoteRequest noteRequest) {
        Note note = noteMapper.mapToNoteEntity(noteRequest, new Note());
        note = noteRepo.save(note);
        return noteMapper.mapToNoteResponse(note);
    }

    public NoteResponse updateNote(Integer noteId, NoteRequest noteRequest) {

        return noteRepo.findById(noteId).map(note->{
            note = noteMapper.mapToNoteEntity(noteRequest, note);
            note = noteRepo.save(note);
            return noteMapper.mapToNoteResponse(note);
        }).orElseThrow(()-> new NoteNotFoundByIdException("Failed to update Note"));
    }

    public NoteResponse deleteNote(Integer noteId) {
        return noteRepo.findById(noteId)
                .map(note -> {
                    noteRepo.delete(note);
                    return noteMapper.mapToNoteResponse(note);
                })
                .orElseThrow(() -> new NoteNotFoundByIdException("Failed to delete note"));

    }
}

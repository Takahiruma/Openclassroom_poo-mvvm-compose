package com.openclassrooms.notes.service

import android.util.Log
import com.openclassrooms.notes.data.Note
import com.openclassrooms.notes.data.NoteData

/**
 * Implementation of the [NotesApiService] interface that stores note in local
 */
class LocalNotesApiService : NotesApiService {

    override fun addNote(note: Note) {
        NoteData.Notes.add(note)
    }

    override fun getAllNotes(): List<Note> {
        return NoteData.Notes.toList()
    }

    companion object
}
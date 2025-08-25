package com.openclassrooms.notes.service

import android.util.Log
import com.openclassrooms.notes.data.Note
import com.openclassrooms.notes.data.NoteData

/**
 * Implementation of the [NotesApiService] interface that stores note in local
 */
class LocalNotesApiService : NotesApiService {

    override fun addNote(note: Note) {
        Log.d("LocalNotesApiService", "Ajout de la note avec l'ID ${note.id}")
        NoteData.Notes.add(note)
        Log.d("LocalNotesApiService", "Liste après ajout : ${NoteData.Notes}")
    }

    override fun getAllNotes(): List<Note> {
        return NoteData.Notes.toList()
    }

    override fun deleteNoteById(id: Int) {
        NoteData.Notes.removeAll { it.id == id }
    }

    companion object
}
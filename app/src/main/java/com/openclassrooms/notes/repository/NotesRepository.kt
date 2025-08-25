package com.openclassrooms.notes.repository

import android.util.Log
import com.openclassrooms.notes.data.Note
import com.openclassrooms.notes.service.LocalNotesApiService
import com.openclassrooms.notes.service.NotesApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow

/**
 * Repository class for the notes.
 */
class NotesRepository {

    /**
     * The API service for interacting with notes.
     */
    private val notesApiService: NotesApiService = LocalNotesApiService()

    /**
     * A flow that emits a list of all notes.
     */
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    init {
        refreshNotes()
    }

    private fun refreshNotes() {
        _notes.value = notesApiService.getAllNotes().toList()
    }

    fun addNote(note: Note) {
        Log.d("NotesRepository", "ajout de la note avec l'ID ${note.id}")
        notesApiService.addNote(note)
        refreshNotes()
        Log.d("NotesRepository", "Liste ajout : ${_notes.value}")
    }

    /**
     * Deletes a note by its ID.
     * @param id The ID of the note to delete.
     */
    fun deleteNoteById(id: Int) {
        notesApiService.deleteNoteById(id)
        refreshNotes()
    }
}
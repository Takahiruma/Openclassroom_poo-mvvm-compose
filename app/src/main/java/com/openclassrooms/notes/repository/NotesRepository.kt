package com.openclassrooms.notes.repository

import android.util.Log
import com.openclassrooms.notes.data.Note
import com.openclassrooms.notes.service.LocalNotesApiService
import com.openclassrooms.notes.service.NotesApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Repository class for the notes.
 */
open class NotesRepository {

    /**
     * The API service for interacting with notes.
     */
    private val notesApiService: NotesApiService = LocalNotesApiService()

    /**
     * A flow that emits a list of all notes.
     */
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    open val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    init {
        refreshNotes()
    }

    private fun refreshNotes() {
        _notes.value = notesApiService.getAllNotes().toList()
    }

    open fun addNote(note: Note) {
        notesApiService.addNote(note)
        refreshNotes()
    }
}
package com.openclassrooms.notes

import com.openclassrooms.notes.data.Note
import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.service.NotesApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FakeNotesRepository : NotesRepository() {
    private val _fakeNotes = MutableStateFlow<List<Note>>(emptyList())
    override val notes: StateFlow<List<Note>> = _fakeNotes.asStateFlow()

    private val fakeNotesApiService = object : NotesApiService {
        private val internalNotes = mutableListOf<Note>()

        override fun getAllNotes(): List<Note> = internalNotes.toList()

        override fun addNote(note: Note) {
            internalNotes.add(note)
        }
    }

    override fun addNote(note: Note) {
        fakeNotesApiService.addNote(note)
        refreshNotes()
    }


    private fun refreshNotes() {
        _fakeNotes.value = fakeNotesApiService.getAllNotes()
    }

    fun setNotes(newNotes: List<Note>) {
        newNotes.forEach { fakeNotesApiService.addNote(it) }
        refreshNotes()
    }
}

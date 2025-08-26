package com.openclassrooms.notes

import com.openclassrooms.notes.data.Note
import com.openclassrooms.notes.service.NotesApiService

class FakeNotesApiService(private var notes: MutableList<Note> = mutableListOf()) :
    NotesApiService {
    override fun getAllNotes(): List<Note> = notes.toList()

    override fun addNote(note: Note) {
        notes.add(note)
    }

    fun setNotes(newNotes: List<Note>) {
        notes.clear()
        notes.addAll(newNotes)
    }
}

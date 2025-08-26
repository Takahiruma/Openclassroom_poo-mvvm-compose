package com.openclassrooms.notes.data

import com.openclassrooms.notes.repository.NotesRepository

object RepositorySingleton {
    val notesRepository: NotesRepository by lazy {
        NotesRepository()
    }
}

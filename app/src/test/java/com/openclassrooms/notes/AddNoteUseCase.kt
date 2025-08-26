package com.openclassrooms.notes

import com.openclassrooms.notes.data.Note
import com.openclassrooms.notes.repository.NotesRepository

class AddNoteUseCase(
    private val repository: NotesRepository
) {
    /**
     * Ajoute une note avec le titre et le contenu spécifiés.
     * @param title Le titre de la note.
     * @param body Le contenu de la note.
     */
    suspend operator fun invoke(title: String, body: String) {
        val note = Note(
            title = title,
            body = body
        )
        repository.addNote(note)
    }
}
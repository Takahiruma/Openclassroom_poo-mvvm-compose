package com.openclassrooms.notes

import com.openclassrooms.notes.data.Note
import com.openclassrooms.notes.data.NoteData
import com.openclassrooms.notes.service.LocalNotesApiService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LocalNotesApiServiceTest {

    private lateinit var localNotesApiService: LocalNotesApiService

    @Before
    fun setup() {
        NoteData.Notes.clear()
        localNotesApiService = LocalNotesApiService()
    }

    @Test
    fun `getAllNotes should return empty list initially`() {
        // When
        val notes = localNotesApiService.getAllNotes()

        // Then
        assertEquals(emptyList<Note>(), notes)
    }

    @Test
    fun `addNote should add note to the list`() {
        // Given
        val note = Note(title = "Titre", body = "Contenu")

        // When
        localNotesApiService.addNote(note)

        // Then
        val notes = localNotesApiService.getAllNotes()
        assertEquals(1, notes.size)
        assertEquals("Titre", notes[0].title)
        assertEquals("Contenu", notes[0].body)
    }

    @Test
    fun `getAllNotes should return all added notes`() {
        // Given
        val note1 = Note(title = "Titre 1", body = "Contenu 1")
        val note2 = Note(title = "Titre 2", body = "Contenu 2")
        localNotesApiService.addNote(note1)
        localNotesApiService.addNote(note2)

        // When
        val notes = localNotesApiService.getAllNotes()

        // Then
        assertEquals(2, notes.size)
        assertEquals("Titre 1", notes[0].title)
        assertEquals("Contenu 1", notes[0].body)
        assertEquals("Titre 2", notes[1].title)
        assertEquals("Contenu 2", notes[1].body)
    }
}

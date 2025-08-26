package com.openclassrooms.notes

import com.openclassrooms.notes.data.Note
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class NotesRepositoryTest {

    private lateinit var fakeApiService: FakeNotesApiService
    private lateinit var repository: FakeNotesRepository

    @Before
    fun setup() {
        fakeApiService = FakeNotesApiService()
        repository = FakeNotesRepository()
    }

    @Test
    fun `notes flow should emit correct list`() = runTest {
        // Given
        val expectedNotes = listOf(Note(title = "Note 1", body = "Body 1"))
        repository.setNotes(expectedNotes)

        // Then
        assertEquals(expectedNotes, repository.notes.first())
    }

    @Test
    fun `addNote should add note to list`() = runTest {
        // Given
        val note = Note(title = "Note 1", body = "Body 1")

        // When
        repository.addNote(note)

        // Then
        assertEquals(listOf(note), repository.notes.first())
    }
}

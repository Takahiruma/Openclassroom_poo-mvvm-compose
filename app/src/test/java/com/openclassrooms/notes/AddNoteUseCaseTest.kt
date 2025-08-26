package com.openclassrooms.notes

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertEquals

class AddNoteUseCaseTest {

    private lateinit var fakeRepository: FakeNotesRepository
    private lateinit var addNoteUseCase: AddNoteUseCase

    @Before
    fun setup() {
        fakeRepository = FakeNotesRepository()
        addNoteUseCase = AddNoteUseCase(fakeRepository)
    }

    @Test
    fun `invoke should add note to repository`() = runTest {
        // When
        addNoteUseCase("Titre", "Contenu")

        // Then
        val allNotes = fakeRepository.notes.first()
        assertEquals(1, allNotes.size)
        assertEquals("Titre", allNotes[0].title)
    }
}


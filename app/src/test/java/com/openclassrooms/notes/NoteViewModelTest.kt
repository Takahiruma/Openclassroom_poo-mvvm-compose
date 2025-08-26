package com.openclassrooms.notes

import NoteViewModel
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.openclassrooms.notes.data.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class NoteViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var fakeRepository: FakeNotesRepository
    private lateinit var viewModel: NoteViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)

        fakeRepository = FakeNotesRepository()
        viewModel = NoteViewModel(fakeRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `notes should be empty initially`() = runTest {
        // Then
        assertEquals(emptyList<Note>(), viewModel.notes.value)
    }

    @Test
    fun `addNote should update notes list`() = runTest {
        // When
        viewModel.addNote("Titre", "Contenu")

        // Then
        assertEquals(1, viewModel.notes.value.size)
        assertEquals("Titre", viewModel.notes.value[0].title)
    }
}


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.notes.data.Note
import com.openclassrooms.notes.repository.NotesRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoteViewModel(private val notesRepository: NotesRepository) : ViewModel() {
    val notes: StateFlow<List<Note>> = notesRepository.notes

    fun addNote(title: String, body: String) {
        viewModelScope.launch {
            val newId = notes.value.maxOfOrNull { it.id }?.plus(1) ?: 1
            val newNote = Note(title = title, body = body, id = newId)
            notesRepository.addNote(newNote)
        }
    }

    fun deleteNote(id: Int) {
        viewModelScope.launch {
            notesRepository.deleteNoteById(id)
        }
    }
}
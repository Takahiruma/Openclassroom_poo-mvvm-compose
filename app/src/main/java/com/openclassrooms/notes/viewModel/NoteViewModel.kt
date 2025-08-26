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
            val newNote = Note(title = title, body = body)
            notesRepository.addNote(newNote)
        }
    }


}
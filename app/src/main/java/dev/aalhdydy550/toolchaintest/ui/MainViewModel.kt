package dev.aalhdydy550.toolchaintest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.aalhdydy550.toolchaintest.data.Note
import dev.aalhdydy550.toolchaintest.data.NoteDao
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val noteDao: NoteDao,
) : ViewModel() {
    val noteCount: StateFlow<Int> = noteDao.count()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    fun addNote(text: String) {
        viewModelScope.launch { noteDao.insert(Note(text = text)) }
    }
}

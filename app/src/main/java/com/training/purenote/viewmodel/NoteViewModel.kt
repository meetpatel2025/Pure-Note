package com.training.purenote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.training.purenote.model.Note
import com.training.purenote.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application,
                    private val noteRepository: NoteRepository) :
    AndroidViewModel(app) {

    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.isertNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        noteRepository.updateNote(note)

    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }

    fun getAllNotes() = noteRepository.getAllNotes()
    fun searchNote(query: String?) = noteRepository
        .searchNotes(query)

}
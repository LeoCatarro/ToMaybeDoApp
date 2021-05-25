package com.example.tomaybedoapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application){

    private val listAllNotes: LiveData<List<Note>>
    private val repository: NoteRepository

    init {
        val noteDao = ToMaybeDoAppDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        listAllNotes = repository.listAllNotes
    }

    fun addNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(note)
        }
    }
}
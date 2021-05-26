package com.example.tomaybedoapp.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tomaybedoapp.db.ToMaybeDoAppDatabase
import com.example.tomaybedoapp.models.Note
import com.example.tomaybedoapp.repo.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application){

    val listAllNotes: LiveData<List<Note>>
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
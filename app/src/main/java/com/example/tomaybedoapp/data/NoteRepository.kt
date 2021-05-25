package com.example.tomaybedoapp.data

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

    val listAllNotes: LiveData<List<Note>> = noteDao.listAllNotes()

    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }
}
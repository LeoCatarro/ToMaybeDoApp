package com.example.tomaybedoapp.repo

import androidx.lifecycle.LiveData
import com.example.tomaybedoapp.db.NoteDao
import com.example.tomaybedoapp.models.Note

class NoteRepository(private val noteDao: NoteDao) {

    val listAllNotes: LiveData<List<Note>> = noteDao.listAllNotes()

    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }
}
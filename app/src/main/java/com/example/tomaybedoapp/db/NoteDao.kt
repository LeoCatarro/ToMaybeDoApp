package com.example.tomaybedoapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tomaybedoapp.models.Note

@Dao
interface NoteDao {

    //Insert Note into the table
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    //Select all Notes from table
    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun listAllNotes(): LiveData<List<Note>>

    //Update Note
    @Update
    suspend fun updateNote(note: Note)
}
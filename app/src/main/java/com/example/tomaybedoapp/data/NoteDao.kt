package com.example.tomaybedoapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {

    //Insert Note into the table
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    //Select all Notes from table
    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun listAllNotes(): LiveData<List<Note>>
}
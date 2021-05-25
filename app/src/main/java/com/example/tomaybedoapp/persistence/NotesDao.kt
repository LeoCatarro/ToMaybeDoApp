package com.example.tomaybedoapp.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDao {

    //Select all Query
    @Query("SELECT * FROM Notes ORDER BY id ASC")
    fun getAlphabetizedNotes(): LiveData<List<NotesModel>>

    //Insert
    @Insert
    fun insert(note: NotesModel)
}
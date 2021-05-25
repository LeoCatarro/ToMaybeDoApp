package com.example.tomaybedoapp.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
class NotesModel {
    @PrimaryKey(autoGenerate = false)
    var id: Int,

    @ColumnInfo(name = "note_title")
    var title: String
        get() = field
        set(value) {field = value},

    @ColumnInfo(name = "note_description")
    var description: String,


    constructor(id: Int, title: String, description: String) {
        this.id = id
        this.title = title
        this.description = description
    }

    override fun toString(): String {
        return "NotesModel(id='$id', title='$title', description='$description')"
    }
}
package com.example.notify.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
//    @ColumnInfo(name="note_title")
    val title: String,
    val description: String,
    //Room doesn't directly support complex types (like colors)
    val color:Int //store color as ARGB integer
)

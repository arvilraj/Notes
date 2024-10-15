package com.example.notify.repository

import androidx.lifecycle.LiveData
import com.example.notify.roomdb.Note
import com.example.notify.roomdb.NoteDao

// Repository server as a single source of data
class NotesRepository (private val noteDao: NoteDao){

    val allNotes : LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insertNote(note: Note){
        return noteDao.insert(note)
    }
}
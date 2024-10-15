package com.example.notify.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notify.repository.NotesRepository
import com.example.notify.roomdb.Note
import kotlinx.coroutines.launch

//View Model: store & manage UI related Data
class NoteViewModel(private  val repository: NotesRepository)
    : ViewModel(){
    val allNotes:LiveData<List<Note>> = repository.allNotes

    fun insert(note: Note)=
        viewModelScope.launch {
            repository.insertNote(note)
        }

}
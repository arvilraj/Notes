package com.example.notify.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notify.roomdb.Note

@Composable
fun DisplayNotesList(notes:List<Note>){
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
    modifier=Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ){
        items(notes){
            note -> NoteListItem(note = note)
        }
    }
}

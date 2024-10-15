package com.example.notify

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.example.notify.repository.NotesRepository
import com.example.notify.roomdb.NotesDB
import com.example.notify.screens.DisplayNotesList
import com.example.notify.screens.DisplayText
import com.example.notify.ui.theme.NotifyTheme
import com.example.notify.viewModel.NoteViewModel
import com.example.notify.viewModel.NoteViewModelFactory

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Room DB
        val database = NotesDB.getInstance(applicationContext)

        //Repository
        val repository = NotesRepository(database.noteDao)

        //ViewModel Factory
        val viewModelFactory = NoteViewModelFactory(repository)

        //ViewModel
        val noteViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[NoteViewModel::class.java]


        // observeAsState will add dependencies no to worry
        setContent {
            NotifyTheme {

            }
            //Scaffold
            Scaffold(
                floatingActionButton = { MyFAB(viewModel = noteViewModel) }
            ) {
                val notes by noteViewModel
                    .allNotes.observeAsState(emptyList())

                DisplayNotesList(notes = notes)
            }
        }
    }
}


@Composable
fun MyFAB(viewModel: NoteViewModel){
    // Controlling the dialog appearance
    var showDialog by remember {
        mutableStateOf(false)
    }

    DisplayText(
        viewModel= viewModel,
        showDialog= showDialog) {
        showDialog=false
    }

    FloatingActionButton(
        onClick = {showDialog=true},
        containerColor= Color.Black,
        contentColor= Color.White
    ) {
Icon(
    imageVector = Icons.Filled.Add,
    contentDescription ="Add Note")
    }
}


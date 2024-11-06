package com.example.notify.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.example.notify.roomdb.Note
import com.example.notify.viewModel.NoteViewModel

@Composable
fun DisplayText(viewModel: NoteViewModel,
                showDialog: Boolean,
                onDismiss: () -> Unit) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedColor by remember { mutableStateOf(Color.Cyan) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss, // Dismiss on outside click or back button
            title = { Text(text = "Enter Note") },
            text = {
                Column {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text(text = "Title") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text(text = "Note") }
                    )
                    Spacer(modifier = Modifier.height(18.dp))

                    // Color picker composable
                    MyColorPicker(
                        selectedColor = selectedColor,
                        onColorSelected = { selectedColor = it }
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val note = Note(
                            id = 0,
                            title = title,
                            description = description,
                            color = selectedColor.toArgb() // Convert color to ARGB integer
                        )
                        viewModel.insert(note) // Save the note
                        onDismiss() // Close the dialog after saving
                    }
                ) {
                    Text(text = "Save")
                }
            },
            dismissButton = {
                Button(onClick = { onDismiss() }) { // Invoke the dismiss callback
                    Text(text = "Cancel")
                }
            }
        )
    }
}

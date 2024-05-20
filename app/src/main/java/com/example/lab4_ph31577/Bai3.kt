package com.example.lab4_ph31577

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun Bai3(){
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        showDialogAddNew(onDismiss = { showDialog = false })

    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showDialog = true
            }) {
                Icon(Icons.Filled.Add,
                    contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        NoteApp(innerPadding)
    }
}



@Composable
fun NoteApp(paddingValues: PaddingValues) {
//    val notes = listOf("Note 1", "Note 2", "Note 3", "Note 4",
//        "Note 5")
    LazyColumn(modifier =
    Modifier
        .padding(paddingValues)
        .padding(8.dp)) {
       items(listNote.size){
           index ->
           NoteCard(index)
        }
    }
}


@Composable
fun NoteCard(index: Int) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                color = Color.LightGray, shape =
                MaterialTheme.shapes.medium
            )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = listNote[index],
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand Note",
                modifier =
                Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}



val listNote = mutableStateListOf("Content 1", "Content 2", "Content 3")


@Composable
fun showDialogAddNew(onDismiss: () -> Unit) {
    val context = LocalContext.current
    var content by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Add new note", style = MaterialTheme.typography.labelLarge)
        },
        text = {

                OutlinedTextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("Content") })
                Spacer(modifier = Modifier.height(2.dp))


        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
            TextButton(onClick = {
                if (content.isNotBlank() ) {
                    listNote.add(
                        content,
                    )

                    onDismiss()
                    Toast.makeText(
                        context, "Add New Note successful",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else {
                    Toast.makeText(
                        context, "Please enter title or content",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }) {
                Text(text = "Save")

            }
        }
    )
}




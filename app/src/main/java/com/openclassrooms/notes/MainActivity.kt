package com.openclassrooms.notes

import AddNoteScreen
import NoteViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.openclassrooms.notes.data.RepositorySingleton
import com.openclassrooms.notes.screens.NotesScreen
import com.openclassrooms.notes.ui.theme.NotesTheme
import com.openclassrooms.notes.viewModel.NoteViewModelFactory

/**
 * The main activity for the app.
 */
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                val navController = rememberNavController()
                val viewModel: NoteViewModel = viewModel(
                    factory = NoteViewModelFactory(RepositorySingleton.notesRepository)
                )
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(stringResource(id = R.string.app_name)) }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { navController.navigate("AddNoteScreen") }
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Ajouter une note")
                        }
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = "NotesScreen",
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable("NotesScreen") {
                            NotesScreen(
                                modifier = Modifier,
                                viewModel = viewModel
                            )
                        }
                        composable("AddNoteScreen") {
                            AddNoteScreen(
                                onSaveNote = { title, body ->
                                    viewModel.addNote(title, body)
                                    navController.popBackStack()
                                },
                                onBack = {
                                    navController.popBackStack()
                                },
                                modifier = Modifier
                            )
                        }
                    }
                }
            }
        }
    }
}


package com.example.notesappkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgs
import androidx.navigation.navArgument
import com.example.notesappkmm.android.note_list.NoteListScreen
import com.example.notesappkmm.android.notoeo_detail.NoteDetailScreen
import dagger.hilt.android.AndroidEntryPoint
import database.NoteEntity

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController( )
                NavHost(navController = navController, startDestination = "note_list"){
                    composable(route = "note_list"){
                        NoteListScreen(navController = navController)
                    }
                    composable(
                        route = "note_detail/{noteId}",
                        arguments = listOf(
                            navArgument(name = "noteId") {
                                type = NavType.LongType
                                defaultValue = -1L
                            }
                        )
                    ){
                        val noteId = it.arguments?.getLong("noteId")
                        NoteDetailScreen(noteId = noteId ?: -1L,navController = navController)
                    }

                }
            }
        }
    }
}


package com.kavkamagdalena.notes.ui.theme

import NoteScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                onItemClick = { note ->
                    navController.navigate("note/${note.ID}")
                },
                onAddClick = {
                    navController.navigate("note/new")
                }
            )
        }

        composable("note/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            NoteScreen(
                ID = id,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
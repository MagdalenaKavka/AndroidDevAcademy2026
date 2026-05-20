package com.kavkamagdalena.notes.ui.theme

import NoteScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {


        composable("login") {
            LoginScreen(onLoginSuccess = {
                navController.navigate("tasks") {
                    popUpTo("login") { inclusive = true }
                }
            })
        }

        composable("tasks") {
            TaskListScreen(
                onTaskClick = { id -> navController.navigate("editTask/$id") },
                onAddClick = { navController.navigate("editTask/new") }
            )
        }

        composable("editTask/{id}") { backStackEntry ->
            val idStr = backStackEntry.arguments?.getString("id")
            val id = if (idStr == "new") null else idStr?.toIntOrNull()
            EditTaskScreen(
                taskId = id,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("home") {
            HomeScreen(
                onItemClick = { note -> navController.navigate("note/${note.ID}") },
                onAddClick = { navController.navigate("note/new") }
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
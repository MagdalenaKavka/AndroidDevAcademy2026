package com.kavkamagdalena.bookshelf.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            MyItemList(onItemClick = { item ->
                navController.navigate("detail/${item.ID}")
            })
        }
        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            DetailScreen(ID = id, onBackClick = { navController.popBackStack() })
        }
    }
}
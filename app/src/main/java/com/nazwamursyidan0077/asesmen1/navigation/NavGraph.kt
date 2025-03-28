package com.nazwamursyidan0077.asesmen1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nazwamursyidan0077.asesmen1.ui.screen.ListGameScreen
import com.nazwamursyidan0077.asesmen1.ui.screen.MainScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            MainScreen(navController)
        }
        composable(route = Screen.ListGame.route) {
            ListGameScreen(navController)
        }
    }
}
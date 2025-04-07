package com.nazwamursyidan0077.asesmen1.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object ListGame: Screen("listGameScreen")
    data object About: Screen("aboutScreen")
    data object Me: Screen("meScreen")
}
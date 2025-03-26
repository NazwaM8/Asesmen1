package com.nazwamursyidan0077.asesmen1.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object ListPS2: Screen("listPS2Screen")
}
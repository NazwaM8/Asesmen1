package com.nazwamursyidan0077.asesmen1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nazwamursyidan0077.asesmen1.ui.screen.MainScreen
import com.nazwamursyidan0077.asesmen1.ui.theme.Asesmen1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Asesmen1Theme {
                MainScreen()
            }
        }
    }
}


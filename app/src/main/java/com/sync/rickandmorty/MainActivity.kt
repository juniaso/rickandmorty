package com.sync.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.sync.rickandmorty.ui.theme.RickandmortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickandmortyTheme {
                // Use MaterialTheme colors for the Surface background
                Surface(color = MaterialTheme.colorScheme.background) {
                    // Remember a NavController to navigate between composables
                    val navController = rememberNavController()

                    // Include the navigation graph in the UI tree
                    AppNavGraph(navController = navController)
                }
            }
        }
    }
}

package com.cybage.dogs_breed_app


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var isInternetAvailable by remember { mutableStateOf(true) } // Initialize with internet connectivity status

            // Check internet connectivity and update isInternetAvailable accordingly
            // Example:
            // isInternetAvailable = checkInternetConnectivity()
            MainNavigation(navController = navController, isInternetAvailable = isInternetAvailable)
        }
    }
}






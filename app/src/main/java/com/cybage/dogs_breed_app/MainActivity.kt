package com.cybage.dogs_breed_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogBreedsApp()
        }
    }
}


//    @Composable
//    fun DogBreedsApp() {
//        DogBreedsTheme {
//            Surface(color=MaterialTheme.colors.background) {
//                val navController=rememberNavController()
//                com.cybage.dogs_breed_app.ui.screen.DogListScreen(navController=navController)
//            }
//        }
//    }
//
//    @Preview(showBackground=true)
//    @Composable
//    fun DefaultPreview() {
//        DogBreedsApp()
//    }


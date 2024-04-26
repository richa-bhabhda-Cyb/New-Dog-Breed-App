package com.cybage.dogs_breed_app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.cybage.dogs_breed_app.ui.screen.DogListScreen

//import com.cybage.dogs_breed_app.ui.screen.RandomDogScreen

@Composable
fun DogBreedsApp() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colorScheme.background) {
        DogListScreen()
//        RandomDogScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DogBreedApp() {
DogListScreen()
}

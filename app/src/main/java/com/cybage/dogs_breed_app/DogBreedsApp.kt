package com.cybage.dogs_breed_app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cybage.dogs_breed_app.repository.DogRepository
import com.cybage.dogs_breed_app.ui.screen.DogListScreen
import com.cybage.dogs_breed_app.viewmodel.DogViewModel

//import com.cybage.dogs_breed_app.ui.screen.RandomDogScreen

@Composable
fun DogBreedsApp() {
    val navController : NavHostController = rememberNavController()
    Surface(color = MaterialTheme.colorScheme.background) {
        DogListScreen(DogViewModel(DogRepository()))
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun DogBreeds1App() {
//DogListScreen()
//}

@Preview(showBackground = true)
@Composable
fun DogBreeds1App() {
    val viewModel = DogViewModel(DogRepository()) // Create ViewModel instance
    DogListScreen(viewModel) // Pass ViewModel instance to DogListScreen
}

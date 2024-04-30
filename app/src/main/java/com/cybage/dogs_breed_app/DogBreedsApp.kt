package com.cybage.dogs_breed_app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cybage.dogs_breed_app.repository.DogRepository
import com.cybage.dogs_breed_app.ui.screen.DogListScreen
import com.cybage.dogs_breed_app.ui.screen.RandomDogScreen
import com.cybage.dogs_breed_app.viewmodel.DogViewModel

//import com.cybage.dogs_breed_app.ui.screen.RandomDogScreen

//@Composable
//fun DogBreedsApp() {
////    val navController : NavHostController = rememberNavController()
//    Surface(color = MaterialTheme.colorScheme.background) {
//        DogListScreen(DogViewModel(DogRepository()))
//    }
//}

//30-04-24
@Composable
fun DogBreedsApp() {
    Surface(color = MaterialTheme.colorScheme.background) {
        val viewModel = DogViewModel(DogRepository())
        DogListScreen(viewModel)
        RandomDogScreen()
    }
}



//@Preview(showBackground = true)
//@Composable
//fun DogBreeds1App() {
//    val viewModel :DogViewModel = viewModel(DogRepository)//(DogRepository()) // Create ViewModel instance
//    DogListScreen(viewModel) // Pass ViewModel instance to DogListScreen
//}

//30-04-24
@Preview(showBackground = true)
@Composable
fun DogBreeds1App() {
    val viewModel = DogViewModel(DogRepository()) // Create ViewModel instance with DogRepository
    DogListScreen(viewModel) // Pass ViewModel instance to DogListScreen
    RandomDogScreen()

}


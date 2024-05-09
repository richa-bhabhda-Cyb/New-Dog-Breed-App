package com.cybage.dogs_breed_app.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cybage.dogs_breed_app.DogBreedsApp
import com.cybage.dogs_breed_app.compose.OfflineScreen
import com.cybage.dogs_breed_app.repository.DogRepository
import com.cybage.dogs_breed_app.ui.screen.breedlist.DogListScreen
import com.cybage.dogs_breed_app.ui.screen.imagebybreed.DogImagesByBreed
import com.cybage.dogs_breed_app.ui.screen.randomimage.RandomDogScreen
import com.cybage.dogs_breed_app.ui.screen.randomimage.isNetworkAvailable
import com.cybage.dogs_breed_app.viewmodel.DogImagesByBreedViewModel
import com.cybage.dogs_breed_app.viewmodel.DogViewModel
import com.cybage.dogs_breed_app.viewmodel.RandomDogViewModel
import kotlinx.coroutines.Dispatchers


@Composable
fun MainNavigation(navController: NavController, context: Context) {
    val isInternetAvailable = isNetworkAvailable(context)

    if (isInternetAvailable) {
        NavHost(navController as NavHostController, startDestination = "DogBreedsApp") {
            composable("DogBreedsApp") {
                DogBreedsApp(navController)
            }
            composable("DogListScreen") {
                val viewModel = DogViewModel(DogRepository(context), Dispatchers.Main, context)
                DogListScreen(viewModel, navController)
            }
            composable("RandomDogImageScreen") {
                val viewModel = RandomDogViewModel(DogRepository(context))
                RandomDogScreen(viewModel, navController)
            }
            composable("DogImageByBreedScreen") {
                val viewModel = DogImagesByBreedViewModel((context))
                DogImagesByBreed(viewModel, navController)
            }
        }
    } else {
        OfflineScreen()
    }
}

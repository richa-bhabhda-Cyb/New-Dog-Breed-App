package com.cybage.dogs_breed_app.ui.screen
//
////
////@Composable
////fun DogListScreen(viewModel : DogViewModel, navController : NavController) {
////
////    val dogBreeds by viewModel.dogBreeds.collectAsState()
////    Column ( modifier = Modifier
////        .fillMaxSize())
////    {
////        NavigationBar(navController = navController , title = "Breedoze",showBackButton= true)
////
////        LazyColumn {
////            items(dogBreeds) { breed ->
////                DogBreedItem(breed = breed)
////            }
////        }
////    }
////}
//
////7-May:
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.LinearProgressIndicator
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.cybage.dogs_breed_app.NavigationBar
//import com.cybage.dogs_breed_app.ui.extensionfunctionforlivedata.collectAsState
//import com.cybage.dogs_breed_app.viewmodel.DogViewModel
//
//@Composable
//fun DogListScreen(viewModel: DogViewModel, navController: NavController) {
//    val context = LocalContext.current
//    val isConnected = isNetworkAvailable(context)
//
//    if (!isConnected) {
//        OfflineScreen()
//    } else {
//        val dogBreeds by viewModel.dogBreeds.collectAsState()
//        val isLoading = dogBreeds == null
//
//        Column(modifier = Modifier.fillMaxSize()) {
//            NavigationBar(navController = navController, title = "Breedoze", showBackButton = true)
//
//            if (isLoading) {
//                LinearProgressIndicator()
//            } else {
//                LazyColumn {
//                    items(dogBreeds) { breed ->
//                        DogBreedItem(breed = breed)
//                    }
//                }
//            }
//        }
//
//        LaunchedEffect(true) {
//            if (isLoading) {
//                viewModel.startFetchingDogBreeds()
//            }
//        }
//    }
//}
//
//
////
//@Composable
//fun DogBreedItem(breed: String) {
//    Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp) ,
//            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) ,
//            shape = MaterialTheme.shapes.medium ,
//    ) {
//        Column(
//                modifier = Modifier.padding(16.dp)
//        ) {
//            Text(
//                    text = breed ,
//                    style = MaterialTheme.typography.bodyLarge ,
//                    fontWeight = FontWeight.Bold ,
//                    color = Color.Black
//            )
//        }
//    }
//}
//
//
////
////
//////@Preview
//////@Composable
//////fun DogListScreenPreview() {
//////    val viewModel = DogViewModel(DogRepository()) // Provide ViewModel instance
//////    DogListScreen(viewModel)
//////}
////
////@Preview
////@Composable
////fun DogBreedItemPreview() {
////    DogBreedItem(breed = "Golden Retriever")
////}
//
//
//
//
//
//
//
//
//

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cybage.dogs_breed_app.NavigationBar
import com.cybage.dogs_breed_app.OfflineScreen
import com.cybage.dogs_breed_app.ui.extensionfunctionforlivedata.collectAsState
import com.cybage.dogs_breed_app.viewmodel.DogViewModel

@Composable
fun DogListScreen(viewModel: DogViewModel, navController: NavController) {
    val context = LocalContext.current
    val isConnected = isNetworkAvailable(context)

    if (!isConnected) {
        OfflineScreen()
    } else {
        val dogBreeds by viewModel.dogBreeds.collectAsState()
        val isLoading = false

        Column(modifier = Modifier.fillMaxSize()) {
            NavigationBar(navController = navController, title = "Breedoze", showBackButton = true)

            if (isLoading) {
                LinearProgressIndicator()
            } else {
                LazyColumn {
                    items(dogBreeds) { breed ->
                        DogBreedItem(breed = breed)
                    }
                }
            }
        }

        LaunchedEffect(true) {
            if (isLoading) {
                viewModel.startFetchingDogBreeds()
            }
        }
    }
}

@Composable
fun DogBreedItem(breed: String) {
    Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = MaterialTheme.shapes.medium,
    ) {
        Column(
                modifier = Modifier.padding(16.dp)
        ) {
            Text(
                    text = breed,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
            )
        }
    }
}


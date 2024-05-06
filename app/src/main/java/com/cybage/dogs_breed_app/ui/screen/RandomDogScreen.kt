package com.cybage.dogs_breed_app.ui.screen

// RandomDogScreen.kt
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.cybage.dogs_breed_app.NavigationBar
import com.cybage.dogs_breed_app.R
import com.cybage.dogs_breed_app.viewmodel.RandomDogViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoilApi::class)
@Composable
fun RandomDogScreen(viewModel: RandomDogViewModel = viewModel(RandomDogViewModel::class.java),navController : NavController) {
    val imageUrlState = viewModel.randomDogImageUrl.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    Column ( modifier = Modifier
        .fillMaxSize())
    {
        NavigationBar(navController = navController , title = "Breedoze")
    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        val imageUrl = imageUrlState.value

        if (imageUrl != null) {
            Image(
                    painter = rememberImagePainter(data = imageUrl),
                    contentDescription = "Random Dog Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
            )
        } else {
            Image(
                    painter = painterResource(id = R.drawable.lucy),
                    contentDescription = "Placeholder",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Use LaunchedEffect to launch a coroutine when the composable is first displayed
        LaunchedEffect(true) {
            coroutineScope.launch {
                viewModel.fetchRandomDogImage()
            }
        }

        Button(
                onClick = {
                    coroutineScope.launch {
                        viewModel.fetchRandomDogImage()
                    }
                },
                modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Show Random")
        }
    }
}}


//@Preview(showBackground = true)
//@Composable
//fun PreviewRandomDogScreen() {
//    RandomDogScreen(RandomDogViewModel(DogRepository()))
//}

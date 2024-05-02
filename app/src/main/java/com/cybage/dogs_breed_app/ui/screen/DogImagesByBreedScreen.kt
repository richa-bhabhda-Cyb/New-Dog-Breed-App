package com.cybage.dogs_breed_app.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.cybage.dogs_breed_app.viewmodel.DogImagesByBreedViewModel

@Composable
fun DogImagesByBreed(viewModel: DogImagesByBreedViewModel = viewModel()) {
    val breedState = remember { mutableStateOf("") }

    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        TextField(
                value = breedState.value,
                onValueChange = { breedState.value = it },
                label = { Text("Enter Dog Breed") },
                modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
                onClick = { viewModel.fetchBreedImages(breedState.value) },
                modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Show Images")
        }

        Spacer(modifier = Modifier.height(16.dp))

        val breedImages = viewModel.breedImages.value
        if (!breedImages.isNullOrEmpty()) {
            LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier.fillMaxWidth()
            ) {
                items(breedImages) { imageUrl ->
                    DogImageItem(imageUrl = imageUrl)
                }
            }
            }
        }
    }




@OptIn(ExperimentalCoilApi::class)
@Composable
fun DogImageItem(imageUrl: String) {
    // Load image using Coil and rememberImagePainter
    val painter: Painter = rememberImagePainter(
            data = imageUrl,
            builder = {
                // Optionally, apply transformations here
            }
    )

    // Display the loaded image
    Image(
            painter = painter,
            contentDescription = null, // Provide content description if needed
            modifier = Modifier.size(100.dp) // Adjust size as needed
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewBreedImagesScreen() {
    DogImagesByBreed()

}

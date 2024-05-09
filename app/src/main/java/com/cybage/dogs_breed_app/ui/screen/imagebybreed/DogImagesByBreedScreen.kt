package com.cybage.dogs_breed_app.ui.screen.imagebybreed

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cybage.dogs_breed_app.R
import com.cybage.dogs_breed_app.navigation.NavigationBar
import com.cybage.dogs_breed_app.viewmodel.DogImagesByBreedViewModel
import coil.compose.rememberImagePainter as rememberImagePainter1

@Composable
fun DogImagesByBreed(viewModel: DogImagesByBreedViewModel = viewModel(), navController: NavController) {
    val breedState = remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }

    Column(modifier = Modifier.fillMaxSize()) {
        NavigationBar(navController = navController, title = stringResource(id = R.string.app_title), showBackButton = true)

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
                    label = { Text(stringResource(id = R.string.enter_dog_breed)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { focusRequester.freeFocus() })
            )

            Spacer(modifier = Modifier.height(16.dp))

            val isLoading = viewModel.isLoading.value ?: false
            val breedImages = viewModel.breedImages.value
            val isError = viewModel.error.value?.isNotBlank() ?: false

            Button(
                    onClick = {
                        viewModel.fetchBreedImages(breedState.value)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = breedState.value.isNotBlank() // Enable the button when the text field is not blank
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            color = LocalContentColor.current
                    )
                } else {
                    Text(text = stringResource(id = R.string.show_images))
                }
            }

            if (isError) {
                Text(
                        text = stringResource(id = R.string.error_message) + viewModel.error.value,
                        color = Color.Red,
                        modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            if (!isLoading && breedImages.isNullOrEmpty() && !isError) {
                Text(text = stringResource(id = R.string.no_images_found))
            } else {
                LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        modifier = Modifier.fillMaxWidth()
                ) {
                    items(breedImages ?: emptyList()) { imageUrl ->
                        DogImageItem(imageUrl = imageUrl)
                    }
                }
            }
        }
    }
}

@Composable
fun DogImageItem(imageUrl: String) {
    val painter = rememberImagePainter1(
            data = imageUrl,
    )

    Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
    )
}

// Preview for the 3rd Screen:
//@Preview
//@Composable
//fun DogByBreedPreview() {
//    DogImagesByBreed(viewModel =  DogImagesByBreedViewModel(),navController = rememberNavController())
//}

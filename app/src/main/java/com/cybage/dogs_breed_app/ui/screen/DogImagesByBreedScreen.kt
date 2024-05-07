package com.cybage.dogs_breed_app.ui.screen

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DogImagesByBreed(viewModel: DogImagesByBreedViewModel = viewModel(),navController:NavController ) {
//    val breedState = remember { mutableStateOf("") }
//    val focusRequester = remember { FocusRequester() } // Remember the FocusRequester
//
//
//    Column ( modifier = Modifier
//        .fillMaxSize()){
//
//        NavigationBar(navController = navController , title = "Breedoze", showBackButton= true)
//
//        Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp) ,
//                horizontalAlignment = Alignment.CenterHorizontally ,
//                verticalArrangement = Arrangement.Center
//        )
//        {
//
//
//            TextField(
//                    value = breedState.value ,
//                    onValueChange = { breedState.value = it } ,
//                    label = { Text("Enter Dog Breed") } ,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .focusRequester(focusRequester) , // Request focus for the TextField
//                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done) , // Set keyboard action to Done
//                    keyboardActions = KeyboardActions(onDone = { focusRequester.freeFocus() }) // Release focus on Done
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Button(
//                    onClick = { viewModel.fetchBreedImages(breedState.value) } ,
//                    modifier = Modifier.fillMaxWidth()
//            ) {
//                Text(text = "Show Images")
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            val breedImages = viewModel.breedImages.value
//            if(! breedImages.isNullOrEmpty()) {
//                LazyVerticalGrid(
//                        columns = GridCells.Fixed(3) ,
//                        modifier = Modifier.fillMaxWidth()
//                ) {
//                    items(breedImages) { imageUrl ->
//                        DogImageItem(imageUrl = imageUrl)
//                    }
//                }
//            }
//        }
//    }
//
//}
//
//
//@OptIn(ExperimentalCoilApi::class)
//@Composable
//fun DogImageItem(imageUrl: String) {
//    // Load image using Coil and rememberImagePainter
//    val painter: Painter = rememberImagePainter(
//            data = imageUrl,
//    )
//
//    // Display the loaded image
//    Image(
//            painter = painter,
//            contentDescription = null, // Provide content description if needed
//            modifier = Modifier.size(100.dp) // Adjust size as needed
//    )
//}


//@Preview(showBackground = true)
//@Composable
//fun PreviewBreedImagesScreen() {
//    DogImagesByBreed()
//
//}



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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.cybage.dogs_breed_app.NavigationBar
import com.cybage.dogs_breed_app.viewmodel.DogImagesByBreedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogImagesByBreed(viewModel: DogImagesByBreedViewModel = viewModel(), navController: NavController) {
    val breedState = remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }

    Column(modifier = Modifier.fillMaxSize()) {
        NavigationBar(navController = navController, title = "Breedoze", showBackButton = true)

        Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
        ) {
            TextField(
                    value = breedState.value,
                    onValueChange = { breedState.value = it },
                    label = { Text("Enter Dog Breed") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { focusRequester.freeFocus() })
            )

            Spacer(modifier = Modifier.height(16.dp))

            val isLoading = viewModel.isLoading.value ?: false
            val breedImages = viewModel.breedImages.value
            val isError = viewModel.error.value?.isNotBlank()?:false

            Button(
                    onClick = {
                        viewModel.fetchBreedImages(breedState.value)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = isLoading !!
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            color = LocalContentColor.current
                    )
                } else {
                    Text(text = "Show Images")
                }
            }

            if (isError) {
                Text(
                        text = "Error: ${viewModel.error.value}",
                        color = Color.Red,
                        modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            if (!isLoading && breedImages.isNullOrEmpty() && !isError) {
                Text(text = "No images found.")
            }
            else {
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

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DogImageItem(imageUrl: String) {
    // Load image using Coil and rememberImagePainter
    val painter = rememberImagePainter(
            data = imageUrl,
    )

    // Display the loaded image
    Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
    )
}

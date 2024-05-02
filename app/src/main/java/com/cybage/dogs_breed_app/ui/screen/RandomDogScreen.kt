package com.cybage.dogs_breed_app.ui.screen

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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.cybage.dogs_breed_app.R
import com.cybage.dogs_breed_app.viewmodel.RandomDogViewModel


@OptIn(ExperimentalCoilApi::class)
@Composable
fun RandomDogScreen(viewModel: RandomDogViewModel = viewModel(RandomDogViewModel::class.java)) {
    val imageUrlState =
            viewModel.randomDogImageUrl.collectAsState() // Observe changes to the StateFlow

    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        val imageUrl = imageUrlState.value // Access the value from the collected state

        if (imageUrl != null) {
            Image(
                    painter = rememberImagePainter(data = imageUrl),
                    contentDescription = "Random Dog Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
            )
        } else {
            // If imageUrl is null, show a placeholder image or text
            Image(
                    painter = painterResource(id = R.drawable.lucy) , // Placeholder image
                    contentDescription = "Placeholder" ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
                    viewModelScope.launch {
                        viewModel.fetchRandomDogImage()
                    }
                }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Show Random")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRandomDogScreen() {
    RandomDogScreen()
}

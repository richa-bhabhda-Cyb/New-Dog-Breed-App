package com.cybage.dogs_breed_app.ui.screen//package com.cybage.dogs_breed_app.ui.screen

// RandomDogScreen.kt

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cybage.dogs_breed_app.viewmodel.RandomDogViewModel

@Composable
fun RandomDogScreen(viewModel: RandomDogViewModel = viewModel(RandomDogViewModel::class.java)) {
    val imageUrl = viewModel.randomDogImageUrl.value

    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        if (imageUrl != null) {
            Image(
                    painter = rememberGlidePainter(request = imageUrl),
                    contentDescription = "Random Dog Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
            )
        } else {
            Image(
                    painter = painterResource(id = R.drawable.placeholder_image),
                    contentDescription = "Placeholder",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
                onClick = { viewModel.fetchRandomDogImage() },
                modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Show Random")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewRandomDogScreen() {
//    DogBreedsTheme {
//        RandomDogScreen()
//    }
//}

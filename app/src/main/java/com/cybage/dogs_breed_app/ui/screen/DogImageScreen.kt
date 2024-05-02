package com.cybage.dogs_breed_app.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun DogImageScreen() {
    var breed by remember { mutableStateOf("") }
    var images by remember { mutableStateOf<List<String>>(emptyList()) }

    Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
    ) {
        OutlinedTextField(
                value = breed,
                onValueChange = { breed = it },
                label = { Text("Enter dog breed") },
                modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
                onClick = { fetchDogImages(breed) },
                modifier = Modifier.align(Alignment.End)
        ) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(images) { imageUrl ->
                Image(
                        painter = rememberImagePainter(imageUrl) ,
                        contentDescription = null ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(vertical = 8.dp)
                            .clip(shape = RoundedCornerShape(8.dp)) ,
                        contentScale = ContentScale.Crop
                )
            }
        }
    }
}

fun fetchDogImages(breed : String) {

}

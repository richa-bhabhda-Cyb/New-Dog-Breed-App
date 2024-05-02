package com.cybage.dogs_breed_app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cybage.dogs_breed_app.repository.DogRepository
import com.cybage.dogs_breed_app.ui.extensionfunctionforlivedata.collectAsState
import com.cybage.dogs_breed_app.viewmodel.DogViewModel


@Composable
fun DogListScreen(viewModel: DogViewModel) {

    val dogBreeds by viewModel.dogBreeds.collectAsState()

    LazyColumn {
        items(dogBreeds) { breed ->
            DogBreedItem(breed = breed)
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


@Preview
@Composable
fun DogListScreenPreview() {
    val viewModel = DogViewModel(DogRepository()) // Provide ViewModel instance
    DogListScreen(viewModel)
}

@Preview
@Composable
fun DogBreedItemPreview() {
    DogBreedItem(breed = "Golden Retriever")
}









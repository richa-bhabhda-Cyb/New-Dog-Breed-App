package com.cybage.dogs_breed_app.viewmodel

import androidx.lifecycle.ViewModel
import com.cybage.dogs_breed_app.repository.DogRepository
import kotlinx.coroutines.flow.MutableStateFlow

class RandomDogViewModel(private val repository: DogRepository) : ViewModel() {

    private val _randomDogImageUrl = MutableStateFlow<String?>(null)
    val randomDogImageUrl = _randomDogImageUrl

    suspend fun fetchRandomDogImage() {
        val imageUrl = repository.getRandomDogImage()
        _randomDogImageUrl.value = imageUrl
    }
}

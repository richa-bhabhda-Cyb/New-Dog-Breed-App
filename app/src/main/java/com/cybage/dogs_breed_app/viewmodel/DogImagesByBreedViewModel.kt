package com.cybage.dogs_breed_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cybage.dogs_breed_app.repository.DogRepository
import kotlinx.coroutines.launch


class DogImagesByBreedViewModel : ViewModel() {
    private val repository = DogRepository()

    private val _breedImages = MutableLiveData<List<String>>()
    val breedImages: LiveData<List<String>> = _breedImages

    fun fetchBreedImages(breed: String) {
        viewModelScope.launch {
            val images = repository.getDogImagesByBreed((breed))
            _breedImages.value = images
        }
    }
}

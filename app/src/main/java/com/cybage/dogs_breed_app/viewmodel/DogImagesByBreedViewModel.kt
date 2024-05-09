package com.cybage.dogs_breed_app.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cybage.dogs_breed_app.repository.DogRepository
import kotlinx.coroutines.launch

class DogImagesByBreedViewModel(context: Context) : ViewModel() {
    private val repository = DogRepository(context)

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _breedImages = MutableLiveData<List<String>>()
    val breedImages: LiveData<List<String>> = _breedImages

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchBreedImages(breed: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val images = repository.getDogImagesByBreed(breed)
                _breedImages.value = images
            } catch (e: Exception) {
                _error.value = e.message ?: "Unknown error"
            } finally {
                _isLoading.value = false
            }
        }
    }
}


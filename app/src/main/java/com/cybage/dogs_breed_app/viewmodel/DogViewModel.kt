package com.cybage.dogs_breed_app.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cybage.dogs_breed_app.repository.DogRepository
import kotlinx.coroutines.launch

class DogViewModel(private val repository: DogRepository) : ViewModel() {


    private val _dogBreeds = MutableLiveData<List<String>>()
    val dogBreeds: LiveData<List<String>> = _dogBreeds

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    // Function to fetch dog breeds
    private fun startFetchingDogBreeds() {
        viewModelScope.launch {
            try {
                val breeds = repository.getAllDogBreeds()
                _dogBreeds.value = breeds
            } catch (e: Exception) {
                val errorMessage = "Failed to fetch dog breeds: ${e.message}"
                Log.e("DogViewModel", errorMessage)
                _error.value = errorMessage
            }
        }
    }

    fun fetchedList(){
        startFetchingDogBreeds()
    }
}






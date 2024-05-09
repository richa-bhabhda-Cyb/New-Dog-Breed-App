package com.cybage.dogs_breed_app.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cybage.dogs_breed_app.R
import com.cybage.dogs_breed_app.repository.DogRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DogViewModel(
        private val repository: DogRepository,
        private val mainDispatcher: CoroutineDispatcher = Dispatchers.Main,
        private val context: Context
) : ViewModel() {

    private val _dogBreeds = MutableLiveData<List<String>>()
    val dogBreeds: LiveData<List<String>> = _dogBreeds

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    // This function is fetching dog breeds
    private fun startFetchingDogBreeds() {
        viewModelScope.launch(mainDispatcher) {
            try {
                val breeds = repository.getAllDogBreeds()
                _dogBreeds.postValue(breeds)
            } catch (e: Exception) {
                val errorMessage = context.getString(R.string.fetch_dog_breeds_error, e.message)
                Log.e("DogViewModel", errorMessage)
                _error.postValue(errorMessage)
            }
        }
    }

    fun fetchedList() {
        startFetchingDogBreeds()
    }
}

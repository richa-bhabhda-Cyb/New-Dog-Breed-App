//package com.cybage.dogs_breed_app.viewmodel
//
////class DogViewModel(private val repository: DogRepository) : ViewModel() {
////
////
////    // Default constructor
////    constructor() : this(DogRepository())
////    //1st Screen :
////
////    private val _dogBreeds = MutableLiveData<List<String>>()
////    val dogBreeds: LiveData<List<String>> = _dogBreeds
////
////    fun fetchDogBreeds() {
////        viewModelScope.launch {
////            val breeds = repository.getAllDogBreeds()
////            _dogBreeds.value = breeds
////        }
////    }}
////
////
////
////package com.cybage.dogs_breed_app.viewmodel
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.cybage.dogs_breed_app.repository.DogRepository
//import kotlinx.coroutines.launch
//
////import androidx.lifecycle.LiveData
////import androidx.lifecycle.MutableLiveData
////import androidx.lifecycle.ViewModel
////import androidx.lifecycle.viewModelScope
////import com.cybage.dogs_breed_app.repository.DogRepository
////import kotlinx.coroutines.launch
//
//class DogViewModel(private val repository: DogRepository) : ViewModel() {
//
//    private val _dogBreeds = MutableLiveData<List<String>>()
//    val dogBreeds: LiveData<List<String>> = _dogBreeds
//
//    private val _error = MutableLiveData<String>()
//    val error: LiveData<String> = _error
//
//    init {
//        fetchDogBreeds() // Automatically fetch dog breeds when ViewModel is created
//    }
//
//    private fun fetchDogBreeds() {
//        viewModelScope.launch {
//            try {
//                val breeds = repository.getAllDogBreeds()
//                _dogBreeds.value = breeds
//            } catch (e: Exception) {
//                val errorMessage = "Failed to fetch dog breeds: ${e.message}"
//                Log.e("DogViewModel", errorMessage)
//                _error.value = errorMessage
//            }
//        }
//    }
//}
//
//

//30-04-24

// DogViewModel.kt
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

    init {
        fetchDogBreeds() // Automatically fetch dog breeds when ViewModel is created
    }

    private fun fetchDogBreeds() {
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
}




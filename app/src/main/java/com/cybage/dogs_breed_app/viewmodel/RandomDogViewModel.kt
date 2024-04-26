package com.cybage.dogs_breed_app.viewmodel//package com.cybage.dogs_breed_app.viewmodel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//
//class RandomDogViewModel {
//
////SecondScreen:
//
//    private val _randomDogImageUrl = MutableLiveData<String>()
//    val randomDogImageUrl: LiveData<String> = _randomDogImageUrl
//
//    fun fetchRandomDogImage() {
//        viewModelScope.launch {
//            val imageUrl = repository.getRandomDogImage()
//            _randomDogImageUrl.value = imageUrl
//        }
//    }
//}

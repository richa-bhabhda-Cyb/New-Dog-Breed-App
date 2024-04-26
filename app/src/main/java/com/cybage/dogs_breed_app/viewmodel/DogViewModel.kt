package com.cybage.dogs_breed_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cybage.dogs_breed_app.repository.DogRepository
import kotlinx.coroutines.launch

class DogViewModel(private val repository: DogRepository) : ViewModel() {


    // Default constructor
    constructor() : this(DogRepository())
    //1st Screen :

    private val _dogBreeds = MutableLiveData<List<String>>()
    val dogBreeds: LiveData<List<String>> = _dogBreeds

    fun fetchDogBreeds() {
        viewModelScope.launch {
            val breeds = repository.getAllDogBreeds()
            _dogBreeds.value = breeds
        }
    }}


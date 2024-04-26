package com.cybage.dogs_breed_app.api.responses


data class DogBreedsResponse(
        val status: String,
        val message: Map<String, List<String>>
)


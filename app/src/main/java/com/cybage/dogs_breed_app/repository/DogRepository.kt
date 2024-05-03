package com.cybage.dogs_breed_app.repository

import com.cybage.dogs_breed_app.api.DogApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {

    private val dogApiService = DogApiService.create()


    //1st Screen:
    suspend fun getAllDogBreeds() : List<String> {
        return withContext(Dispatchers.IO) {
            val response = dogApiService.getAllDogBreeds()
            val breedMap = response.message // This is a map of breed groups to lists of breeds
            breedMap.values.flatten()
        }
    }

//    //2nd Screen


    suspend fun getRandomDogImage(): String {
        return dogApiService.getRandomDogImage().message
    }


    //3rd Screen:

    suspend fun getDogImagesByBreed(breed : String) : List<String> {
        return withContext(Dispatchers.IO) {
            // Call your API service method to fetch dog images by breed
            val response = dogApiService.getDogImagesByBreed(breed)
            // Check if the response status is successful
            if(response.status == "success") {
                // Return the list of image URLs from the response
                response.message
            } else {
                // Handle error case
                throw IllegalStateException("Failed to fetch dog images for breed: $breed")
            }
        }
    }
}






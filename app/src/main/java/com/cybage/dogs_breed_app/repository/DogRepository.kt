package com.cybage.dogs_breed_app.repository

import com.cybage.dogs_breed_app.api.DogApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {

    private val dogApiService = DogApiService.create()


    //1st Screen:
    suspend fun getAllDogBreeds(): List<String> {
        return withContext(Dispatchers.IO) {
            val response = dogApiService.getAllDogBreeds()
            val breedMap = response.message // This is a map of breed groups to lists of breeds
            breedMap.values.flatten()
        }
    }

//    //2nd Screen
//    suspend fun getRandomDogImage() {
//        return withContext(Dispatchers.IO) {
//            dogApiService.getRandomDogImage().imageUrl
//        }
//    }

    //3rd Screen:

        suspend fun getDogImagesByBreed(breed: String): List<String> {
            return withContext(Dispatchers.IO) {
                try {
                    val response = dogApiService.getDogImagesByBreed(breed)
                    if (response.status == "success") {
                        response.message
                    } else {
                        throw Exception("Failed to fetch images for breed: $breed")
                    }
                } catch (e: Exception) {
                    throw Exception("Failed to fetch images for breed: $breed", e)
                }
            }
        }
    }




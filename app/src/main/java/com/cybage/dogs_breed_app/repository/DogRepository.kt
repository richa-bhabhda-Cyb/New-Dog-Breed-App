package com.cybage.dogs_breed_app.repository

import android.content.Context
import com.cybage.dogs_breed_app.R
import com.cybage.dogs_breed_app.api.DogApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository(private val context: Context) {

    private val dogApiService = DogApiService.create()

    // 1st Screen:
    suspend fun getAllDogBreeds(): List<String> {
        return withContext(Dispatchers.IO) {
            try {
                val response = dogApiService.getAllDogBreeds()
                val breedMap = response.message
                breedMap.values.flatten()
            } catch (e: Exception) {
                val errorMessage = context.getString(R.string.fetch_dog_breeds_error, e.message)
                throw Exception(errorMessage, e)
            }
        }
    }

    // 2nd Screen:
    suspend fun getRandomDogImage(): String {
        return dogApiService.getRandomDogImage().message
    }

    // 3rd Screen:
    suspend fun getDogImagesByBreed(breed: String): List<String> {
        return withContext(Dispatchers.IO) {
            try {

                val response = dogApiService.getDogImagesByBreed(breed)

                if (response.status == "success") {

                    response.message
                } else {

                    val errorMessage = context.getString(R.string.fetch_dog_images_error, breed)
                    throw IllegalStateException(errorMessage)
                }
            } catch (e: Exception) {
                val errorMessage = context.getString(R.string.fetch_dog_images_error, breed)
                throw Exception(errorMessage, e)
            }
        }
    }
}




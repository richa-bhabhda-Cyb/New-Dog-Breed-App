package com.cybage.dogs_breed_app.repository

import android.annotation.SuppressLint
import android.content.Context
import com.cybage.dogs_breed_app.R
import com.cybage.dogs_breed_app.api.DogApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class DogRepository(private val context: Context) {

    private val dogApiService = DogApiService.create()

    @SuppressLint("StringFormatMatches")
    suspend fun getAllDogBreeds(): List<String> {
        return withContext(Dispatchers.IO) {
            try {
                val response = dogApiService.getAllDogBreeds()
                if (response.isSuccessful) {
                    response.body()?.message?.values?.flatten() ?: emptyList()
                } else {
                    val errorMessage = context.getString(R.string.fetch_dog_breeds_error, response.code())
                    throw IOException(errorMessage) // Change Exception to IOException
                }
            } catch (e: IOException) {
                throw e
            } catch (e: Exception) {
                val errorMessage = context.getString(R.string.fetch_dog_breeds_error, e.message)
                throw IOException(errorMessage, e)
            }
        }
    }

    @SuppressLint("StringFormatMatches")
    suspend fun getRandomDogImage(): String {
        return withContext(Dispatchers.IO) {
            try {
                val response = dogApiService.getRandomDogImage()
                if (response.isSuccessful) {
                    response.body()?.message ?: throw IOException("Invalid response") // Change Exception to IOException
                } else {
                    val errorMessage = context.getString(R.string.fetch_random_image_error, response.code())
                    throw IOException(errorMessage) // Change Exception to IOException
                }
            } catch (e: IOException) {
                throw e
            } catch (e: Exception) {
                val errorMessage = context.getString(R.string.fetch_random_image_error, e.message)
                throw IOException(errorMessage, e)
            }
        }
    }

    suspend fun getDogImagesByBreed(breed: String): List<String> {
        return withContext(Dispatchers.IO) {
            try {
                val response = dogApiService.getDogImagesByBreed(breed)
                if (response.isSuccessful && response.body()?.status == "success") {
                    response.body()?.message ?: emptyList()
                } else {
                    val errorMessage = context.getString(R.string.fetch_dog_images_error, breed)
                    throw IOException(errorMessage) // Change Exception to IOException
                }
            } catch (e: IOException) {
                throw e
            } catch (e: Exception) {
                val errorMessage = context.getString(R.string.fetch_dog_images_error, breed)
                throw IOException(errorMessage, e)
            }
        }
    }

}

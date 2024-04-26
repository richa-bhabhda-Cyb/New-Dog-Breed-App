package com.cybage.dogs_breed_app.api

import com.cybage.dogs_breed_app.api.responses.DogBreedsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DogApiService {




    companion object {
        private const val BASE_URL = "https://dog.ceo/api/"

        fun create(): DogApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DogApiService::class.java)
        }
    }

    @GET("breeds/list/all")

    suspend fun getAllDogBreeds() : DogBreedsResponse

//    //2nd Screen:
//    @GET("breeds/image/random")
//    suspend fun getRandomDogImage(): RandomDogResponse

}
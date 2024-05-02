package com.cybage.dogs_breed_app.api

import com.cybage.dogs_breed_app.api.responses.DogBreedsResponse
import com.cybage.dogs_breed_app.api.responses.DogImagesByBreedResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

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


//@GET("v2/breeds")
 @GET("breeds/list/all")
    suspend fun getAllDogBreeds() : DogBreedsResponse

    //2nd Screen:
//    @GET("breeds/image/random")
//
//    suspend fun getRandomDogImage(): RandomDogImageResponse

    //3rd Screen
    @GET("breed/{breed}/images")
    suspend fun getDogImagesByBreed(@Path("breed") breed: String): DogImagesByBreedResponse



}
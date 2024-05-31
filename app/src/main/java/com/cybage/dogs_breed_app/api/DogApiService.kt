package com.cybage.dogs_breed_app.api

import com.cybage.dogs_breed_app.api.responses.DogBreedsResponse
import com.cybage.dogs_breed_app.api.responses.DogImagesByBreedResponse
import com.cybage.dogs_breed_app.api.responses.RandomDogImageResponse
import retrofit2.Response
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


//1st Screen
 @GET("breeds/list/all")
    suspend fun getAllDogBreeds() : Response <DogBreedsResponse>

    //2nd Screen:
    @GET("breeds/image/random")

    suspend fun getRandomDogImage(): Response <RandomDogImageResponse>

    //3rd Screen
    @GET("breed/{hound}/images")
    suspend fun getDogImagesByBreed(@Path("hound") breed: String): Response< DogImagesByBreedResponse>



}
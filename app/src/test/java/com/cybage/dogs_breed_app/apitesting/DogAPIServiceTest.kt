package com.cybage.dogs_breed_app.apitesting

import com.cybage.dogs_breed_app.api.DogApiService
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.testng.Assert
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogAPIServiceTest {

lateinit var  dogApiService: DogApiService
    lateinit var  mockWebServer : MockWebServer


    @Before
    fun setup(){
        mockWebServer=MockWebServer()
      dogApiService= Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(dogApiService::class.java)

    }

    fun testGetListOfBreeds()= runTest{
        val mockResponse=MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)

        val response = dogApiService.getAllDogBreeds()
        mockWebServer.takeRequest()

        Assert.assertEquals(true, response.message.isEmpty())
    }

    @After
    fun tearDown(){
mockWebServer.shutdown()
    }
}
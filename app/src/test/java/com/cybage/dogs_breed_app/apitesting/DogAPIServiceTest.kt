package com.cybage.dogs_breed_app.apitesting

import com.cybage.dogs_breed_app.api.DogApiService
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogAPIServiceTest {

    private lateinit var dogApiService: DogApiService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        dogApiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApiService::class.java)
    }

    @Test
    fun testGetListOfBreeds() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setBody("""{"message": {"hound": []}, "status": "success"}""")
        mockWebServer.enqueue(mockResponse)

        val response = dogApiService.getAllDogBreeds()
        mockWebServer.takeRequest()

        Assert.assertTrue(response.isSuccessful)
        Assert.assertTrue(response.body()?.message?.isNotEmpty() ?: false)
    }

    @Test
    fun testGetRandomImage() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setBody("""{"message": "https://random.dog/image.jpg", "status": "success"}""")
        mockWebServer.enqueue(mockResponse)

        val response = dogApiService.getRandomDogImage()
        mockWebServer.takeRequest()

        Assert.assertTrue(response.isSuccessful)
        Assert.assertEquals("success", response.body()?.status)
        Assert.assertTrue(response.body()?.message?.isNotEmpty() ?: false)
        Assert.assertTrue(response.body()?.message?.startsWith("https://") ?: false)
    }

    @Test
    fun testGetImageByBreed() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setBody("""{"message": [], "status": "success"}""")
        mockWebServer.enqueue(mockResponse)

        val response = dogApiService.getDogImagesByBreed("hound")
        mockWebServer.takeRequest()

        Assert.assertTrue(response.isSuccessful)
        Assert.assertTrue(response.body()?.message?.isEmpty() ?: false)
    }

    @Test
    fun testGetListOfBreeds_returnError() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(404)
        mockResponse.setBody("Something went Wrong")
        mockWebServer.enqueue(mockResponse)

        val response = dogApiService.getAllDogBreeds()
        mockWebServer.takeRequest()

        Assert.assertFalse(response.isSuccessful)
        Assert.assertNull(response.body())
    }

    @Test
    fun testGetRandomImage_returnError() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(404)
        mockResponse.setBody("Something went Wrong")
        mockWebServer.enqueue(mockResponse)

        val response = dogApiService.getRandomDogImage()
        mockWebServer.takeRequest()

        Assert.assertFalse(response.isSuccessful)
        Assert.assertNull(response.body())
    }

    @Test
    fun testGetImageByBreed_returnError() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(404)
        mockResponse.setBody("Something went Wrong")
        mockWebServer.enqueue(mockResponse)

        val response = dogApiService.getDogImagesByBreed("hound")
        mockWebServer.takeRequest()

        Assert.assertFalse(response.isSuccessful)
        Assert.assertNull(response.body())
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}

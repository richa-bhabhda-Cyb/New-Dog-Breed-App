package com.cybage.dogs_breed_app.repositorytesting

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cybage.dogs_breed_app.R
import com.cybage.dogs_breed_app.api.DogApiService
import com.cybage.dogs_breed_app.repository.DogRepository
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class ErrorCodesTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var mockWebServer: MockWebServer
    private lateinit var dogApiService: DogApiService
    private lateinit var repository: DogRepository
    private lateinit var context: Context

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        dogApiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApiService::class.java)

        context = Mockito.mock(Context::class.java)
        Mockito.`when`(context.getString(R.string.fetch_dog_breeds_error, 400))
            .thenReturn("Bad Request")
        Mockito.`when`(context.getString(R.string.fetch_dog_breeds_error, 401))
            .thenReturn("Unauthorized")
        Mockito.`when`(context.getString(R.string.fetch_dog_breeds_error, 404))
            .thenReturn("Not Found")
        Mockito.`when`(context.getString(R.string.fetch_dog_breeds_error, 500))
            .thenReturn("Internal Server Error")

        repository = DogRepository(context)
    }

    @Test
    fun testgetAllDogBreedsreturns400error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))

        try {
            repository.getAllDogBreeds()
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Bad Request")
        }
    }

    @Test
    fun testgetAllDogBreedsreturns401error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(401))

        try {
            repository.getAllDogBreeds()
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Unauthorized")
        }
    }

    @Test
    fun testgetAllDogBreedsreturns404error()= runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(404))

        try {
            repository.getAllDogBreeds()
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Not Found")
        }
    }

    @Test
    fun testgetAllDogBreedsreturns500error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(500))

        try {
            repository.getAllDogBreeds()
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Internal Server Error")
        }
    }

    @Test
    fun testgetRandomDogImagereturns400error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))

        try {
            repository.getRandomDogImage()
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Bad Request")
        }
    }

    @Test
    fun testgetRandomDogImagereturns401error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(401))

        try {
            repository.getRandomDogImage()
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Unauthorized")
        }
    }

    @Test
    fun testgetRandomDogImagereturns404error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(404))

        try {
            repository.getRandomDogImage()
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Not Found")
        }
    }

    @Test
    fun testgetRandomDogImagereturns500error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(500))

        try {
            repository.getRandomDogImage()
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Internal Server Error")
        }
    }

    @Test
    fun testgetDogImagesByBreedreturns400error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))

        try {
            repository.getDogImagesByBreed("hound")
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Bad Request")
        }
    }

    @Test
    fun testgetDogImagesByBreedreturns401error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(401))

        try {
            repository.getDogImagesByBreed("hound")
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Unauthorized")
        }
    }

    @Test
    fun testgetDogImagesByBreedreturns404error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(404))

        try {
            repository.getDogImagesByBreed("hound")
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Not Found")
        }
    }

    @Test
    fun testgetDogImagesByBreedreturns500error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(500))

        try {
            repository.getDogImagesByBreed("hound")
            assert(false) { "Expected an Exception to be thrown" }
        } catch (e: IOException) {
            assert(e.message == "Internal Server Error")
        }
    }

@After
fun tearDown() {
    mockWebServer.shutdown()
}
}
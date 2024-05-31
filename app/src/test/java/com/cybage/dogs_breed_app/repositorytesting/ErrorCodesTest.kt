package com.cybage.dogs_breed_app.repositorytesting

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
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
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30], manifest = Config.NONE) // Add manifest = Config.NONE
class ErrorCodesTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var mockWebServer: MockWebServer
    private lateinit var dogApiService: DogApiService
    private lateinit var repository: DogRepository
    private lateinit var context: Context

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

        mockWebServer = MockWebServer()
        mockWebServer.start()
        dogApiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogApiService::class.java)

        context = ApplicationProvider.getApplicationContext()

        // Mock context resources
        val mockContext = Mockito.mock(Context::class.java)
        Mockito.`when`(mockContext.getString(R.string.fetch_dog_breeds_error, 400)).thenReturn("Error fetching dog breeds: 400")
        Mockito.`when`(mockContext.getString(R.string.fetch_dog_breeds_error, 401)).thenReturn("Error fetching dog breeds: 401")
        Mockito.`when`(mockContext.getString(R.string.fetch_dog_breeds_error, 404)).thenReturn("Error fetching dog breeds: 404")
        Mockito.`when`(mockContext.getString(R.string.fetch_dog_breeds_error, 500)).thenReturn("Error fetching dog breeds: 500")
        Mockito.`when`(mockContext.getString(R.string.fetch_random_image_error, 400)).thenReturn("Error fetching random dog image: 400")
        Mockito.`when`(mockContext.getString(R.string.fetch_random_image_error, 401)).thenReturn("Error fetching random dog image: 401")
        Mockito.`when`(mockContext.getString(R.string.fetch_random_image_error, 404)).thenReturn("Error fetching random dog image: 404")
        Mockito.`when`(mockContext.getString(R.string.fetch_random_image_error, 500)).thenReturn("Error fetching random dog image: 500")
        Mockito.`when`(mockContext.getString(R.string.fetch_dog_images_error, "hound")).thenReturn("Error fetching images for breed: hound")

        repository = DogRepository(mockContext)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testGetAllDogBreedsReturns400Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))

        val exception = runCatching { repository.getAllDogBreeds() }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching dog breeds: 400")
    }

    @Test
    fun testGetAllDogBreedsReturns401Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(401))

        val exception = runCatching { repository.getAllDogBreeds() }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching dog breeds: 401")
    }

    @Test
    fun testGetAllDogBreedsReturns404Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(404))

        val exception = runCatching { repository.getAllDogBreeds() }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching dog breeds: 404")
    }

    @Test
    fun testGetAllDogBreedsReturns500Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(500))

        val exception = runCatching { repository.getAllDogBreeds() }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching dog breeds: 500")
    }

    @Test
    fun testGetRandomDogImageReturns400Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))

        val exception = runCatching { repository.getRandomDogImage() }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching random dog image: 400")
    }

    @Test
    fun testGetRandomDogImageReturns401Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(401))

        val exception = runCatching { repository.getRandomDogImage() }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching random dog image: 401")
    }

    @Test
    fun testGetRandomDogImageReturns404Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(404))

        val exception = runCatching { repository.getRandomDogImage() }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching random dog image: 404")
    }

    @Test
    fun testGetRandomDogImageReturns500Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(500))

        val exception = runCatching { repository.getRandomDogImage() }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching random dog image: 500")
    }

    @Test
    fun testGetDogImagesByBreedReturns400Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))

        val exception = runCatching { repository.getDogImagesByBreed("hound") }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching images for breed: hound")
    }

    @Test
    fun testGetDogImagesByBreedReturns401Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(401))

        val exception = runCatching { repository.getDogImagesByBreed("hound") }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching images for breed: Unauthorized")
    }

    @Test
    fun testGetDogImagesByBreedReturns404Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(404))

        val exception = runCatching { repository.getDogImagesByBreed("hound") }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching images for breed: Not Found")
    }

    @Test
    fun testGetDogImagesByBreedReturns500Error() = runTest {
        mockWebServer.enqueue(MockResponse().setResponseCode(500))

        val exception = runCatching { repository.getDogImagesByBreed("hound") }.exceptionOrNull()
        println("Error message: ${exception?.message}") // Log the error message
        assert(exception is IOException && exception.message == "Error fetching images for breed: Internal Server Error")
    }
}

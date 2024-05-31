package com.cybage.dogs_breed_app.repositorytesting

import androidx.test.core.app.ApplicationProvider
import com.cybage.dogs_breed_app.api.DogApiService
import com.cybage.dogs_breed_app.api.responses.DogBreedsResponse
import com.cybage.dogs_breed_app.repository.DogRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import retrofit2.Response
import java.io.IOException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@ExperimentalCoroutinesApi
class ErrorCodeStatusTestFor1st {
    private lateinit var repository: DogRepository
    private lateinit var mockApiService: DogApiService
    private val testDispatcher: TestDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        mockApiService = mock(DogApiService::class.java)
        repository = DogRepository(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun testgetAllDogBreedsreturns500error() = runBlocking {
        val errorResponseBody = "".toResponseBody("application/json".toMediaTypeOrNull())
        val errorResponse = Response.error<DogBreedsResponse>(500, errorResponseBody)

        `when`(mockApiService.getAllDogBreeds()).thenReturn(errorResponse)

        val exception = assertFailsWith<IOException> {
            repository.getAllDogBreeds()
        }
        assertEquals(
                "Failed to fetch dog breeds: 500",
                exception.message
        )
    }
}

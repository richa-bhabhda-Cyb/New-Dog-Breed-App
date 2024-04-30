//package com.cybage.dogs_breed_app
//
//import com.cybage.dogs_breed_app.api.DogApiService
//import com.cybage.dogs_breed_app.repository.DogRepository
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.runBlockingTest
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.junit.MockitoJUnitRunner
//import org.mockito.Mockito.*
//
//
//@RunWith(MockitoJUnitRunner::class)
//@ExperimentalCoroutinesApi
//class DogRepositoryUnitTest {
//
//    @Mock
//    lateinit var apiService: DogApiService
//
//    private lateinit var repository: DogRepository
//
//    @Before
//    fun setup() {
//        repository = DogRepository(apiService)
//    }
//
//
//
//    @Test
//    fun `getAllDogBreeds should return list of breeds`() = runBlockingTest {
//        // Given
//        val breeds = listOf("Labrador", "Poodle", "German Shepherd")
//        whenever(apiService.getAllDogBreeds()).thenReturn(breeds)
//
//        // When
//        val result = repository.getAllDogBreeds()
//
//        // Then
//        assertEquals(breeds, result)
//    }
//
//
//    @Test
//    fun `getAllDogBreeds should handle API error`() = runBlockingTest {
//        // Given
//        val errorMessage = "Failed to fetch breeds"
//        whenever(apiService.getAllDogBreeds()).doThrow(RuntimeException(errorMessage))
//
//        // When
//        val result = repository.getAllDogBreeds()
//
//        // Then
//        assertEquals(emptyList<String>(), result)
//    }
//
//}

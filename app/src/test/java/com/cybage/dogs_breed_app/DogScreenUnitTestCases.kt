//package com.cybage.dogs_breed_app
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule

//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.flow.flowOf
//import kotlinx.coroutines.test.TestCoroutineDispatcher
//import kotlinx.coroutines.test.runBlockingTest
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.mockito.Mockito.`when`
//import org.mockito.Mockito.mock
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import kotlinx.coroutines.test.TestCoroutineDispatcher
//import kotlinx.coroutines.test.runBlockingTest
//
//
//
//@ExperimentalCoroutinesApi
//class DogViewModelTest {
//
//    // Set the main coroutine dispatcher for unit testing
//    private val testDispatcher = TestCoroutineDispatcher()
//
//    // This rule swaps the background executor used by the Architecture Components with a different one which executes each task synchronously
//    @get:Rule
//    val instantExecutorRule = InstantTaskExecutorRule()
//
//    private lateinit var dogViewModel: DogViewModel
//    private lateinit var mockRepository: DogRepository
//
//    @Before
//    fun setup() {
//        // Initialize DogViewModel and mock repository here
//        mockRepository = mock(DogRepository::class.java)
//        dogViewModel = DogViewModel(mockRepository, Dispatchers.Main, testDispatcher)
//    }
//
//    @Test
//    fun `test fetching dog breeds when internet is available`() : Unit = testDispatcher.runBlockingTest {
//        // Given
//        val mockDogBreeds = listOf("Labrador", "Poodle", "Bulldog")
//        `when`(mockRepository.getAllDogBreeds()).thenReturn(flowOf<List<String>>(mockDogBreeds))
//
//        // When
//        dogViewModel.fetchedList()
//
//        // Then
//        assertEquals(mockDogBreeds, dogViewModel.dogBreeds.value)
//    }
//
//    @Test
//    fun `test fetching dog breeds when internet is not available`() : Unit = testDispatcher.runBlockingTest {
//        // Given
//        `when`(mockRepository.getAllDogBreeds()).thenReturn(flowOf<List<String>>(mockDogBreeds))
//
//        // When
//        dogViewModel.fetchedList()
//
//        // Then
//        assertEquals(emptyList(), dogViewModel.dogBreeds.value)
//    }
//}

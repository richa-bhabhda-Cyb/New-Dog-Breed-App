//package com.cybage.dogs_breed_app
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.cybage.dogs_breed_app.repository.DogRepository
//import com.cybage.dogs_breed_app.viewmodel.DogViewModel
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.runBlockingTest
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito.doThrow
//import org.mockito.Mockito.verify
//import org.mockito.junit.MockitoJUnitRunner
//import org.mockito.kotlin.doThrow
//import org.mockito.kotlin.verify
//import org.mockito.kotlin.whenever
//
//@RunWith(MockitoJUnitRunner::class)
//@ExperimentalCoroutinesApi
//class DogViewModelUnitTest {
//
//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    @Mock
//    lateinit var repository: DogRepository
//
//    private lateinit var viewModel: DogViewModel
//
//    @Before
//    fun setup() {
//        viewModel = DogViewModel(repository)
//    }
//
//    @Test
//    fun `fetchDogBreeds should fetch breeds from repository`() = runBlockingTest {
//        // Given
//        val breeds = listOf("Labrador", "Poodle", "German Shepherd")
//        whenever(repository.getAllDogBreeds()).thenReturn(breeds)
//
//        // When
//        viewModel.fetchDogBreeds()
//
//        // Then
//        verify(repository).getAllDogBreeds()
//    }
//
//    @Test
//    fun `fetchDogBreeds should handle repository error`() = runBlockingTest {
//        // Given
//        val errorMessage = "Failed to fetch breeds"
//        doThrow(RuntimeException(errorMessage)).whenever(repository).getAllDogBreeds()
//
//        // When
//        viewModel.fetchDogBreeds()
//
//        // Then
//        val errorValue = viewModel.error.value
//        assert(errorValue == errorMessage)
//    }
//
//
//}

// DogImagesByBreedViewModel.kt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cybage.dogs_breed_app.repository.DogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DogImagesByBreedViewModel(private val repository: DogRepository) : ViewModel() {
    private val _dogImages = MutableStateFlow<List<String>>(emptyList())
    val dogImages: StateFlow<List<String>> = _dogImages

    fun fetchDogImages(breed: String) {
        viewModelScope.launch {
            try {
                val images = repository.getDogImagesByBreed(breed)
                _dogImages.value = images
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}

package com.cybage.dogs_breed_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cybage.dogs_breed_app.repository.DogRepository
import com.cybage.dogs_breed_app.ui.screen.DogImagesByBreed
import com.cybage.dogs_breed_app.ui.screen.DogListScreen
import com.cybage.dogs_breed_app.ui.screen.RandomDogScreen
import com.cybage.dogs_breed_app.viewmodel.DogImagesByBreedViewModel
import com.cybage.dogs_breed_app.viewmodel.DogViewModel
import com.cybage.dogs_breed_app.viewmodel.RandomDogViewModel


//30-04-24
@Composable
fun DogBreedsApp(navController: NavController) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                    text = "Who Let the Dogs Out?",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
            )
            CardItem("Dog Breed List", painterResource(R.drawable.may)) {
                navController.navigate("DogListScreen")
            }
            CardItem("Random Dog Image", painterResource(R.drawable.june)) {
                navController.navigate("RandomDogImageScreen")
            }
            CardItem("Dog Image By Breed", painterResource(R.drawable.july)) {
                navController.navigate("DogImageByBreedScreen")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                    text = "Who? Who? Who? Who?",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}


@Composable
fun CardItem(title: String , image: Painter , onClick: () -> Unit) {
    Card(
            modifier = Modifier
                .padding(8.dp)
                .clickable { onClick() } ,
            elevation = CardDefaults.cardElevation(8.dp) ,
            shape = RoundedCornerShape(8.dp)
    ) {
        Column(
                modifier = Modifier.padding(16.dp)
        ) {
            Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "DogBreedsApp") {
        composable("DogBreedsApp") {
            DogBreedsApp(navController)
        }
        composable("DogListScreen") {
            DogListScreen(DogViewModel(DogRepository()))
        }
        composable("RandomDogImageScreen") {
            RandomDogScreen(RandomDogViewModel(DogRepository()))
        }
        composable("DogImageByBreedScreen") {
            DogImagesByBreed(DogImagesByBreedViewModel())
        }
    }
}






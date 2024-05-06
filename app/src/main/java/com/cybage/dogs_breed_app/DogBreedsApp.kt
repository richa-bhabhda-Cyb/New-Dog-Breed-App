package com.cybage.dogs_breed_app

//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.cybage.dogs_breed_app.repository.DogRepository
//import com.cybage.dogs_breed_app.ui.screen.DogImagesByBreed
//import com.cybage.dogs_breed_app.ui.screen.DogListScreen
//import com.cybage.dogs_breed_app.ui.screen.RandomDogScreen
//import com.cybage.dogs_breed_app.viewmodel.DogImagesByBreedViewModel
//import com.cybage.dogs_breed_app.viewmodel.DogViewModel
//import com.cybage.dogs_breed_app.viewmodel.RandomDogViewModel
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DogBreedsApp(navController: NavController, title: String="Breedoze") {
//    Surface(
//            color = MaterialTheme.colorScheme.background,
//            modifier = Modifier.fillMaxSize()
//    ) {
//        Column(
//                modifier = Modifier.fillMaxSize()
//        ) {
//            // Navigation Bar
//            TopAppBar(
//                    title = { Text(text =title ) } ,
//                    colors = TopAppBarDefaults.topAppBarColors(Color.LightGray) ,
//                    navigationIcon = {
//                        IconButton(onClick = { navController.popBackStack() }) {
//                            Icon(
//                                    painter = painterResource(id = R.drawable.back arrow),
//                                    contentDescription = "Back"
//                            )
//                        }
//                    }
//            )
//
//            Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(horizontal = 16.dp)
//            ) {
//
//
//                Column(
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(
//                            text = "Who Let the Dogs Out?" ,
//                            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black, fontFamily = FontFamily.SansSerif, fontSize = 20.sp) ,
//                            modifier = Modifier.padding(bottom = 16.dp)
//                    )
//                    CardItem("Dog Breed List", painterResource(R.drawable.may)) {
//                        navController.navigate("DogListScreen")
//                    }
//                    CardItem("Random Dog Image", painterResource(R.drawable.june)) {
//                        navController.navigate("RandomDogImageScreen")
//                    }
//                    CardItem("Dog Image By Breed", painterResource(R.drawable.july)) {
//                        navController.navigate("DogImageByBreedScreen")
//                    }
//                }
//
//                Text(
//                        text = "Who? Who? Who? Who?" ,
//                        style = MaterialTheme.typography. bodyMedium.copy(color = Color.Black) ,
//                        modifier = Modifier
//                            .padding(bottom = 16.dp)
//                            .align(Alignment.BottomCenter)
//                )
//            }
//        }
//    }
//}
//
//
//@Composable
//fun CardItem(title: String , image: Painter , onClick: () -> Unit) {
//    Card(
//            modifier = Modifier
//                .padding(8.dp)
//                .clickable { onClick() } ,
//            elevation = CardDefaults.cardElevation(8.dp) ,
//            shape = RoundedCornerShape(8.dp)
//    ) {
//        Column(
//                modifier = Modifier.padding(16.dp)
//        ) {
//            Image(
//                    painter = image,
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(120.dp)
//                        .align(Alignment.CenterHorizontally)
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Text(
//                    text = title,
//                    style = MaterialTheme.typography.bodyMedium
//            )
//        }
//    }
//}
//@Composable
//fun MainNavigation() {
//    val navController = rememberNavController()
//    NavHost(navController, startDestination = "DogBreedsApp") {
//        composable("DogBreedsApp") {
//            DogBreedsApp(navController)
//        }
//        composable("DogListScreen") {
//            DogListScreen(DogViewModel(DogRepository()))
//        }
//        composable("RandomDogImageScreen") {
//            RandomDogScreen(RandomDogViewModel(DogRepository()))
//        }
//        composable("DogImageByBreedScreen") {
//            DogImagesByBreed(DogImagesByBreedViewModel())
//        }
//    }
//}
//
//
//@Preview
//@Composable
//fun DogBreedsAppPreview() {
//    DogBreedsApp(rememberNavController())
//}
//
//

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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


@Composable
fun DogBreedsApp(navController: NavController, title: String = "Breedoze",showBackButton : Boolean=false) {
    Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
    ) {
        Column(
                modifier = Modifier.fillMaxSize()
        ) {
            // Use the NavigationBar composable instead of TopAppBar
            NavigationBar(navController = navController, title = title,showBackButton= false)

            Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
            ) {
                Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                            text = "Who Let the Dogs Out?",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                    color = Color.Black,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 20.sp
                            ),
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
                }

                Text(
                        text = "Who? Who? Who? Who?",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .align(Alignment.BottomCenter)
                )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBar(navController: NavController, title: String, showBackButton: Boolean=false ) {
    TopAppBar(
            title = {
                Row(
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                            painter = painterResource(id = R.drawable.dogoimg),
                            contentDescription = "Logo",
                            modifier = Modifier.padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                            text = title,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 8.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(Color(0xFF8163B8)),
            actions = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                            painter = painterResource(id = R.drawable.arrawback),
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.size(22.dp) // Adjust the size here


                    )
                }
            }
    )
}




@Composable
fun CardItem(title: String, image: Painter, onClick: () -> Unit) {
    Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth() // Ensures the card takes up the full width
                .clickable { onClick() },
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp)
    ) {
        Column(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth() ,



        ) {
            Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()  // Image takes up full width of the card
                        .height(120.dp)  // Fixed height for the image
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()  // Text takes up full width of the card
            )
        }
    }
}





@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "DogBreedsApp") {
        composable("DogBreedsApp") {
            DogBreedsApp(navController, showBackButton=false)
        }
        composable("DogListScreen") {
            DogListScreen(DogViewModel(DogRepository()),navController)
        }
        composable("RandomDogImageScreen") {
            RandomDogScreen(RandomDogViewModel(DogRepository()),navController)
        }
        composable("DogImageByBreedScreen") {
            DogImagesByBreed(DogImagesByBreedViewModel(),navController)
        }
    }
}

@Preview
@Composable
fun DogBreedsAppPreview() {
    DogBreedsApp(rememberNavController(),showBackButton= false)
}

//package com.cybage.dogs_breed_app
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//
//@Composable
//fun Dashboard(navController: NavController) {
//    Surface(
//            color = MaterialTheme.colorScheme.surface,
//            modifier = Modifier.fillMaxSize()
//    ) {
//        Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            CardItem("Dog Breed List", painterResource(R.drawable.may)) {
//                navController.navigate("DogListScreen")
//            }
//            CardItem("Random Dog Image", painterResource(R.drawable.june)) {
//                navController.navigate("RandomDogImageScreen")
//            }
//            CardItem("Dog Image By Breed", painterResource(R.drawable.july)) {
//                navController.navigate("DogImageByBreedScreen")
//            }
//        }
//    }
//}
//
//@Composable
//fun CardItem(title: String, image: Painter, onClick: () -> Unit) {
//    Card(
//            modifier = Modifier
//                .padding(8.dp)
//                .clickable { onClick() },
//            elevation =CardDefaults.cardElevation(8.dp),
//            shape = RoundedCornerShape(8.dp)
//    ) {
//        Column(
//                modifier = Modifier.padding(16.dp)
//        ) {
//            Image(
//                    painter = image,
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(100.dp)
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
//
//@Preview
//@Composable
//fun PreviewDashboard() {
//    MaterialTheme {
//        Dashboard(navController = rememberNavController())
//    }
//}

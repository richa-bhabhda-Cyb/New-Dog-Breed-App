package com.cybage.dogs_breed_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.cybage.dogs_breed_app.navigation.NavigationBar

@Composable
fun DogBreedsApp(navController: NavController, title: String = stringResource(id = R.string.app_title), showBackButton: Boolean = false) {
    Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
    ) {
        Column(
                modifier = Modifier.fillMaxSize()
        ) {
            NavigationBar(navController = navController, title = title, showBackButton = showBackButton)

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
                            text = stringResource(id = R.string.who_let_the_dogs_out),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                    color = Color.Black,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 20.sp
                            ),
                            modifier = Modifier.padding(bottom = 16.dp)
                    )
                    CardItem(stringResource(id = R.string.dog_breed_list), painterResource(R.drawable.may)) {
                        navController.navigate("DogListScreen")
                    }
                    CardItem(stringResource(id = R.string.random_dog_image), painterResource(R.drawable.june)) {
                        navController.navigate("RandomDogImageScreen")
                    }
                    CardItem(stringResource(id = R.string.dog_image_by_breed), painterResource(R.drawable.july)) {
                        navController.navigate("DogImageByBreedScreen")
                    }
                }

                Text(
                        text = stringResource(id = R.string.who_who_who),
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .align(Alignment.BottomCenter)
                )
            }
        }
    }
}

@Composable
fun CardItem(title: String, image: Painter, onClick: () -> Unit) {
    Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable { onClick() },
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp)
    ) {
        Column(
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth(),
        ) {
            Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
            )
        }
    }
}








@Preview
@Composable
fun DogBreedsAppPreview() {
    DogBreedsApp(rememberNavController())
}

//@Preview
//@Composable
//fun MainNavigationPreview() {
//    MainNavigation(navController = rememberNavController())
//}



//package com.cybage.dogs_breed_app
//
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.navigation.compose.rememberNavController
//
//class MainActivity : ComponentActivity() {
//    @ExperimentalComposeUiApi
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val navController = rememberNavController()
//            var isInternetAvailable by remember { mutableStateOf(true) }
//
//            MainNavigation(navController = navController, isInternetAvailable = isInternetAvailable)
//        }
//    }
//}
package com.cybage.dogs_breed_app



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.cybage.dogs_breed_app.navigation.MainNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val context = LocalContext.current
            MainNavigation(navController, context)
        }
    }
}






package com.cybage.dogs_breed_app.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cybage.dogs_breed_app.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBar(navController: NavController, title: String, showBackButton: Boolean = false) {
    TopAppBar(
            title = {
                Row(
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                            painter = painterResource(id = R.drawable.dogoimg),
                            contentDescription = stringResource(id = R.string.logo_description),
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
            navigationIcon = {
                if (showBackButton) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                                painter = painterResource(id = R.drawable.arrawback),
                                contentDescription = stringResource(id = R.string.back_button_description),
                                tint = Color.White,
                                modifier = Modifier.size(22.dp)
                        )
                    }
                }
            }
    )
}

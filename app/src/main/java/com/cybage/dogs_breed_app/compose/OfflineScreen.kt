package com.cybage.dogs_breed_app.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cybage.dogs_breed_app.R


@Composable
fun OfflineScreen() {
    Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
    ) {
        Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                    text = stringResource(id = R.string.no_internet_connection),
                    style = MaterialTheme.typography.bodyLarge
            )
            Text(
                    text = stringResource(id = R.string.check_internet_connection),
                    style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
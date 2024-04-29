package com.cybage.dogs_breed_app.ui.extensionfunctionforlivedata

// LiveDataExtensions.kt

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData

fun LiveData<List<String>>.collectAsState(): State<List<String>> {
    val state = mutableStateOf<List<String>>(emptyList())
    observeForever { list ->
        state.value = list
    }
    return state
}

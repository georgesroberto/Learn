package com.georges.learn.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georges.learn.network.MarsApi
import kotlinx.coroutines.launch
import java.io.IOException

class MarsViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var marsUiState: String by mutableStateOf("")
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     */
    private fun getMarsPhotos() {
        viewModelScope.launch {
            try{
                val listResult = MarsApi.retrofitService.getPhotos()
                marsUiState = listResult
            } catch(e: IOException){
                /*TODO: IMPLEMENT */
            }
        }
    }
}
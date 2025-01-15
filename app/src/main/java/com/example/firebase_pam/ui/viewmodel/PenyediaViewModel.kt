package com.example.p12_.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.firebase_pam.MahasiswaApplication
import com.example.firebase_pam.ui.viewmodel.DetailViewModel
import com.example.firebase_pam.ui.viewmodel.HomeViewModel
import com.example.firebase_pam.ui.viewmodel.InsertViewModel



object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplication
            HomeViewModel(app.container.mahasiswaRepository)
        }
        initializer {
            val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplication
            InsertViewModel(app.container.mahasiswaRepository)
        }
        initializer {
            val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplication
            val savedStateHandle = createSavedStateHandle()
            DetailViewModel(
                savedStateHandle = savedStateHandle,
                repository = app.container.mahasiswaRepository
            )
        }
    }
}


package com.example.firebase_pam.di

import com.example.firebase_pam.repository.MahasiswaRepository
import com.example.firebase_pam.repository.NetworkMahasiswaRepository
import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer{
    val mahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer : AppContainer {
    private val firebase: FirebaseFirestore = FirebaseFirestore.getInstance() //sejajar dengan base URL

    override val mahasiswaRepository: MahasiswaRepository by lazy {
        NetworkMahasiswaRepository(firebase)
    }
}
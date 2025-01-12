package com.example.firebase_pam

import android.app.Application
import com.example.firebase_pam.di.MahasiswaContainer

class MahasiswaApplication: Application() {
    lateinit var container: MahasiswaContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}
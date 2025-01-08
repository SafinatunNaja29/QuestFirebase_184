package com.example.firebase_pam.repository

import com.example.firebase_pam.model.Mahasiswa
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class NetworkMahasiswaRepository (
    private val firestore: FirebaseFirestore
) : MahasiswaRepository {
    override suspend fun getAllMahasiswa(): Flow<List<Mahasiswa>> = callbackFlow {

        val mhsCollection = firestore.collection("Mahasiswa")
            .orderBy("nim", Query.Direction.DESCENDING)
            .addSnapshotListener{ value, error ->

                if (value != null){
                    val mhsList = value.documents.mapNotNull {
                        it.toObject(Mahasiswa::class.java)!!
                    }
                    trySend(mhsList)
                }
            }
        awaitClose{
            mhsCollection.remove()
        }
    }


    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {

    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {

    }

    override suspend fun deleteMahasiswa(nim: String) {

    }

    override suspend fun getMahasiswaByNim(nim: String): Flow<Mahasiswa> {
        TODO()
    }
}
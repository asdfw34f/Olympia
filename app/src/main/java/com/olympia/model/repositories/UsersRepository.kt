package com.olympia.model.repositories

import android.content.ContentValues.TAG
import android.provider.Settings
import android.util.Log
import com.google.firebase.firestore.AggregateSource
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.dataObjects
import com.olympia.model.entities.DUsers

class UsersRepository {
    private lateinit var database: FirebaseFirestore

    fun writeNewUser(
        userName: String,
        password: String,
        gender: String,
        dateOfBirth: String,
        email: String
    ): Int {
        var result = 2
        database = FirebaseFirestore.getInstance()

        val usersRef = database.collection("users").document()

        usersRef.delete()

        Log.w(TAG, "QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ")

        val user1 = hashMapOf(
            "first" to "Alan",
            "middle" to "Mathison",
            "last" to "Turing",
            "born" to 1912
        )

// Add a new document with a generated ID

        //    val user = DUsers(
        //        0,
        //        userName,
        //        password,
        //        gender,
        //        dateOfBirth,
        //        email
        //    )
        database.collection("users")
            .add(user1)
            .addOnSuccessListener {
                // Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                result = 1
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
                result = 2
            }

        return result

    }
}
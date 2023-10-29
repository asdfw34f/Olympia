package com.olympia.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DUsers(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val userName: String,
    val password: String,
    val gender: String,
    val dateOfBirth: String,
    val email: String)
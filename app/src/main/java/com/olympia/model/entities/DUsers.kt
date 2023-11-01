package com.olympia.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.util.getColumnIndex
import javax.annotation.processing.Generated

@Entity
data class DUsers(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userName: String,
    val password: String,
    val gender: String,
    val dateOfBirth: String,
    val email: String)
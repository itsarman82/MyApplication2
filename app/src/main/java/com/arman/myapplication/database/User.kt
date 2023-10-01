package com.arman.myapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val fullName: String,
    val phoneNumber: String,
    val password: String,
    @PrimaryKey val id: Int? = null
)
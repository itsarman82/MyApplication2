package com.arman.myapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * FROM USER WHERE phoneNumber = :phoneNumber AND password = :password")
    suspend fun validateUser(phoneNumber: String, password: String): List<User>
}
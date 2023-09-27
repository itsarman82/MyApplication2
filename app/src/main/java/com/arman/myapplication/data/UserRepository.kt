package com.arman.myapplication.data

import java.util.concurrent.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val dao: UserDao
) : UserDao {
    override suspend fun addUser(user: User) {
        return dao.addUser(user)
    }

    override suspend fun validateUser(phoneNumber: String, password: String): List<User> {
        return dao.validateUser(phoneNumber, password)
    }
}
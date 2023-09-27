package com.arman.myapplication.di

import android.content.Context
import androidx.room.Room
import com.arman.myapplication.Application.Application
import com.arman.myapplication.data.UserDao
import com.arman.myapplication.data.UserDatabase
import com.arman.myapplication.data.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "user_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(db: UserDatabase) : UserDao {
        return db.dao
    }
}




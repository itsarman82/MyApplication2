package com.arman.myapplication.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject


const val MERCHANT_DATASTORE ="merchant_datastore"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = MERCHANT_DATASTORE)

class DataStoreManager @Inject constructor(@ApplicationContext private val context: Context) {

    companion object {
        val ISLOGIN = booleanPreferencesKey("isLogin")
    }

    suspend fun saveLoginStatus(isLogin: Boolean) {
        context.dataStore.edit {
            it[ISLOGIN] = isLogin
        }
    }

    fun getLoginStatus() = context.dataStore.data.map {
        it[ISLOGIN] ?: false
    }

    suspend fun clearDataStore() = context.dataStore.edit {
        it.clear()
    }

}
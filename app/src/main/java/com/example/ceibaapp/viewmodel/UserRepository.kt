package com.example.ceibaapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.ceibaapp.api.ApiService
import com.example.ceibaapp.api.RetrofitClientService
import com.example.ceibaapp.database.UserDAO
import com.example.ceibaapp.database.UserDatabase
import com.example.ceibaapp.model.User
import retrofit2.Retrofit

class UserRepository(
    private val userDAO : UserDAO?
) {
    private val retrofitClientService: Retrofit? = RetrofitClientService.getInstance()
    private val apiService: ApiService? = retrofitClientService?.create(ApiService::class.java)
    companion object{
        var INSTANCE: UserRepository? = null
        fun getInstance(context: Context): UserRepository? {
            if(INSTANCE == null){
                synchronized(UserRepository::class){
                    if(INSTANCE == null){
                        var userDatabase: UserDatabase? = UserDatabase.getInstance(context)
                        INSTANCE = UserRepository(userDatabase?.userDao())
                    }
                }
            }
            return INSTANCE
        }
    }

    suspend fun insert(user: User) = userDAO?.insert(user)

    suspend fun getAllUsersFromDatabase() = userDAO?.getAllUsers()

    suspend fun getAllUsersFromService() = apiService?.getAllUsers()
}
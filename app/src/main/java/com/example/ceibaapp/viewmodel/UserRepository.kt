package com.example.ceibaapp.viewmodel

import android.content.Context
import com.example.ceibaapp.database.UserDAO
import com.example.ceibaapp.database.UserDatabase
import com.example.ceibaapp.model.User

class UserRepository(
    private var userDAO : UserDAO?
) {
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

}
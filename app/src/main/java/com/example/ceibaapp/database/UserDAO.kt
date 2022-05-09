package com.example.ceibaapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ceibaapp.model.User

@Dao
interface UserDAO {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users_table")
    suspend fun getAllUsers(): List<User>
}
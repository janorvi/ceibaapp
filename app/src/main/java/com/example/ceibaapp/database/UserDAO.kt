package com.example.ceibaapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ceibaapp.model.User

@Dao
interface UserDAO {

    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users_table")
    suspend fun getAllUsers(): List<User>
}
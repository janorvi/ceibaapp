package com.example.ceibaapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ceibaapp.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDAO

    companion object{

        var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase?{
            if(INSTANCE == null){
                synchronized(UserDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "myDBUsers")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}
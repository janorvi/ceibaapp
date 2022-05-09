package com.example.ceibaapp.viewmodel

import android.content.Context
import com.example.ceibaapp.api.ApiService
import com.example.ceibaapp.api.RetrofitClientService
import com.example.ceibaapp.database.UserDatabase
import retrofit2.Retrofit

class PostRepository {
    private val retrofitClientService: Retrofit? = RetrofitClientService.getInstance()
    private val apiService: ApiService? = retrofitClientService?.create(ApiService::class.java)
    companion object{
        var INSTANCE: PostRepository? = null
        fun getInstance(context: Context): PostRepository? {
            if(INSTANCE == null){
                synchronized(UserRepository::class){
                    if(INSTANCE == null){
                        var userDatabase: UserDatabase? = UserDatabase.getInstance(context)
                        INSTANCE = PostRepository()
                    }
                }
            }
            return INSTANCE
        }
    }

    suspend fun getAllPostsFromService() = apiService?.getAllPosts()

    suspend fun getAllPostsByUserIdFromService(userId: String?) = apiService?.getAllPostsByUserId(userId)
}
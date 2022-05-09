package com.example.ceibaapp.api

import com.example.ceibaapp.model.Post
import com.example.ceibaapp.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getAllUsers(): Response<List<User>>

    @GET("posts")
    suspend fun getAllPosts(): Response<List<Post>>

    @GET("posts")
    suspend fun getAllPostsByUserId(@Query("userId") userId: String?): Response<List<Post>>
}
package com.example.ceibaapp.api

import com.example.ceibaapp.model.UsersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getAllUsers(): Response<UsersResponse>
}
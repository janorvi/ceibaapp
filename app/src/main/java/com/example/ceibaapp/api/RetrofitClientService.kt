package com.example.ceibaapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientService {
    companion object{
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        var INSTANCE: RetrofitClientService? = null
        fun getInstance(): RetrofitClientService? {
            if(INSTANCE == null){
                synchronized(RetrofitClientService::class){
                    if(INSTANCE == null){
                        val retrofit = Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()

                        INSTANCE = retrofit.create(RetrofitClientService::class.java)
                    }
                }
            }
            return INSTANCE
        }
    }
}
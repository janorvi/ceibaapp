package com.example.ceibaapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientService {
    companion object{
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        var INSTANCE: Retrofit? = null
        fun getInstance(): Retrofit? {
            if(INSTANCE == null){
                synchronized(RetrofitClientService::class){
                    if(INSTANCE == null){
                        INSTANCE = Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
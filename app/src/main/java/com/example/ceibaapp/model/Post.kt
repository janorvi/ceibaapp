package com.example.ceibaapp.model

import com.google.gson.annotations.SerializedName

class Post(
    @SerializedName("userId") var userId:String,
    @SerializedName("id") var id:String,
    @SerializedName("title") var title:String,
    @SerializedName("body") var body:String, ){
}
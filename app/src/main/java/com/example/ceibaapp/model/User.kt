package com.example.ceibaapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users_table")
data class User(
    @PrimaryKey(autoGenerate = true) @SerializedName("id") var id:Int,
    @ColumnInfo(name = "name") @SerializedName("name") var name: String,
    @ColumnInfo(name = "userName") @SerializedName("username") var userName: String,
    @ColumnInfo(name = "email") @SerializedName("email") var email: String,
    @ColumnInfo(name = "phone") @SerializedName("phone") var phone: String,
    @ColumnInfo(name = "website") @SerializedName("website") var website: String){
}
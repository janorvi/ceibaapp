package com.example.ceibaapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class User(
@PrimaryKey(autoGenerate = true) var id:Int,
@ColumnInfo(name = "name") var name: String,
@ColumnInfo(name = "userName") var userName: String,
@ColumnInfo(name = "email") var email: String,
@ColumnInfo(name = "phone") var phone: String,
@ColumnInfo(name = "website") var website: String){
}
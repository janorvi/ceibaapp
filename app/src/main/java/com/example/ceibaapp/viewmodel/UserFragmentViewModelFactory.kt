package com.example.ceibaapp.viewmodel

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException
import java.lang.RuntimeException

class UserFragmentViewModelFactory(
var userRepository: UserRepository?
): ViewModelProvider.Factory {
    companion object{
        fun createFactory(activity: Activity): UserFragmentViewModelFactory {
            var context: Context? = null
            context = activity.applicationContext
            if(context == null){
                throw IllegalStateException("Not yet atached to application")
            }
            return UserFragmentViewModelFactory(
                UserRepository.getInstance(context)
            )
        }
    }
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        try{
            return modelClass.getConstructor(UserRepository::class.java).newInstance(userRepository)
        }catch (e: InstantiationException){
            throw RuntimeException("Cannot create an instance of $modelClass", e)
        }
    }
}
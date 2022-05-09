package com.example.ceibaapp.viewmodel

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException
import java.lang.RuntimeException

class PostFragmentViewModelFactory(
    var postRepository: PostRepository?
): ViewModelProvider.Factory {
    companion object{
        fun createFactory(activity: Activity): PostFragmentViewModelFactory {
            var context: Context? = null
            context = activity.applicationContext
            if(context == null){
                throw IllegalStateException("Not yet atached to application")
            }
            return PostFragmentViewModelFactory(
                PostRepository.getInstance(context)
            )
        }
    }
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        try{
            return modelClass.getConstructor(PostRepository::class.java).newInstance(postRepository)
        }catch (e: InstantiationException){
            throw RuntimeException("Cannot create an instance of $modelClass", e)
        }
    }
}
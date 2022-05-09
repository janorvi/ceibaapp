package com.example.ceibaapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ceibaapp.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostFragmentViewModel(
    var postRepository: PostRepository
): ViewModel() {
    val postList: MutableLiveData<List<Post>> = MutableLiveData()

    fun getAllPostsFromService(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = postRepository.getAllPostsFromService()
            if(response != null){
                postList?.postValue(response.body())
            }
        }
    }

    fun getAllPostsByUserIdFromService(userId: String?){
        CoroutineScope(Dispatchers.IO).launch {
            val response = postRepository.getAllPostsByUserIdFromService(userId)
            if(response != null){
                postList?.postValue(response.body())
            }
        }
    }
}
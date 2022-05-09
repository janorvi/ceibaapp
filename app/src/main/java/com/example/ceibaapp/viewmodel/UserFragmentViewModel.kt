package com.example.ceibaapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ceibaapp.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class UserFragmentViewModel(
    var userRepository: UserRepository
): ViewModel() {
    val userList: MutableLiveData<List<User>> = MutableLiveData()

    fun getAllUsersFromDatabase(){
        CoroutineScope(Dispatchers.IO).launch{
            userList?.postValue(userRepository.getAllUsersFromDatabase())
        }
    }

    fun getAllUsersFromService(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = userRepository.getAllUsersFromService()
            if(response != null){
                userList?.postValue(response.body())
            }
        }
    }

    fun insert(user: User){
        CoroutineScope(Dispatchers.IO).launch {
            var result = userRepository.insert(user)
        }
    }
}
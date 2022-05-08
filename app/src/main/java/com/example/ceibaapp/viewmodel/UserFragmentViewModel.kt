package com.example.ceibaapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ceibaapp.model.User

class UserFragmentViewModel(
    var userRepository: UserRepository
): ViewModel() {

    fun insert(user: User){

    }
}
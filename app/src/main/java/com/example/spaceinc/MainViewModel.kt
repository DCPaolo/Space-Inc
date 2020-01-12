package com.example.spaceinc


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.spaceinc.network.UserRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    private val repository: UserRepository = UserRepository()

    val getUserId = liveData(Dispatchers.IO) {
        val userId = repository.getUserById(5)
        emit(userId)
    }

    val getAllUsers = liveData(Dispatchers.IO) {
        val allUsers = repository.getAllUsers()
        emit(allUsers)
    }
}



package com.example.spaceinc.fragments.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.spaceinc.model.User
import com.example.spaceinc.network.UserRepository
import kotlinx.coroutines.Dispatchers

class ScoreViewModel : ViewModel() {
    private val userRepository: UserRepository = UserRepository()

    val getUserId = liveData(Dispatchers.IO) {
        val userId = userRepository.getUserById(5)
        emit(userId)
    }

    val getUserName = liveData(Dispatchers.IO) {
        val userName = userRepository.getUserByName("romain")
        emit(userName)
    }

    val getAllUsers = liveData(Dispatchers.IO) {
        val allUsers = userRepository.getAllUsers()
        emit(allUsers)
    }

    val getUsersScore = liveData(Dispatchers.IO) {
        val allUsers = userRepository.getAllUsers()
        var allUsersSorted = allUsers.sortedWith(compareByDescending({ it.score }))

        emit(allUsersSorted)
    }
}

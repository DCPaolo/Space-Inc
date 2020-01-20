package com.example.spaceinc.fragments.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.spaceinc.model.User
import com.example.spaceinc.network.RetrofitClient
import com.example.spaceinc.network.WebService
import kotlinx.coroutines.Dispatchers

class ScoreViewModel : ViewModel() {
    var client: WebService = RetrofitClient.webservice

    val getUserId = liveData(Dispatchers.IO) {
        val userId = client.getUserById(5)
        emit(userId)
    }

    val getUserName = liveData(Dispatchers.IO) {
        val userName = client.getUserByName("romain")
        emit(userName)
    }

    val getAllUsers = liveData(Dispatchers.IO) {
        val allUsers = client.getAllUsers()
        emit(allUsers)
    }

    val getUsersScore = liveData(Dispatchers.IO) {
        val allUsers = client.getAllUsers()
        var allUsersSorted = allUsers.sortedWith(compareByDescending<User> { it.score }
            .thenBy{ it.id })

        emit(allUsersSorted)
    }
}

package com.example.spaceinc.fragments.fail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.spaceinc.model.User
import com.example.spaceinc.network.RetrofitClient
import com.example.spaceinc.network.WebService
import kotlinx.coroutines.Dispatchers

class FailViewModel : ViewModel() {

    var client: WebService = RetrofitClient.webservice

    val getUsersScore = liveData(Dispatchers.IO) {
        val allUsers = client.getAllUsers()
        var allUsersSorted = allUsers.sortedWith(compareByDescending<User> { it.score }
            .thenBy{ it.id })

        emit(allUsersSorted)
    }
}
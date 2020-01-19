package com.example.spaceinc.network

import com.example.spaceinc.model.UserPost

class UserRepository {

    var client: WebService = RetrofitClient.webservice

    suspend fun getUserById(id: Int) = client.getUserById(id)
    suspend fun getUserByName(name: String) = client.getUserByName(name)
    suspend fun getAllUsers() = client.getAllUsers()
    fun createUser(username: UserPost) = client.createUser(username)

}

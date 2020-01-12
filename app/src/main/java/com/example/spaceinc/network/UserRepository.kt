package com.example.spaceinc.network

class UserRepository {

    var client: WebService = RetrofitClient.webservice

    suspend fun getUserById(id: Int) = client.getUserById(id)
    suspend fun getAllUsers() = client.getAllUsers()

}

package com.example.spaceinc.network

import com.example.spaceinc.model.User
import com.example.spaceinc.model.UserPost
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface WebService {
    @GET("/api/user/{id}")
    suspend fun getUserById(@Path(value = "id") userId: Int): User

    @GET("/api/users")
    suspend fun getAllUsers(): List<User>

    @GET("/api/user/find/{name}")
    suspend fun getUserByName(@Path(value = "name") userName: String): User

    @POST("/api/user/register")
    fun createUser(@Body user: UserPost?): Call<User?>?
}



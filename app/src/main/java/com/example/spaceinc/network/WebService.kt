package com.example.spaceinc.network

import com.example.spaceinc.model.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("/api/user/{id}")
    suspend fun getUserById(@Path(value = "id") userId: Int): User

    @GET("/api/users")
    suspend fun getAllUsers(): List<User>

    @GET("/api/user/find/{name}")
    suspend fun getUserByName(@Path(value = "name") userName: String): User

}



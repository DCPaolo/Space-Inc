package com.example.spaceinc.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Room(
    val name: String?,
    val state: String?,
    val initialNumberOfUser: Int?,
    // val userList: List<User>?,
    val levelList: Any?,
    val currentLevel: Int?,
    val score: Int?
)

data class RoomList (
    private val all: List<Room>? = null
)
package com.example.spaceinc.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

enum class State(val value: Int) {
    WAITING(0), READY(1), IN_GAME(2), OVER(3)
}

@JsonClass(generateAdapter = true)
data class User(
    val id: Int,
    val name: String,
    val avatar: String,
    var score: Int,
    var state: State = State.OVER
)

@JsonClass(generateAdapter = true)
data class UserPost(
    val name: String
)

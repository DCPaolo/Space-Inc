package com.example.spaceinc.model

import com.squareup.moshi.Json

enum class State(val value: Int) {
    WAITING(0), READY(1), IN_GAME(2), OVER(3)
}

data class User(
    val id: Int,
    @Json(name = "name") val name: String,
    val avatar: String,
    var score: Int,
    var state: State = State.OVER
)

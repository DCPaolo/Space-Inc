package com.example.spaceinc.model

data class Action(
    val sentence: String,
    val uiElement: UIElement,
    val time: Long = 8000
)

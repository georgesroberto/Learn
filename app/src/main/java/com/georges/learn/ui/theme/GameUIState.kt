package com.georges.learn.ui.theme

data class GameUIState(
    val currentScrambledWord: String = "",
    val isGuessedWordWrong: Boolean = false,
    val score: Int = 0
)

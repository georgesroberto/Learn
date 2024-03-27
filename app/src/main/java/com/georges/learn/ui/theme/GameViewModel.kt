package com.georges.learn.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.georges.learn.data.SCORE_INCREASE
import com.georges.learn.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUIState())
    val uiState: StateFlow<GameUIState> = _uiState.asStateFlow()

    private lateinit var currentWord: String

    private fun pickRandomAndShuffle(): String {
        currentWord = allWords.random()

        return if (usedWord.contains(currentWord)){
            pickRandomAndShuffle()
        }else{
            usedWord.add(currentWord)
            shuffleCurrentWord(currentWord)
        }
    }

    private var usedWord: MutableSet<String> = mutableSetOf()
    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()

        //Scramble the word
        tempWord.shuffle()
        while (String(tempWord).equals(word)){
            tempWord.shuffle()
        }

        return String(tempWord)
    }

    var userGuess by mutableStateOf("")
        private set
    fun updateUserGuess(guessedWord: String){
        userGuess = guessedWord
    }
    fun checkUserGuess(){
        if (userGuess.equals(currentWord, ignoreCase = true)){
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updatedGameState(updatedScore)
        } else {
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
    }

    fun updatedGameState(updatedScore: Int).
    {
        _uiState.update { cuurentState ->
            cuurentState.copy(
                isGuessedWordWrong = false,
                currentScrambledWord = pickRandomAndShuffle(),
                score = updatedScore
            )
        }
    }

    fun resetGame(){
        usedWord.clear()
        _uiState.value = GameUIState(currentScrambledWord = pickRandomAndShuffle())
    }

    init {
        resetGame()
    }
}
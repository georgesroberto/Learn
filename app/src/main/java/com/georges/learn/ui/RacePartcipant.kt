package com.georges.learn.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay

/**
 * This class represents a state holder for race participant.
 */
class RaceParticipant(
    val name: String,
    val maxProgress: Int = 100,
    private val progressDelayMillis: Long = 500L,
    private val progressIncrement: Int = 1,
    private val initialProgress: Int = 1
) {
    init {
        require(maxProgress > 0) { "maxProgress=$maxProgress; must be > 0" }
        require(progressIncrement > 0) { "progressIncrement=$progressIncrement; must be > 0" }
    }

    /**
     * Indicates the race participant's current progress
     */
    var currentProgress by mutableStateOf(initialProgress)
        private set

    /**
     * Regardless of the value of [initialProgress] the reset function will reset the
     * [currentProgress] to 0
     */

    suspend fun run(){
        try {
            while (currentProgress < maxProgress){
                delay(progressDelayMillis)
                currentProgress += initialProgress
            }
        } catch (e: CancellationException){
            Log.e("RaceParticipant", "$name: ${e.message}")
            throw e // Always re-throw CancellationException.
        }
    }

    fun reset() {
        currentProgress = 0
    }
}

/**
 * The Linear progress indicator expects progress value in the range of 0-1. This property
 * calculate the progress factor to satisfy the indicator requirements.
 */
val RaceParticipant.progressFactor: Float
    get() = currentProgress / maxProgress.toFloat()

package com.georges.learn

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.georges.learn.ui.theme.LearnTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipAppUITest {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            LearnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    TipTimeApp()
                }
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found."
        )
    }
}
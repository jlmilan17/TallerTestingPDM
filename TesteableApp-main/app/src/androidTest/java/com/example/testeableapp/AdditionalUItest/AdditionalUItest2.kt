package com.example.testeableapp.AdditionalUItest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test

class AdditionalUItest2 {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun checkMinimumPeople() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule
            .onNodeWithTag("ReducirPersonas")
            .performClick()

        composeTestRule
            .onNodeWithText("Número de personas: 1")
            .assertIsDisplayed()
    }
}
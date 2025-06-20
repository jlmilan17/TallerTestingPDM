package com.example.testeableapp.additionalUiTests

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AdditionalUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun zeroTipOnTextInput() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule
            .onNodeWithTag("BillAmount")
            .performTextInput("texto")

        composeTestRule
            .onNodeWithText("Propina: $0.00")
            .assertIsDisplayed()
    }
}

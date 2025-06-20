package com.example.testeableapp.uiTest

import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TipCalculatorUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun roundUpAffectsTip() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }
        composeTestRule
            .onNodeWithTag("BillAmount")
            .performTextInput("10")
        composeTestRule
            .onNodeWithText("Propina: $1.50")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag("RoundUpCheckbox")
            .performClick()
        composeTestRule
            .onNodeWithText("Propina: $2.00")
            .assertIsDisplayed()
    }
    @Test
    fun sliderUpdatesTip() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }
        composeTestRule
            .onNodeWithTag("BillAmount")
            .performTextInput("100")

        composeTestRule
            .onNodeWithText("Porcentaje de propina: 15%")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag("TipSlider")
            .performSemanticsAction(SemanticsActions.SetProgress) { setProgress: (progress: Float) -> Boolean ->
                setProgress(50f)
            }
        composeTestRule
            .onNodeWithText("Porcentaje de propina: 50%")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Propina: $50.00")
            .assertIsDisplayed()
    }
    @Test
    fun uiElementsAreDisplayed() {
        composeTestRule.setContent { TipCalculatorScreen() }
        composeTestRule.onNodeWithText("Calculadora de Propinas").assertIsDisplayed()
        composeTestRule.onNodeWithTag("BillAmount").assertIsDisplayed()
        composeTestRule.onNodeWithText("Porcentaje de propina:", substring = true).assertIsDisplayed()
        composeTestRule.onNodeWithText("Número de personas:", substring = true).assertIsDisplayed()
        composeTestRule.onNodeWithTag("TipSlider").assertIsDisplayed()
    }
}
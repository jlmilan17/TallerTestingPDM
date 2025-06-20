package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test

class TipCalculatorTest {

    @Test
    fun tipIsZeroWhenAmountIsZero() {
        val result = calculateTip(amount = 0.0, tipPercent = 20, roundUp = true)
        assertEquals(0.0, result, 0.001)
    }

    @Test
    fun calculateTipWithDecimalAmount() {
        val result = calculateTip(amount = 83.25, tipPercent = 18, roundUp = false)
        assertEquals(14.985, result, 0.001)
    }
}
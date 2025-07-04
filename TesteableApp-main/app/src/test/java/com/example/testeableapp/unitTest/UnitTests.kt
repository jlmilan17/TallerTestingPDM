package com.example.testeableapp.unitTest

import org.junit.Test
import org.junit.Assert.assertEquals
import com.example.testeableapp.ui.Screens.calculateTip


class TipCalculatorTest {
    @Test
    fun tipFor20PercentNoRoundUp() {
        val result = calculateTip(100.0, 20, false)
        assertEquals(20.0, result, 0.001)
    }
    @Test
    fun calculateTip15PercentRoundUp() {
        val result = calculateTip(100.0, 15, true)
        assertEquals(15.0, result, 0.001)
    }
    @Test
    fun returnsZeroForNegativeAmount() {
        val result = calculateTip(-50.0, 15, false)
        assertEquals(0.0, result, 0.001)
    }
    @Test
    fun totalPersonIsCorrect() {
        val bill = 120.0
        val tip = calculateTip(bill, 20, false)
        val people = 4
        val totalPerPerson = if (people > 0) (bill + tip) / people else 0.0
        assertEquals(36.0, totalPerPerson, 0.001)
    }
}


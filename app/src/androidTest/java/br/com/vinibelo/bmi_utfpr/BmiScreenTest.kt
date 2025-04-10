package br.com.vinibelo.bmi_utfpr

import androidx.compose.ui.test.assertTextEquals
import br.com.vinibelo.bmi_utfpr.model.BmiClassification
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class BmiScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val testCases = listOf(
        TestCase(0.0, 0.0, BmiClassification.WAITING_DATA),
        TestCase(1.7, 50.0, BmiClassification.THINNESS),
        TestCase(1.7, 65.0, BmiClassification.NORMAL),
        TestCase(1.7, 80.0, BmiClassification.OVERWEIGHT),
        TestCase(1.7, 95.0, BmiClassification.OBESE),
        TestCase(1.7, 110.0, BmiClassification.VERY_OBESE),
        TestCase(1.7, 120.0, BmiClassification.MORBID_OBESE)
    )

    @Test
    fun testBmiClassificationForDifferentInputs() {
        composeTestRule.setContent {
            BmiScreen()
        }

        testCases.forEach { testCase ->
            composeTestRule.onNodeWithTag("heightField")
                .performTextInput(testCase.height.toString())

            composeTestRule.onNodeWithTag("weightField")
                .performTextInput(testCase.weight.toString())

            composeTestRule.onNodeWithTag("calculateButton")
                .performClick()

            composeTestRule.onNodeWithTag("resultText")
                .assertTextEquals(testCase.expected.label)
        }
    }

    data class TestCase(
        val height: Double,
        val weight: Double,
        val expected: BmiClassification
    )
}
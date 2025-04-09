package br.com.vinibelo.bmi_utfpr

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class BmiUnitTest {
    @Before
    fun before() {
        val bmiViewModel = BmiViewModel()
    }

    @Test
    fun `should return waiting data when height is zero`() {
        // Given
        val height = 0.0
        val weight = 70.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.WAITING_DATA, result)
    }

    @Test
    fun `should return waiting data when weight is zero`() {
        // Given
        val height = 1.7
        val weight = 0.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.WAITING_DATA, result)
    }

    @Test
    fun `should return waiting data when height and weight are zero`() {
        // Given
        val height = 0.0
        val weight = 0.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.WAITING_DATA, result)
    }

    @Test
    fun `should return underweight`() {
        // Given
        val height = 1.7
        val weight = 50.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, BmiClassification.THINNESS)
    }

    @Test
    fun `should return normal weight`() {
        // Given
        val height = 1.7
        val weight = 65.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, BmiClassification.NORMAL)
    }

    @Test
    fun `should return overweight`() {
        // Given
        val height = 1.7
        val weight = 80.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, BmiClassification.OVERWEIGHT)
    }

    @Test
    fun `should return obese`() {
        // Given
        val height = 1.7
        val weight = 95.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, BmiClassification.OBESE)
    }

    @Test
    fun `should return very obese`() {
        // Given
        val height = 1.7
        val weight = 110.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, BmiClassification.VERY_OBESE)
    }

    @Test
    fun `should return morbid obese`() {
        // Given
        val height = 1.7
        val weight = 120.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, BmiClassification.MORBID_OBESE)
    }
}
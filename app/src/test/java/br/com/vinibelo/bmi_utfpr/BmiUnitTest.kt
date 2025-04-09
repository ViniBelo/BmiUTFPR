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
    fun `should return waiting data`() {
        assertEquals(bmiViewModel.result, Bmi.classifications[0])
    }

    @Test
    fun `should return underweight`() {
        // Given
        val height = 1.7
        val weight = 50.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, Bmi.classifications[1])
    }

    @Test
    fun `should return normal weight`() {
        // Given
        val height = 1.7
        val weight = 65.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, Bmi.classifications[2])
    }

    @Test
    fun `should return normal overweight`() {
        // Given
        val height = 1.7
        val weight = 80.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, Bmi.classifications[3])
    }

    @Test
    fun `should return normal obesity class I`() {
        // Given
        val height = 1.7
        val weight = 95.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, Bmi.classifications[4])
    }

    @Test
    fun `should return normal obesity class II`() {
        // Given
        val height = 1.7
        val weight = 110.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, Bmi.classifications[5])
    }

    @Test
    fun `should return normal obesity class III`() {
        // Given
        val height = 1.7
        val weight = 120.0

        // When
        val result = bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(result, Bmi.classifications[6])
    }
}
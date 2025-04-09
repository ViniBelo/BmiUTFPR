package br.com.vinibelo.bmi_utfpr

import br.com.vinibelo.bmi_utfpr.model.BmiClassification
import br.com.vinibelo.bmi_utfpr.ui.bmi.BmiViewModel
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class BmiUnitTest {
    private lateinit var bmiViewModel: BmiViewModel

    @Before
    fun before() {
        bmiViewModel = BmiViewModel()
    }

    @Test
    fun `should return waiting data when height is zero`() {
        // Given
        val height = 0.0
        val weight = 70.0

        // When
        bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.WAITING_DATA, bmiViewModel.result)
    }

    @Test
    fun `should return waiting data when weight is zero`() {
        // Given
        val height = 1.7
        val weight = 0.0

        // When
        bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.WAITING_DATA, bmiViewModel.result)
    }

    @Test
    fun `should return waiting data when height and weight are zero`() {
        // Given
        val height = 0.0
        val weight = 0.0

        // When
        bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.WAITING_DATA, bmiViewModel.result)
    }

    @Test
    fun `should return underweight`() {
        // Given
        val height = 1.7
        val weight = 50.0

        // When
        bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.THINNESS, bmiViewModel.result)
    }

    @Test
    fun `should return normal weight`() {
        // Given
        val height = 1.7
        val weight = 65.0

        // When
        bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.NORMAL, bmiViewModel.result)
    }

    @Test
    fun `should return overweight`() {
        // Given
        val height = 1.7
        val weight = 80.0

        // When
        bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.OVERWEIGHT, bmiViewModel.result)
    }

    @Test
    fun `should return obese`() {
        // Given
        val height = 1.7
        val weight = 95.0

        // When
        bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.OBESE, bmiViewModel.result)
    }

    @Test
    fun `should return very obese`() {
        // Given
        val height = 1.7
        val weight = 110.0

        // When
        bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.VERY_OBESE, bmiViewModel.result)
    }

    @Test
    fun `should return morbid obese`() {
        // Given
        val height = 1.7
        val weight = 120.0

        // When
        bmiViewModel.calculateBmi(height, weight)

        // Then
        assertEquals(BmiClassification.MORBID_OBESE, bmiViewModel.result)
    }
}
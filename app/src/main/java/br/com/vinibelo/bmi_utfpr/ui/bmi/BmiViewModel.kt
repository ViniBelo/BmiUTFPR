package br.com.vinibelo.bmi_utfpr.ui.bmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import br.com.vinibelo.bmi_utfpr.model.BmiClassification

class BmiViewModel(): ViewModel() {
    var uiState by mutableStateOf(BmiUiState())
        private set

    fun calculateBmi(height: Double, weight: Double) {
        if (height.equals(0.0) || weight.equals(0.0)) return
        val bmi = weight / (height * height)

        uiState = uiState.copy(
            result = when {
                bmi < 18.5 -> BmiClassification.THINNESS
                bmi < 25 -> BmiClassification.NORMAL
                bmi < 30 -> BmiClassification.OVERWEIGHT
                bmi < 35 -> BmiClassification.OBESE
                bmi < 40 -> BmiClassification.VERY_OBESE
                else -> BmiClassification.MORBID_OBESE
            }
        )
    }
}
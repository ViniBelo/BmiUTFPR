package br.com.vinibelo.bmi_utfpr.ui.bmi

import androidx.lifecycle.ViewModel
import br.com.vinibelo.bmi_utfpr.model.BmiClassification

class BmiViewModel(): ViewModel() {
    var result: BmiClassification = BmiClassification.WAITING_DATA
        private set

    fun calculateBmi(height: Double, weight: Double) {
        if (height.equals(0.0) || weight.equals(0.0)) return
        val bmi = weight / (height * height)

        result = when {
            bmi < 18.5 -> BmiClassification.THINNESS
            bmi < 25 -> BmiClassification.NORMAL
            bmi < 30 -> BmiClassification.OVERWEIGHT
            bmi < 35 -> BmiClassification.OBESE
            bmi < 40 -> BmiClassification.VERY_OBESE
            else -> BmiClassification.MORBID_OBESE
        }
    }
}
package br.com.vinibelo.bmi_utfpr.ui.bmi

import br.com.vinibelo.bmi_utfpr.model.BmiClassification

data class BmiUiState(
    val result: BmiClassification = BmiClassification.WAITING_DATA
)

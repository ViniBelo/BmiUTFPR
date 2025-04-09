package br.com.vinibelo.bmi_utfpr.model

enum class BmiClassification(val label: String) {
    WAITING_DATA("Waiting data"),
    THINNESS("Thinness"),
    NORMAL("Normal"),
    OVERWEIGHT("Overweight"),
    OBESE("Obese"),
    VERY_OBESE("Very obese"),
    MORBID_OBESE("Morbid obese")
}
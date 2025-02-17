package org.example.project.weather.domain.models

data class Weather(
    val cityName: String,
    val country: String,
    val localTime: String,
    val temperatureC: Double,
    val temperatureF: Double,
    val feelsLikeC: Double,
    val feelsLikeF: Double,
    val windKph: Double,
    val windDirection: String,
    val condition: String,
    val icon: String
    )

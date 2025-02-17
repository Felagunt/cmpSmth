package org.example.project.weather.presentation

import org.example.project.weather.domain.models.Weather

data class WeatherState (
    val searchQuery: String = "Moscow",
    //val searchResult: Weather? = null,
    val isLoading: Boolean = false,
    val errorMsg: String? = null,
    val weather: Weather? = null
)
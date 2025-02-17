package org.example.project.weather.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponseDTO(
    val current: Current,
    val location: Location
)
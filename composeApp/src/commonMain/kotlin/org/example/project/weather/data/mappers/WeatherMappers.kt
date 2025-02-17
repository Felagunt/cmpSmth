package org.example.project.weather.data.mappers

import org.example.project.weather.data.dto.WeatherResponseDTO
import org.example.project.weather.domain.models.Weather

fun WeatherResponseDTO.toWeather(): Weather {
    return Weather(
        cityName = location.name,
        country = location.country,
        localTime = location.localtime,
        temperatureC = current.temp_c,
        temperatureF = current.dewpoint_f,
        feelsLikeC = current.feelslike_c,
        feelsLikeF = current.feelslike_f,
        windKph = current.wind_kph,
        windDirection = current.wind_dir,
        condition = current.condition.text,
        icon = current.condition.icon
    )
}
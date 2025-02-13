package org.example.project.Weather.domain.repository

import org.example.project.Weather.domain.models.Weather
import org.example.project.core.DataError
import org.example.project.core.Result

interface WeatherRepository {
    suspend fun getCurrentWeather(city: String): Result<Weather, DataError.Remote>
}
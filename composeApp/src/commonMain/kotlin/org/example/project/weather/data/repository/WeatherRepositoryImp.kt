package org.example.project.weather.data.repository

import org.example.project.weather.data.mappers.toWeather
import org.example.project.weather.data.network.KtorRemoteWeatherDataSource
import org.example.project.weather.domain.models.Weather
import org.example.project.weather.domain.repository.WeatherRepository
import org.example.project.core.DataError
import org.example.project.core.Result
import org.example.project.core.map

class WeatherRepositoryImp(
    private val remoteWeatherDataSource: KtorRemoteWeatherDataSource
): WeatherRepository {
    override suspend fun getCurrentWeather(city: String): Result<Weather, DataError.Remote> {
        return remoteWeatherDataSource.getCurrentWeather(city)
            .map { it.toWeather() }
    }
}
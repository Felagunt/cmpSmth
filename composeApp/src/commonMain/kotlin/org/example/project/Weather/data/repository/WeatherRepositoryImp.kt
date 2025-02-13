package org.example.project.Weather.data.repository

import org.example.project.Weather.data.mappers.toWeather
import org.example.project.Weather.data.network.KtorRemoteWeatherDataSource
import org.example.project.Weather.domain.models.Weather
import org.example.project.Weather.domain.repository.WeatherRepository
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
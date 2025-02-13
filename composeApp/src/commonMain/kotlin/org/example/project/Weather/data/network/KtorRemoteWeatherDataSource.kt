package org.example.project.Weather.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.example.project.Weather.data.dto.WeatherResponseDTO
import org.example.project.core.DataError
import org.example.project.core.Result
import org.example.project.core.safeCall

private const val BASE_URL = "https://api.weatherapi.com"

class KtorRemoteWeatherDataSource(
    private val httpClient: HttpClient
) {
    suspend fun getCurrentWeather(
        city: String
    ):
            Result<WeatherResponseDTO, DataError.Remote> {
        return safeCall<WeatherResponseDTO> {
            httpClient.get(
                urlString = "$BASE_URL/v1/current.json"
            ) {
                parameter("key", "fa57e7b1f1aa426e92c73659251302")
                parameter("q", city)
            }
        }
    }
}
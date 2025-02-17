package org.example.project.weather.presentation

sealed interface WeatherAction {
    data class OnSearchQueryChange(val query: String): WeatherAction
}
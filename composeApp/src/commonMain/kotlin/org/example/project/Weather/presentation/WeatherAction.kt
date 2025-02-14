package org.example.project.Weather.presentation

sealed interface WeatherAction {
    data class OnSearchQueryChange(val query: String): WeatherAction
}
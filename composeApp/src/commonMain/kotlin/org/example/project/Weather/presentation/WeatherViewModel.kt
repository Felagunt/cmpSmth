package org.example.project.Weather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.Weather.domain.repository.WeatherRepository
import org.example.project.core.onError
import org.example.project.core.onSuccess

class WeatherViewModel(
    val weatherRepository: WeatherRepository
): ViewModel() {

    private var searchJob: Job? = null

    private val _state = MutableStateFlow(WeatherState())
    val state = _state
        .onStart {
            observeSearchQuery()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: WeatherAction) {
        when (action) {
            is WeatherAction.OnSearchQueryChange -> {
                _state.update {
                    it.copy(searchQuery = action.toString())
                }
            }
        }
    }


    private fun observeSearchQuery() {
        state
            .map { it.searchQuery }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { city ->
                city?.let {
                    searchJob?.cancel()
                    searchJob = fetchWeather(city)
                }
            }
    }

    private fun fetchWeather(city: String) = viewModelScope.launch {
            weatherRepository
                .getCurrentWeather(city = city)
                .onSuccess { weatherResult ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            errorMsg = null,
                            weather = weatherResult
                        )
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            weather = null,
                            errorMsg = error.toString()
                        )
                    }
                }

    }
}
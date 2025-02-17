package org.example.project.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.weather.presentation.WeatherScreenRoot
import org.example.project.weather.presentation.WeatherViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App()
 {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.Weather
        ) {
            composable<Route.Weather>(
            ) {
                val viewModel = koinViewModel<WeatherViewModel>()
                WeatherScreenRoot(
                    viewModel = viewModel
                )
            }
        }
    }
}
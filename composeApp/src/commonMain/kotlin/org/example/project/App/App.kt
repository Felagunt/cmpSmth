package org.example.project.App

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.Weather.presentation.WeatherScreenRoot
import org.example.project.Weather.presentation.WeatherViewModel
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
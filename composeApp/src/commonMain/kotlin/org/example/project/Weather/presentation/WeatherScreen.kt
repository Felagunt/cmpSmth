package org.example.project.Weather.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.project.Weather.presentation.components.TempRow
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun WeatherScreenRoot(
    viewModel: WeatherViewModel = koinViewModel(),
    //onAction: (Weather) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    WeatherScreen(
        state = state,
        onAction = { action ->
            viewModel.onAction(action)
        }
    )
}

@Composable
private fun WeatherScreen(
    state: WeatherState,
    onAction: (WeatherAction) -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(state.searchQuery) {

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        WeatherSearchBar(
            searchQuery = state.searchQuery,
            onSearchQueryChange = {
                onAction(WeatherAction.OnSearchQueryChange(it))
            },
            onImeSearch = {
                keyboardController?.hide()
            },
            modifier = Modifier
                .widthIn(max = 400.dp)
                .fillMaxWidth()
                .padding(16.dp)
        )
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            when {
                state.errorMsg != null -> {
                    Text(
                        text = state.errorMsg.toString(),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }

                state.searchQuery.isEmpty() -> {
                    Text(
                        text = "Search city name",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }

                else -> {
                    state.weather?.let {
                        Box(
                            modifier = Modifier
                                .align(alignment = Alignment.Start)
                                .padding(15.dp)
                        ) {
                            Text(
                                text = state.weather.cityName,
                                style = MaterialTheme.typography.headlineMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = state.weather.localTime,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                TempRow(
                                    state = state.weather
                                )
                            }
                        }

                    }
                }
            }
        }

    }

}
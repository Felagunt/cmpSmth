package org.example.project.weather.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.weather.domain.models.Weather

@Composable
fun AdditionRow(
    state: Weather,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .height(100.dp)
            .background(color = MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Text(
                    text = "Feels like ",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = state.feelsLikeC.toString(),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Text(
                    text = "Wind",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "${state.windKph} kpH, ${state.windDirection}",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}
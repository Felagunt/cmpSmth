package org.example.project.weather.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import org.example.project.weather.domain.models.Weather

@Composable
fun TempRow(
    state: Weather,
    modifier: Modifier = Modifier
) {
    // state.weather.let {
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
            Text(
                text = state.temperatureC.toString(),
                style = MaterialTheme.typography.titleLarge
            )
            var imageLoadResult by remember { mutableStateOf<Result<Painter>?>(null) }
            val painter = rememberAsyncImagePainter(
                model = state.icon,
                onSuccess = {
                    imageLoadResult = Result.success(it.painter)
                },
                onError = {
                    imageLoadResult = Result.failure(it.result.throwable)
                }
            )
            val painterState by painter.state.collectAsStateWithLifecycle()
            if (painterState is AsyncImagePainter.State.Loading) {
                CircularProgressIndicator()
            } else {
                Image(
                    painter = painter,
                    contentDescription = state.condition,
                    modifier = Modifier.alpha(1f)
                )
            }
            Text(
                text = state.condition,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
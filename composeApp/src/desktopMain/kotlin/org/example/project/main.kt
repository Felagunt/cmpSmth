package org.example.project

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.ktor.client.engine.okhttp.OkHttp
import org.example.project.di.initKoin
import org.example.project.App.App

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "cmpSmth",
        ) {
            App()
        }
    }
}
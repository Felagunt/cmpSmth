package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.project.di.initKoin
import org.example.project.app.App

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
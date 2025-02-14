package org.example.project

import androidx.compose.ui.window.ComposeUIViewController
import org.example.project.App.App
import org.example.project.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }
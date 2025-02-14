package org.example.project.App

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Weather: Route
}
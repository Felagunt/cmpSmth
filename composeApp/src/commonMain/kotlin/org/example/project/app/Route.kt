package org.example.project.app

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Weather: Route
}
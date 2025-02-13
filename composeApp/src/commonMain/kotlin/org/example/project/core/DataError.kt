package org.example.project.core

sealed interface DataError: Error {
    enum class Remote: DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        SERIALIZATION,
        NOT_INTERNET,
        SERVER,
        UNKNOWN
    }

    enum class local: DataError {
        DISK_FULL,
        UNKNOWN
    }
}
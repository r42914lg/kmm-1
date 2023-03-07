package com.r42914lg.trykmm

import io.ktor.client.*

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun httpClient(): HttpClient

package com.r42914lg.trykmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
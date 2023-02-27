package com.r42914lg.trykmm

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Жесть какая-то )), ${platform.name}!"
    }
}
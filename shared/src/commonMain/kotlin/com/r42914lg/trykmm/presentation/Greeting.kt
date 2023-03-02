package com.r42914lg.trykmm.presentation

import com.r42914lg.trykmm.Platform
import com.r42914lg.trykmm.getPlatform

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Жесть какая-то )), ${platform.name}!"
    }
}
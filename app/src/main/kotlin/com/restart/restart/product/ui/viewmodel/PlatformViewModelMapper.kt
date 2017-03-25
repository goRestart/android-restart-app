package com.restart.restart.product.ui.viewmodel

import com.restart.restart.domain.model.Platform

class PlatformViewModelMapper {
    fun map(platform: Platform): String =
        when (platform) {
            Platform.PSX -> "PSX"
            Platform.PS2 -> "PS2"
            Platform.PS3 -> "PS3"
            Platform.PS4 -> "PS4"
            Platform.XBOX -> "Xbox"
            Platform.XBOX_360 -> "Xbox 360"
            Platform.XBOX_ONE -> "Xbox One"
            Platform.PC -> "PC"
            else -> "Other"
        }
}
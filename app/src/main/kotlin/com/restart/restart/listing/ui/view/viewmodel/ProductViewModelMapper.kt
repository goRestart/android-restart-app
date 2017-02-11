package com.restart.restart.listing.ui.view.viewmodel

import android.content.Context
import com.restart.restart.listing.domain.Platform
import com.restart.restart.listing.domain.Product

class ProductViewModelMapper(private val context: Context) {

    fun map(product: Product): ProductViewModel =
        ProductViewModel(
            product.title,
            mapPlatform(product.platform),
            mapPrice(product.priceInMilliEuros),
            product.previewUrl,
            context
        )

    private fun mapPlatform(platform: Platform): String =
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

    private fun mapPrice(price: Int): String {
        val units = price / 100
        return "$units€"
    }
}
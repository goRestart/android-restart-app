package com.restart.restart.product.ui.viewmodel

class PriceViewModelMapper {
    fun map(priceInMilliEuros: Int): String {
        val units = priceInMilliEuros / 100
        return "$units€"
    }
}
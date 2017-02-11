package com.restart.restart.listing.domain

data class Product(
    val id: String,
    val title: String,
    val platform: Platform,
    val priceInMilliEuros: Int,
    val previewUrl: String
)
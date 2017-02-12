package com.restart.restart.domain.model

data class Product(
    val id: String,
    val title: String,
    val platform: Platform,
    val priceInMilliEuros: Int,
    val previewUrl: String
)
package com.restart.restart.domain.model

import android.location.Location

data class ProductDetail(
    val id: String,
    val title: String,
    val description: String,
    val platform: Platform,
    val priceInMilliEuros: Int,
    val previewUrls: List<String>,
    val isFavorite: Boolean,
    val isInWishlist: Boolean,
    val publishingTime: Long,
    val visitsCount: Int,
    val location: Location,
    val seller: Seller
)
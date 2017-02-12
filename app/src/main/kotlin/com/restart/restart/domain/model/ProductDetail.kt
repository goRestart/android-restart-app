package com.restart.restart.domain.model

import android.location.Location
import com.restart.restart.domain.model.Platform

data class ProductDetail(
    val id: String,
    val title: String,
    val description: String,
    val platform: Platform,
    val priceInMilliEuros: Int,
    val previewUrl: String,
    val isFavorite: Boolean,
    val isInWishlist: Boolean,
    val publishingTime: Long,
    val visitsCount: Int,
    val location: Location,
    val seller: Seller
)
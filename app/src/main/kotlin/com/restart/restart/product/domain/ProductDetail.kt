package com.restart.restart.product.domain

import android.location.Location
import com.restart.restart.listing.domain.Platform

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
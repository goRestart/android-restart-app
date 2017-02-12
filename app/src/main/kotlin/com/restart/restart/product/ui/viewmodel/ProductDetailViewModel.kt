package com.restart.restart.product.ui.viewmodel

import android.location.Location

data class ProductDetailViewModel(
    val id: String,
    val title: String,
    val description: String,
    val platform: String,
    val price: String,
    val previewUrl: String,
    val isFavorite: Boolean,
    val isInWishlist: Boolean,
    val publishingTime: String,
    val visitsCount: String,
    val location: Location,
    val sellerName: String,
    val sellerProductsCount: String
)
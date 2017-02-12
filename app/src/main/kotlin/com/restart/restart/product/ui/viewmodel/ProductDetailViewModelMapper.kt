package com.restart.restart.product.ui.viewmodel

import com.restart.restart.domain.model.ProductDetail

class ProductDetailViewModelMapper(
    private val platformMapper: PlatformViewModelMapper,
    private val priceMapper: PriceViewModelMapper
) {
    fun map(product: ProductDetail): ProductDetailViewModel =
        ProductDetailViewModel(
            product.id,
            product.title,
            product.description,
            platformMapper.map(product.platform),
            priceMapper.map(product.priceInMilliEuros),
            product.previewUrl,
            product.isFavorite,
            product.isInWishlist,
            mapPublishingTime(product.publishingTime),
            mapVisitsCount(product.visitsCount),
            product.location,
            product.seller.name,
            mapSellerProductsCount(product.seller.sellingProductsCount)
        )

    private fun mapPublishingTime(publishingTime: Long): String {
        return "Hace 16 horas"
    }

    private fun mapVisitsCount(visitsCount: Int): String {
        return "$visitsCount visitas"
    }

    private fun mapSellerProductsCount(sellerProductsCount: Int): String {
        return "$sellerProductsCount productos"
    }
}
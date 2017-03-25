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
            product.previewUrls,
            product.isFavorite,
            product.isInWishlist,
            mapPublishingTimeAndVisitsCount(product.publishingTime, product.visitsCount),
            product.location,
            product.seller.name,
            mapSellerProductsCount(product.seller.sellingProductsCount)
        )

    private fun mapPublishingTimeAndVisitsCount(publishingTime: Long, visitsCount: Int): String {
        return "Hace 16 horas · 160 visitas"
    }

    private fun mapSellerProductsCount(sellerProductsCount: Int): String {
        return "$sellerProductsCount productos"
    }
}
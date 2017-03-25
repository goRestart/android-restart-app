package com.restart.restart.listing.ui.view.viewmodel

import android.content.Context
import com.restart.restart.domain.model.Product
import com.restart.restart.product.ui.viewmodel.PlatformViewModelMapper
import com.restart.restart.product.ui.viewmodel.PriceViewModelMapper

class ProductViewModelMapper(
    private val platformMapper: PlatformViewModelMapper,
    private val priceMapper: PriceViewModelMapper,
    private val context: Context
) {
    fun map(product: Product): ProductViewModel =
        ProductViewModel(
            product.id,
            product.title,
            platformMapper.map(product.platform),
            priceMapper.map(product.priceInMilliEuros),
            product.previewUrl,
            context
        )
}
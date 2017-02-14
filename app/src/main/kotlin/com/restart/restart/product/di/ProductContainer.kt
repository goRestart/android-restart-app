package com.restart.restart.product.di

import com.restart.restart.domain.usecase.GetProduct
import com.restart.restart.product.ui.ProductPresenter
import com.restart.restart.product.ui.viewmodel.ProductDetailViewModelMapper
import com.restart.restart.shared.di.DependencyContainer
import com.restart.restart.storage.ProductStorage
import java.lang.ref.WeakReference

class ProductContainer(
    private val dependencyContainer: DependencyContainer
) {

    fun getPresenter(view: ProductPresenter.View, productId: String): ProductPresenter {
        return ProductPresenter(
            WeakReference(view),
            productId,
            getProduct,
            productDetailViewModelMapper
        )
    }

    val getProduct: GetProduct
        get() = GetProduct(productStorage)

    val productStorage: ProductStorage
        get() = ProductStorage()

    val productDetailViewModelMapper: ProductDetailViewModelMapper
        get() = ProductDetailViewModelMapper(
            dependencyContainer.platformViewModelMapper,
            dependencyContainer.priceViewModelMapper
        )
}
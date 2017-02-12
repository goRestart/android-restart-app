package com.restart.restart.product.di

import com.restart.restart.domain.usecase.GetProduct
import com.restart.restart.product.storage.ProductStorage
import com.restart.restart.product.ui.ProductPresenter
import java.lang.ref.WeakReference

class ProductContainer {

    fun getPresenter(view: ProductPresenter.View, productId: String): ProductPresenter {
        return ProductPresenter(
            WeakReference(view),
            productId,
            getProduct
        )
    }

    val getProduct: GetProduct
        get() = GetProduct(productStorage)

    val productStorage: ProductStorage
        get() = ProductStorage()
}
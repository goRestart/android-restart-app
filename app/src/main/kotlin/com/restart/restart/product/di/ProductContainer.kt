package com.restart.restart.product.di

import com.restart.restart.product.domain.GetProduct
import com.restart.restart.product.ui.ProductPresenter
import java.lang.ref.WeakReference

class ProductContainer {

    fun getPresenter(view: ProductPresenter.View): ProductPresenter {
        return ProductPresenter(
            WeakReference(view),
            getProduct
        )
    }

    val getProduct: GetProduct
        get() = GetProduct()
}
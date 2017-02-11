package com.restart.restart.product.ui

import com.restart.restart.product.domain.GetProduct
import java.lang.ref.WeakReference

class ProductPresenter(
    private val view: WeakReference<View>,
    private val getProduct: GetProduct
) {

    fun onStart() {
        getProduct.execute("")
    }

    interface View {
        fun showProduct()
        fun showError()
    }
}
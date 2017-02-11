package com.restart.restart.product.ui

import com.restart.restart.product.domain.GetProduct
import com.restart.restart.shared.extensions.ref.invoke
import nl.komponents.kovenant.ui.failUi
import nl.komponents.kovenant.ui.successUi
import java.lang.ref.WeakReference

class ProductPresenter(
    private val view: WeakReference<View>,
    private val productId: String,
    private val getProduct: GetProduct
) {

    fun onStart() {
        getProduct.execute(productId) successUi {
            view()?.showProduct()
        } failUi {
            view()?.showError()
        }
    }

    interface View {
        fun showProduct()
        fun showError()
    }
}
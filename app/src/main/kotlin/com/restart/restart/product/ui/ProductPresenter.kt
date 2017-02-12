package com.restart.restart.product.ui

import com.restart.restart.domain.usecase.GetProduct
import com.restart.restart.product.ui.viewmodel.ProductDetailViewModel
import com.restart.restart.product.ui.viewmodel.ProductDetailViewModelMapper
import com.restart.restart.shared.extensions.ref.invoke
import nl.komponents.kovenant.ui.successUi
import java.lang.ref.WeakReference

class ProductPresenter(
    private val view: WeakReference<View>,
    private val productId: String,
    private val getProduct: GetProduct,
    private val mapper: ProductDetailViewModelMapper
) {

    fun onStart() {
        getProduct.execute(productId) successUi {
            val product = mapper.map(it)
            view()?.showProduct(product)
        } failUi {
            view()?.showError()
        }
    }

    interface View {
        fun showProduct(product: ProductDetailViewModel)
        fun showError()
    }
}
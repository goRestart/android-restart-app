package com.restart.restart.listing.ui

import com.restart.restart.listing.domain.GetProducts
import com.restart.restart.listing.ui.view.viewmodel.ProductViewModel
import com.restart.restart.listing.ui.view.viewmodel.ProductViewModelMapper
import java.lang.ref.WeakReference

class ListingPresenter(
    private val view: WeakReference<View>,
    private val getProducts: GetProducts,
    private val productMapper: ProductViewModelMapper
) {

    fun onStart() {
        getProducts.execute().success {
            val viewModels = it.map { productMapper.map(it) }
            view.get().showProducts(viewModels)
        }.fail {
            view.get().showError()
        }
    }

    interface View {
        fun showProducts(products: List<ProductViewModel>)
        fun showError()
    }

}
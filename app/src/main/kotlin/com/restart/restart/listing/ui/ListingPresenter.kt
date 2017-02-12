package com.restart.restart.listing.ui

import com.restart.restart.domain.usecase.GetProducts
import com.restart.restart.listing.ui.view.viewmodel.ProductViewModel
import com.restart.restart.listing.ui.view.viewmodel.ProductViewModelMapper
import com.restart.restart.shared.extensions.ref.invoke
import nl.komponents.kovenant.ui.failUi
import nl.komponents.kovenant.ui.successUi
import java.lang.ref.WeakReference

class ListingPresenter(
    private val view: WeakReference<View>,
    private val getProducts: GetProducts,
    private val productMapper: ProductViewModelMapper
) {

    fun onStart() {
        getProducts.execute() successUi {
            val viewModels = it.map { productMapper.map(it) }
            view()?.showProducts(viewModels)
        } failUi {
            view()?.showError()
        }
    }

    interface View {
        fun showProducts(products: List<ProductViewModel>)
        fun showError()
    }

}
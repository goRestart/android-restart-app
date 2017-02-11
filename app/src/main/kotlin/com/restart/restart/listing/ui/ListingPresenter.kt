package com.restart.restart.listing.ui

import com.restart.restart.listing.domain.GetProducts
import com.restart.restart.listing.domain.Product
import java.lang.ref.WeakReference

class ListingPresenter(
    private val view: WeakReference<View>,
    private val getProducts: GetProducts) {

    fun onStart() {
        getProducts.execute().success {
            view.get().showProducts(it)
        }.fail {
            view.get().showError()
        }
    }

    interface View {
        fun showProducts(products: List<Product>)
        fun showError()
    }

}
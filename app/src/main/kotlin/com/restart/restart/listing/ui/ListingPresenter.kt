package com.restart.restart.listing.ui

import com.restart.restart.listing.ui.view.viewmodel.AdViewModel
import java.lang.ref.WeakReference

class ListingPresenter(private val view: WeakReference<View>) {

    fun onStart() {
        
    }

    interface View {
        fun showProducts(products: List<AdViewModel>)
    }

}
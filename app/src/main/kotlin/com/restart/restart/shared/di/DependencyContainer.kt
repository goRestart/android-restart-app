package com.restart.restart.shared.di

import com.restart.restart.listing.di.ListingContainer
import com.restart.restart.main.ui.MainPresenter
import com.restart.restart.product.di.ProductContainer
import java.lang.ref.WeakReference

class DependencyContainer {

    val listing: ListingContainer
        get() = ListingContainer()

    val product: ProductContainer
        get() = ProductContainer()

    fun getMainPresenter(view: MainPresenter.View): MainPresenter {
        return MainPresenter(WeakReference(view))
    }
}
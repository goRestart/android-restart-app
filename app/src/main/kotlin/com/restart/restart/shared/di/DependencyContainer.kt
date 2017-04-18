package com.restart.restart.shared.di

import com.restart.restart.listing.di.ListingContainer
import com.restart.restart.login.di.LoginContainer
import com.restart.restart.main.ui.MainPresenter
import com.restart.restart.product.di.ProductContainer
import com.restart.restart.product.ui.viewmodel.PlatformViewModelMapper
import com.restart.restart.product.ui.viewmodel.PriceViewModelMapper
import com.restart.restart.storage.ProductStorage
import java.lang.ref.WeakReference

class DependencyContainer {

    val listing: ListingContainer
        get() = ListingContainer(this)

    val product: ProductContainer
        get() = ProductContainer(this)

    val login: LoginContainer
        get() = LoginContainer(this)

    fun getMainPresenter(view: MainPresenter.View): MainPresenter {
        return MainPresenter(WeakReference(view))
    }

    val productStorage: ProductStorage by lazy {
        ProductStorage()
    }

    val priceViewModelMapper: PriceViewModelMapper
        get() = PriceViewModelMapper()

    val platformViewModelMapper: PlatformViewModelMapper
        get() = PlatformViewModelMapper()
}
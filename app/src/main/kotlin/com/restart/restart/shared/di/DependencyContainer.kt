package com.restart.restart.shared.di

import android.content.Context
import android.content.SharedPreferences
import com.restart.restart.listing.di.ListingContainer
import com.restart.restart.login.di.LoginContainer
import com.restart.restart.main.ui.MainPresenter
import com.restart.restart.product.di.ProductContainer
import com.restart.restart.product.ui.viewmodel.PlatformViewModelMapper
import com.restart.restart.product.ui.viewmodel.PriceViewModelMapper
import com.restart.restart.storage.ProductStorage
import java.lang.ref.WeakReference

class DependencyContainer {
    var activityContext: Context? = null

    val context: Context
        get() = activityContext!!

    val listing: ListingContainer by lazy {
        ListingContainer(this)
    }

    val product: ProductContainer by lazy {
        ProductContainer(this)
    }

    val login: LoginContainer by lazy {
        LoginContainer(this)
    }

    fun getMainPresenter(view: MainPresenter.View): MainPresenter {
        return MainPresenter(
            WeakReference(view),
            login.isLoggedIn,
            login.subscribeToSession,
            login.unsubscribeFromSession
        )
    }

    val productStorage: ProductStorage by lazy {
        ProductStorage()
    }

    val priceViewModelMapper: PriceViewModelMapper
        get() = PriceViewModelMapper()

    val platformViewModelMapper: PlatformViewModelMapper
        get() = PlatformViewModelMapper()

    val sharedPreferences: SharedPreferences
        get() = context.getSharedPreferences(
            "Restart App Shared Preferences",
            Context.MODE_PRIVATE
        )
}
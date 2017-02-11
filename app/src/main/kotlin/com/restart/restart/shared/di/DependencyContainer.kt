package com.restart.restart.shared.di

import com.restart.restart.listing.di.ListingContainer
import com.restart.restart.main.ui.MainPresenter
import java.lang.ref.WeakReference

class DependencyContainer {

    val listing: ListingContainer
    get() = ListingContainer()

    fun getMainPresenter(view: MainPresenter.View): MainPresenter {
        return MainPresenter(WeakReference(view))
    }
}
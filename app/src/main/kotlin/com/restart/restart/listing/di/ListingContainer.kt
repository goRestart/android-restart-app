package com.restart.restart.listing.di

import com.restart.restart.listing.ui.ListingPresenter
import java.lang.ref.WeakReference

class ListingContainer {

    fun getPresenter(view: ListingPresenter.View): ListingPresenter {
        return ListingPresenter(WeakReference(view))
    }
}
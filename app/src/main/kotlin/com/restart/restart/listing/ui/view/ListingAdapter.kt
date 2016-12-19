package com.restart.restart.listing.ui.view

import com.airbnb.epoxy.EpoxyAdapter

class ListingAdapter : EpoxyAdapter() {

    init {
        addModels(TitleModel())
    }
}
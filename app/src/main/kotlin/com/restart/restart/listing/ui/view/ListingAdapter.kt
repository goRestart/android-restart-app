package com.restart.restart.listing.ui.view

import com.airbnb.epoxy.EpoxyAdapter
import com.restart.restart.listing.ui.view.viewmodel.DistanceViewModel
import com.restart.restart.listing.ui.view.viewmodel.FilterViewModel
import com.restart.restart.listing.ui.view.viewmodel.SearchViewModel
import com.restart.restart.listing.ui.view.viewmodel.TitleViewModel

class ListingAdapter : EpoxyAdapter() {

    init {
        addModels(
            TitleViewModel(),
            SearchViewModel(),
            DistanceViewModel(),
            FilterViewModel()
        )
    }
}
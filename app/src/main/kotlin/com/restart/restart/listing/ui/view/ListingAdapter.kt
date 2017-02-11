package com.restart.restart.listing.ui.view

import com.airbnb.epoxy.EpoxyAdapter
import com.restart.restart.listing.ui.view.viewmodel.DistanceFilterViewModel
import com.restart.restart.listing.ui.view.viewmodel.ProductViewModel
import com.restart.restart.listing.ui.view.viewmodel.SearchViewModel
import com.restart.restart.listing.ui.view.viewmodel.TitleViewModel

class ListingAdapter : EpoxyAdapter() {
    init {
        addModels(
            TitleViewModel(),
            SearchViewModel(),
            DistanceFilterViewModel()
        )
    }

    fun addProducts(products: List<ProductViewModel>) {
        addModels(products)
    }
}
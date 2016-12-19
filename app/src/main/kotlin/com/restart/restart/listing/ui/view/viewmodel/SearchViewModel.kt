package com.restart.restart.listing.ui.view.viewmodel

import com.airbnb.epoxy.SimpleEpoxyModel
import com.restart.restart.R
import com.restart.restart.listing.ui.view.ListingConfiguration

class SearchViewModel : SimpleEpoxyModel(R.layout.search_cell) {
    override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int =
        ListingConfiguration.NUMBER_OF_COLUMNS
}
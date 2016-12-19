package com.restart.restart.listing.ui.view.viewmodel

import android.view.View
import com.airbnb.epoxy.EpoxyModel
import com.restart.restart.R

class SearchViewModel : EpoxyModel<View>() {
    override fun getDefaultLayout(): Int = R.layout.search_cell
}
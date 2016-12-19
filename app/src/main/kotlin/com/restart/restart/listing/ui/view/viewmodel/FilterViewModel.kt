package com.restart.restart.listing.ui.view.viewmodel

import com.airbnb.epoxy.SimpleEpoxyModel
import com.restart.restart.R

class FilterViewModel : SimpleEpoxyModel(R.layout.filter_cell) {
    override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int = 1
}
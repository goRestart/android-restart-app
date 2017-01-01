package com.restart.restart.listing.ui.view.viewmodel

import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.airbnb.epoxy.SimpleEpoxyModel
import com.restart.restart.R

class SearchViewModel : SimpleEpoxyModel(R.layout.search_cell) {
    override fun bind(view: View?) {
        super.bind(view)

        val layoutParams = view?.layoutParams as? StaggeredGridLayoutManager.LayoutParams
        layoutParams?.isFullSpan = true
    }
}
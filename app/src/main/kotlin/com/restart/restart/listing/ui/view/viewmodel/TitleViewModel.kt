package com.restart.restart.listing.ui.view.viewmodel

import android.view.View
import com.airbnb.epoxy.EpoxyModel
import com.restart.restart.R

class TitleViewModel : EpoxyModel<View>() {
    override fun getDefaultLayout(): Int = R.layout.title_cell
}
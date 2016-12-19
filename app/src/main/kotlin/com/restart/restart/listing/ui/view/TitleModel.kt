package com.restart.restart.listing.ui.view

import android.view.View
import com.airbnb.epoxy.EpoxyModel
import com.restart.restart.R

class TitleModel : EpoxyModel<View>() {
    override fun getDefaultLayout(): Int {
        return R.layout.title_view
    }
}
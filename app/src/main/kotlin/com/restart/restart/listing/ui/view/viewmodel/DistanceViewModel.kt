package com.restart.restart.listing.ui.view.viewmodel

import android.text.style.TextAppearanceSpan
import android.widget.TextView
import com.airbnb.epoxy.EpoxyModel
import com.restart.restart.R
import com.restart.restart.shared.ui.Truss

class DistanceViewModel : EpoxyModel<TextView>() {

    var distance: String = "1km"

    override fun getDefaultLayout(): Int = R.layout.distance_cell

    override fun bind(view: TextView?) {
        super.bind(view)

        val view = view ?: return
        val resources = view.resources ?: return

        val text = Truss().format(
            TextAppearanceSpan(view.context, R.style.Distance),
            resources.getString(R.string.listing_distance_cell),
            distance
        ).build()

        view.text = text
    }
}
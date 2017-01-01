package com.restart.restart.listing.ui.view.viewmodel

import android.support.v7.widget.StaggeredGridLayoutManager
import android.text.style.TextAppearanceSpan
import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.restart.restart.R
import com.restart.restart.shared.ui.Truss

class DistanceFilterViewModel : EpoxyModelWithHolder<DistanceFilterViewModel.ViewHolder>() {

    override fun createNewHolder(): DistanceFilterViewModel.ViewHolder = DistanceFilterViewModel.ViewHolder()

    var distance: String = "1km"

    override fun getDefaultLayout(): Int = R.layout.distance_filter_cell

    override fun bind(holder: DistanceFilterViewModel.ViewHolder?) {
        super.bind(holder)

        val distanceView = holder?.distance ?: return
        configureDistanceText(distanceView)

        val layoutParams = holder?.content?.layoutParams as? StaggeredGridLayoutManager.LayoutParams
        layoutParams?.isFullSpan = true
    }

    private fun configureDistanceText(distanceView: TextView) {
        val resources = distanceView.resources ?: return

        val text = Truss().format(
            TextAppearanceSpan(distanceView.context, R.style.Distance),
            resources.getString(R.string.listing_distance_cell),
            distance
        ).build()

        distanceView.text = text
    }

    class ViewHolder : EpoxyHolder() {

        var content: View? = null
        var distance: TextView? = null

        override fun bindView(itemView: View?) {
            content = itemView
            distance = itemView?.findViewById(R.id.distance) as TextView?
        }
    }
}
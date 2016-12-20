package com.restart.restart.listing.ui.view.viewmodel

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.restart.restart.R
import com.restart.restart.shared.RestartApplication

class AdViewModel(
    val title: String,
    val platform: String,
    val price: String,
    val previewUrl: String) : EpoxyModelWithHolder<AdViewModel.ViewHolder>() {

    override fun getDefaultLayout(): Int = R.layout.ad_cell
    override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int): Int = 2
    override fun createNewHolder(): ViewHolder = ViewHolder()

    override fun bind(holder: ViewHolder?) {
        super.bind(holder)
        val preview = holder?.preview ?: return

        holder?.title?.text = title
        holder?.platform?.text = platform
        holder?.price?.text = price
        RestartApplication.picasso
            ?.load(previewUrl)
            ?.fit()
            ?.into(preview)
    }

    class ViewHolder : EpoxyHolder() {

        var title: TextView? = null
        var platform: TextView? = null
        var price: TextView? = null
        var preview: ImageView? = null

        override fun bindView(itemView: View?) {
            title = itemView?.findViewById(R.id.title) as TextView?
            platform = itemView?.findViewById(R.id.platform) as TextView?
            price = itemView?.findViewById(R.id.price) as TextView?
            preview = itemView?.findViewById(R.id.preview) as ImageView?
        }

    }
}
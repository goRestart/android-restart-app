package com.restart.restart.listing.ui.view.viewmodel

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.restart.restart.R
import com.restart.restart.product.ui.ProductActivity
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

class ProductViewModel(
    val id: String,
    val title: String,
    val platform: String,
    val price: String,
    val previewUrl: String,
    val context: Context) : EpoxyModelWithHolder<ProductViewModel.ViewHolder>() {

    override fun getDefaultLayout(): Int = R.layout.product_cell
    override fun createNewHolder(): ViewHolder = ViewHolder()

    override fun bind(holder: ViewHolder?) {
        super.bind(holder)
        val preview = holder?.preview ?: return

        val cornerRadius = preview.resources.getDimension(R.dimen.listing_ad_cell_image_corner_radius).toInt()
        holder.title?.text = title
        holder.platform?.text = platform
        holder.price?.text = price
        holder.content?.setOnClickListener({
            val intent = ProductActivity.intent(context, id)
            val transitionName = context.getString(R.string.product_image_transition_name)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                context as Activity,
                holder.preview,
                transitionName)
            ActivityCompat.startActivity(context, intent, options.toBundle())
        })

        Picasso.with(context)
            .load(previewUrl)
            .transform(RoundedCornersTransformation(cornerRadius, 0))
            .fit()
            .centerCrop()
            .into(preview)

        configureSizes(holder)
    }

    private fun configureSizes(viewHolder: ViewHolder?) {
        val params = viewHolder?.preview?.layoutParams
        val imageSize = Resources.getSystem().displayMetrics.widthPixels / 2
        params?.height = imageSize
        params?.width = imageSize
        viewHolder?.preview?.layoutParams = params
        viewHolder?.preview?.postInvalidate()
    }

    class ViewHolder : EpoxyHolder() {

        var title: TextView? = null
        var platform: TextView? = null
        var price: TextView? = null
        var preview: ImageView? = null
        var content: View? = null

        override fun bindView(itemView: View?) {
            title = itemView?.findViewById(R.id.title) as TextView?
            platform = itemView?.findViewById(R.id.platform) as TextView?
            price = itemView?.findViewById(R.id.price) as TextView?
            preview = itemView?.findViewById(R.id.preview) as ImageView?
            content = itemView
        }
    }
}
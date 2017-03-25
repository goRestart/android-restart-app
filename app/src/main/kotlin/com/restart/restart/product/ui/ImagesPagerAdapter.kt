package com.restart.restart.product.ui

import android.app.Activity
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.restart.restart.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import java.util.*


class ImagesPagerAdapter(
    private val activity: Activity,
    private val layoutInflater: LayoutInflater
) : PagerAdapter() {

    var imageUrls: List<String> = ArrayList()

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val itemView = layoutInflater.inflate(R.layout.view_pager_image, container, false)
        val imageView = itemView.findViewById(R.id.view_pager_image) as ImageView

        itemView.tag = position
        imageView.tag = position

        if (position == 0) {
            configureTransition(imageView)
        }

        val cornerRadius = activity.resources.getDimension(R.dimen.product_image_corner_radius).toInt()
        Picasso.with(activity)
            .load(imageUrls[position])
            .fit()
            .centerCrop()
            .transform(RoundedCornersTransformation(cornerRadius, 0))
            .into(imageView, object : Callback {
                override fun onSuccess() = ActivityCompat.startPostponedEnterTransition(activity)
                override fun onError() = ActivityCompat.startPostponedEnterTransition(activity)
            })

        container?.addView(itemView)

        return imageView
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view?.tag == (`object` as View).tag
    }

    override fun getCount(): Int {
        return imageUrls.size
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container?.removeView(`object` as View)
    }

    private fun configureTransition(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.transitionName = activity.resources.getString(R.string.product_image_transition_name)
        }
    }
}
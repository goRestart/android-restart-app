package com.restart.restart.product.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.restart.restart.R
import com.restart.restart.product.ui.viewmodel.ProductDetailViewModel
import com.restart.restart.shared.ui.RestartActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.product.*
import java.util.*

class ProductActivity : RestartActivity(), ProductPresenter.View {

    companion object {
        private val PRODUCT_ID = "product_id"

        fun intent(context: Context, productId: String): Intent {
            val intent = Intent(context, ProductActivity::class.java)
            intent.putExtra(PRODUCT_ID, productId)
            return intent
        }
    }

    private var presenter: ProductPresenter? = null
    private var pagerAdapter: ImagesPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        ActivityCompat.postponeEnterTransition(this)
        setContentView(R.layout.product)
        configureImagesPager()
        configurePreview()
        presenter?.onStart()
    }

    override fun showProduct(product: ProductDetailViewModel) {
        pagerAdapter?.imageUrls = product.previewUrls
        pagerAdapter?.notifyDataSetChanged()
        price.text = product.price
        platform.text = product.platform
        favorite.isSelected = product.isFavorite
        wishlist.isSelected = product.isInWishlist
        product_title.text = product.title
        description.text = product.description
        time_and_visits.text = product.publishingTimeAndVisitsCount
        seller_name.text = product.sellerName
        seller_products_count.text = product.sellerProductsCount
    }

    override fun showError() {

    }

    private fun configureImagesPager() {
        view_pager.adapter = pagerAdapter
    }

    private fun configurePreview() {
        val horizontalMargin = 2 * resources.getDimension(R.dimen.product_content_padding_horizontal)
        val params = view_pager.layoutParams
        params.height = Resources.getSystem().displayMetrics.widthPixels - horizontalMargin.toInt()
        view_pager.layoutParams = params
    }

    private fun inject() {
        presenter = dependencyContainer!!.product.getPresenter(
            this,
            intent.extras.getString(PRODUCT_ID)
        )
        pagerAdapter = ImagesPagerAdapter(this, LayoutInflater.from(this))
    }
}

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

        Picasso.with(activity)
            .load(imageUrls[position])
            .fit()
            .centerCrop()
            .transform(RoundedCornersTransformation(8, 0))
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
package com.restart.restart.product.ui

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.view.LayoutInflater
import com.google.android.gms.maps.MapsInitializer
import com.restart.restart.R
import com.restart.restart.product.ui.viewmodel.ProductDetailViewModel
import com.restart.restart.shared.ui.RestartActivity
import kotlinx.android.synthetic.main.product.*

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
        map.onCreate(savedInstanceState)
        MapsInitializer.initialize(this)
        presenter?.onStart()
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        map.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        map.onLowMemory()
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
        val pageMargin = resources.getDimension(R.dimen.product_image_page_margin).toInt()
        view_pager.pageMargin = pageMargin
        indicator.install(view_pager)
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
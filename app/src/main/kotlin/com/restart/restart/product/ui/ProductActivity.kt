package com.restart.restart.product.ui

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import com.restart.restart.R
import com.restart.restart.product.ui.viewmodel.ProductDetailViewModel
import com.restart.restart.shared.ui.RestartActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.postponeEnterTransition(this)
        setContentView(R.layout.product)
        configurePreview()
        inject()
        presenter?.onStart()
    }

    override fun showProduct(product: ProductDetailViewModel) {
        Picasso.with(this)
            .load(product.previewUrl)
            .fit()
            .centerCrop()
            .transform(RoundedCornersTransformation(8, 0))
            .into(preview, object : Callback {
                override fun onSuccess() = ActivityCompat.startPostponedEnterTransition(this@ProductActivity)
                override fun onError() = ActivityCompat.startPostponedEnterTransition(this@ProductActivity)
            })

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

    private fun configurePreview() {
        val horizontalMargin = 2 * resources.getDimension(R.dimen.product_content_padding_horizontal)
        val params = preview.layoutParams
        params.height = Resources.getSystem().displayMetrics.widthPixels - horizontalMargin.toInt()
        preview.layoutParams = params
    }

    private fun inject() {
        presenter = dependencyContainer!!.product.getPresenter(
            this,
            intent.extras.getString(PRODUCT_ID)
        )
    }
}
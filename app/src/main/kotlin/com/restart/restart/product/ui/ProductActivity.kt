package com.restart.restart.product.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.restart.restart.R
import com.restart.restart.product.ui.viewmodel.ProductDetailViewModel
import com.restart.restart.shared.ui.RestartActivity
import com.squareup.picasso.Picasso
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
        setContentView(R.layout.product)
        inject()
        presenter?.onStart()
    }

    private fun inject() {
        presenter = dependencyContainer!!.product.getPresenter(
            this,
            intent.extras.getString(PRODUCT_ID)
        )
    }

    override fun showProduct(product: ProductDetailViewModel) {
        Picasso.with(this)
            .load(product.previewUrl)
            .into(preview)

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
}
package com.restart.restart.product.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.restart.restart.R
import com.restart.restart.product.ui.viewmodel.ProductDetailViewModel
import com.restart.restart.shared.ui.RestartActivity

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

    }

    override fun showError() {

    }
}
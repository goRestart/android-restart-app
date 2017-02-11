package com.restart.restart.product.ui

import android.os.Bundle
import com.restart.restart.shared.ui.RestartActivity

class ProductActivity : RestartActivity(), ProductPresenter.View {

    private var presenter: ProductPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    private fun inject() {
        presenter = dependencyContainer!!.product.getPresenter(this)
    }

    override fun showProduct() {

    }

    override fun showError() {
        
    }
}
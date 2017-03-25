package com.restart.restart.listing.di

import android.content.Context
import com.restart.restart.domain.usecase.GetProducts
import com.restart.restart.listing.ui.ListingPresenter
import com.restart.restart.listing.ui.view.viewmodel.ProductViewModelMapper
import com.restart.restart.shared.di.DependencyContainer
import java.lang.ref.WeakReference

class ListingContainer(
    private val dependencyContainer: DependencyContainer
) {

    fun getPresenter(view: ListingPresenter.View, context: Context): ListingPresenter {
        return ListingPresenter(
            WeakReference(view),
            getProducts,
            getProductViewModelMapper(context)
        )
    }

    fun getProductViewModelMapper(context: Context): ProductViewModelMapper {
        return ProductViewModelMapper(
            dependencyContainer.platformViewModelMapper,
            dependencyContainer.priceViewModelMapper,
            context
        )
    }

    val getProducts: GetProducts
        get() = GetProducts(dependencyContainer.productStorage)
}
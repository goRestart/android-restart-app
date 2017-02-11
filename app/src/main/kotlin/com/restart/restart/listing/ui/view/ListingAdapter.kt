package com.restart.restart.listing.ui.view

import com.airbnb.epoxy.EpoxyAdapter
import com.restart.restart.listing.ui.view.viewmodel.DistanceFilterViewModel
import com.restart.restart.listing.ui.view.viewmodel.ProductViewModel
import com.restart.restart.listing.ui.view.viewmodel.SearchViewModel
import com.restart.restart.listing.ui.view.viewmodel.TitleViewModel

class ListingAdapter(val productViewModelFactory: ProductViewModel.Factory) : EpoxyAdapter() {
    init {
        addModels(
            TitleViewModel(),
            SearchViewModel(),
            DistanceFilterViewModel()
        )
        addModels(createProductViewModels(100))
    }

    private fun createProductViewModels(productsCount: Int): List<ProductViewModel> {
        val adViewModelsPool = arrayOf(
            productViewModelFactory.create("Watch Dogs 2 Deluxe edition", "PS4", "55€",
                "http://www.gamestop.com/common/images/lbox/127189b.jpg"),
            productViewModelFactory.create("Nintendo Classic mini", "CONSOLA", "90€",
                "http://cdn02.nintendo-europe.com/media/images/10_share_images/others_3/H2x1_NintendoClassicMiniNES_Announcement.jpg"),
            productViewModelFactory.create("No man’s sky", "PC", "35€", "http://s2.n4g.com/news/1937839_0.jpg"))

        return (0..productsCount).map { i -> adViewModelsPool[i % adViewModelsPool.size] }
    }
}
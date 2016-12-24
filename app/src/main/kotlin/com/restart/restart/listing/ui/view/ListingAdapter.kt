package com.restart.restart.listing.ui.view

import com.airbnb.epoxy.EpoxyAdapter
import com.restart.restart.listing.ui.view.viewmodel.*

class ListingAdapter(adViewModelFactory: AdViewModel.Factory) : EpoxyAdapter() {
    init {
        addModels(
            TitleViewModel(),
            SearchViewModel(),
            DistanceViewModel(),
            FilterViewModel(),
            adViewModelFactory.create("Watch Dogs 2 Deluxe edition", "PS4", "55€",
                "http://www.gamestop.com/common/images/lbox/127189b.jpg"),
            adViewModelFactory.create("Nintendo Classic mini", "CONSOLA", "90€",
                "http://cdn02.nintendo-europe.com/media/images/10_share_images/others_3/H2x1_NintendoClassicMiniNES_Announcement.jpg"),
            adViewModelFactory.create("No man’s sky", "PC", "35€", "http://s2.n4g.com/news/1937839_0.jpg"),
            adViewModelFactory.create("Watch Dogs 2 Deluxe edition", "PS4", "55€",
                "http://www.gamestop.com/common/images/lbox/127189b.jpg"),
            adViewModelFactory.create("Nintendo Classic mini", "CONSOLA", "90€",
                "http://cdn02.nintendo-europe.com/media/images/10_share_images/others_3/H2x1_NintendoClassicMiniNES_Announcement.jpg"),
            adViewModelFactory.create("No man’s sky", "PC", "35€", "http://s2.n4g.com/news/1937839_0.jpg")
        )
    }
}
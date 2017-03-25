package com.restart.restart.storage

import android.location.Location
import com.restart.restart.domain.model.Platform
import com.restart.restart.domain.model.Product
import com.restart.restart.domain.model.ProductDetail
import com.restart.restart.domain.model.Seller
import com.restart.restart.shared.extensions.collections.randomListOf

class ProductStorage {
    private val products: Map<String, ProductDetail> = mapOf(
        Pair(
            "ID 1",
            ProductDetail(
                "ID 1",
                "Watch Dogs 2 Deluxe edition",
                "Consola nueva, muy entretenida. La vendo por que necesito el dinero. La volveré a comprar en un futuro.",
                Platform.PS4,
                5500,
                listOf(
                    "https://ubistatic9-a.akamaihd.net/ubicomstatic/en-US/global/media/wd-media-ss01_2-THUMB-712x712_Desktop_254766.jpg",
                    "https://i.ytimg.com/vi/hEM_YBvfVlo/maxresdefault.jpg",
                    "http://pre14.deviantart.net/6bfb/th/pre/i/2016/196/2/1/watch_dogs_2__ps4_cover_edited__by_hasannokicaprile1992-daa2jh9.jpg"
                ),
                false,
                false,
                0,
                160,
                Location(""),
                Seller("Alex Bailón", 4)
            )
        ),
        Pair(
            "ID 2",
            ProductDetail(
                "ID 2",
                "Nintendo Classic mini",
                "Consola nueva, muy entretenida. La vendo por que necesito el dinero. La volveré a comprar en un futuro.",
                Platform.PC,
                9000,
                listOf(
                    "http://cdn02.nintendo-europe.com/media/images/10_share_images/others_3/H2x1_NintendoClassicMiniNES_Announcement.jpg",
                    "http://cdn.images.dailystar.co.uk/dynamic/184/photos/826000/620x/Nintendo-NES-Classic-Mini-Stock-Update-589565.jpg",
                    "http://cdn.newsapi.com.au/image/v1/external?url=http%3A%2F%2Fm.wsj.net%2Fvideo%2F20161117%2F111716ptechnes2%2F111716ptechnes2_1280x720.jpg&width=650&api_key=kq7wnrk4eun47vz9c5xuj3mc"
                ),
                false,
                false,
                0,
                160,
                Location(""),
                Seller("isiriszgz", 1)
            )
        ),
        Pair(
            "ID 3",
            ProductDetail(
                "ID 3",
                "No man’s sky",
                "Consola nueva, muy entretenida. La vendo por que necesito el dinero. La volveré a comprar en un futuro.",
                Platform.PS4,
                3500,
                listOf(
                    "http://cdn.mos.cms.futurecdn.net/vYVZabrC5BZb5tbEJNGfuU.jpeg",
                    "https://www.primagames.com/media/images/news/3016262-nomanssky_gs3.jpg",
                    "http://i5.walmartimages.ca/images/Large/147/3_3/999999-711719501473_3.jpg"
                ),
                false,
                false,
                0,
                3200,
                Location(""),
                Seller("Óscar Bailón", 10)
            )
        )
    )


    fun getAll(): List<Product> {
        return randomListOf(100,
            Product("ID 1", "Watch Dogs 2 Deluxe edition", Platform.PS4, 5500,
                "https://ubistatic9-a.akamaihd.net/ubicomstatic/en-US/global/media/wd-media-ss01_2-THUMB-712x712_Desktop_254766.jpg"),
            Product("ID 2", "Nintendo Classic mini", Platform.PC, 9000,
                "http://cdn02.nintendo-europe.com/media/images/10_share_images/others_3/H2x1_NintendoClassicMiniNES_Announcement.jpg"),
            Product("ID 3", "No man’s sky", Platform.PC, 3500, "http://cdn.mos.cms.futurecdn.net/vYVZabrC5BZb5tbEJNGfuU.jpeg")
        )
    }

    fun getDetail(id: String): ProductDetail? {
        return products[id]
    }

}
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
                    "http://www.gamestop.com/common/images/lbox/127189b.jpg",
                    "http://www.gamestop.com/common/images/lbox/127189b.jpg",
                    "http://www.gamestop.com/common/images/lbox/127189b.jpg"
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
                    "http://cdn02.nintendo-europe" +
                        ".com/media/images/10_share_images/others_3/H2x1_NintendoClassicMiniNES_Announcement.jpg",
                    "http://cdn02.nintendo-europe" +
                        ".com/media/images/10_share_images/others_3/H2x1_NintendoClassicMiniNES_Announcement.jpg",
                    "http://cdn02.nintendo-europe" +
                        ".com/media/images/10_share_images/others_3/H2x1_NintendoClassicMiniNES_Announcement.jpg"
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
                    "http://s2.n4g.com/news/1937839_0.jpg",
                    "http://s2.n4g.com/news/1937839_0.jpg",
                    "http://s2.n4g.com/news/1937839_0.jpg"
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
                "http://www.gamestop.com/common/images/lbox/127189b.jpg"),
            Product("ID 2", "Nintendo Classic mini", Platform.PC, 9000,
                "http://cdn02.nintendo-europe.com/media/images/10_share_images/others_3/H2x1_NintendoClassicMiniNES_Announcement.jpg"),
            Product("ID 3", "No man’s sky", Platform.PC, 3500, "http://s2.n4g.com/news/1937839_0.jpg")
        )
    }

    fun getDetail(id: String): ProductDetail? {
        return products[id]
    }

}
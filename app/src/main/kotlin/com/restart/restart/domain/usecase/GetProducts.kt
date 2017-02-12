package com.restart.restart.domain.usecase

import com.restart.restart.shared.extensions.collections.randomListOf
import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.task

class GetProducts {
    fun execute(): Promise<List<Product>, Exception> =
        task {
            randomListOf(100,
                Product("Watch Dogs 2 Deluxe edition", Platform.PS4, 5500,
                    "http://www.gamestop.com/common/images/lbox/127189b.jpg"),
                Product("Nintendo Classic mini", Platform.PC, 9000,
                    "http://cdn02.nintendo-europe.com/media/images/10_share_images/others_3/H2x1_NintendoClassicMiniNES_Announcement.jpg"),
                Product("No man’s sky", Platform.PC, 3500, "http://s2.n4g.com/news/1937839_0.jpg")
            )
        }
}

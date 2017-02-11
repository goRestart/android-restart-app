package com.restart.restart.listing.domain

import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.task

class GetProducts {

    fun execute(): Promise<List<Product>, Exception> {
        return task {
            listOf(
                Product("Watch Dogs 2 Deluxe edition", Platform.PS4, 5500,
                    "http://www.gamestop.com/common/images/lbox/127189b.jpg")
            )
        }
    }
}

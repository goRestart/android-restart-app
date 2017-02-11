package com.restart.restart.product.domain

import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.task

class GetProduct {
    fun execute(id: String): Promise<ProductDetail, Exception> =
        task {
            ProductDetail("")
        }
}
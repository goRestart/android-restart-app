package com.restart.restart.domain.usecase

import com.restart.restart.domain.model.ProductDetail
import com.restart.restart.product.storage.ProductStorage
import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.task

class GetProduct(
    private val storage: ProductStorage
) {
    fun execute(id: String): Promise<ProductDetail, Exception> =
        task {
            storage.get(id) ?: throw NotFoundException()
        }

    class NotFoundException : Exception()
}
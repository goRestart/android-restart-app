package com.restart.restart.domain.usecase

import com.restart.restart.domain.model.Product
import com.restart.restart.storage.ProductStorage
import nl.komponents.kovenant.Promise
import nl.komponents.kovenant.task

class GetProducts(
    private val storage: ProductStorage
) {
    fun execute(): Promise<List<Product>, Exception> =
        task {
            storage.getAll()
        }
}

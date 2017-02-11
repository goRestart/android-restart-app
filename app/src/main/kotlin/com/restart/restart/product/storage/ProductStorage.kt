package com.restart.restart.product.storage

import com.restart.restart.product.domain.ProductDetail
import java.util.*

class ProductStorage {
    private val products: Map<String, ProductDetail> = HashMap()

    fun get(id: String): ProductDetail? {
        return products[id]
    }

}
package com.restart.restart.shared.extensions.collections

fun <T> randomListOf(count: Int, vararg elements: T): List<T> =
    (1..count).map { elements.randomElement() }



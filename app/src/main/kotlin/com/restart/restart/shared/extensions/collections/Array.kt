package com.restart.restart.shared.extensions.collections

import java.util.*

fun <T> Array<T>.randomElement(): T = this[Random().nextInt(size)]

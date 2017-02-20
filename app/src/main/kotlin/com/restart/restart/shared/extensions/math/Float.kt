package com.restart.restart.shared.extensions.math

fun Float.decimal(): Float {
    return this - Math.floor(this.toDouble()).toFloat()
}
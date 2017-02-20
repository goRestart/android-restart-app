package com.restart.restart.shared.extensions.ui

import android.util.DisplayMetrics
import android.view.View

fun View.dpToPixels(dp: Int): Int {
    val displayMetrics = context.resources.displayMetrics
    val px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    return px
}
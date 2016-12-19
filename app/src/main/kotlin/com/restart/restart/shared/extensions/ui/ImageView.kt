package com.restart.restart.shared.extensions.ui

import android.support.annotation.DrawableRes
import android.widget.ImageView

fun ImageView.setImageDrawable(@DrawableRes drawableRes: Int) {
    setImageDrawable(context.getDrawable(drawableRes))
}
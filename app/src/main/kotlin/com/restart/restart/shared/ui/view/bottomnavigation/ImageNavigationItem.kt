package com.restart.restart.shared.ui.view.bottomnavigation

import android.content.Context
import android.support.annotation.DrawableRes
import android.view.View
import android.widget.ImageView
import com.restart.restart.shared.extensions.ui.setImageDrawable

class ImageNavigationItem(context: Context, @DrawableRes val drawableRes: Int) : NavigationItem {

    private val imageView: ImageView

    init {
        imageView = ImageView(context)
        imageView.setImageDrawable(drawableRes)
    }

    override fun getView(): View = imageView
}

package com.restart.restart.ui.view.bottomnavigation

import android.content.Context
import android.support.annotation.DrawableRes
import android.view.View
import android.widget.ImageView
import java.util.logging.Logger

class ImageNavigationItem(val context: Context, @DrawableRes val drawableRes: Int) : NavigationItem {

    private val imageView: ImageView

    init {
        imageView = ImageView(context)
        imageView.setImageDrawable(drawableRes)
        imageView.setOnClickListener {
            Logger.getLogger("asd").warning("ASD")
        }
    }

    override fun getView(): View = imageView
}

private fun ImageView.setImageDrawable(@DrawableRes drawableRes: Int) {
    setImageDrawable(context.getDrawable(drawableRes))
}

package com.restart.restart.shared

import android.app.Application
import com.squareup.picasso.Picasso

class RestartApplication : Application() {

    companion object {
        var picasso: Picasso? = null
    }

    override fun onCreate() {
        super.onCreate()
        picasso = Picasso.with(this)
    }
}
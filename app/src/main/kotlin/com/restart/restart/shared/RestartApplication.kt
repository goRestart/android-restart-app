package com.restart.restart.shared

import android.app.Application
import com.restart.restart.R
import com.restart.restart.shared.di.DependencyContainer
import nl.komponents.kovenant.android.startKovenant
import nl.komponents.kovenant.android.stopKovenant
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class RestartApplication : Application() {

    val container: DependencyContainer = DependencyContainer()

    override fun onCreate() {
        super.onCreate()
        startKovenant()
        startCalligraphy()
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKovenant()
    }

    private fun startCalligraphy() {
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
            .setDefaultFontPath("fonts/OpenSans-Regular.ttf")
            .setFontAttrId(R.attr.fontPath)
            .build()
        )
    }
}
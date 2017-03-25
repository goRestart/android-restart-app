package com.restart.restart.shared

import android.app.Application
import com.restart.restart.shared.di.DependencyContainer
import nl.komponents.kovenant.android.startKovenant
import nl.komponents.kovenant.android.stopKovenant

class RestartApplication : Application() {

    val container: DependencyContainer = DependencyContainer()

    override fun onCreate() {
        super.onCreate()
        startKovenant()
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKovenant()
    }

}
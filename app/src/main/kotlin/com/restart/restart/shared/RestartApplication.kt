package com.restart.restart.shared

import android.app.Application
import com.restart.restart.shared.di.DependencyContainer

class RestartApplication : Application() {

    val container: DependencyContainer = DependencyContainer()

}
package com.restart.restart.shared

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.android.activityScope
import com.github.salomonbrys.kodein.lazy

class RestartApplication : Application(), KodeinAware {

    override val kodein by Kodein.lazy {}

    override fun onCreate() {
        registerActivityLifecycleCallbacks(activityScope.lifecycleManager)
    }
}
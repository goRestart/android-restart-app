package com.restart.restart.shared.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.restart.restart.shared.RestartApplication
import com.restart.restart.shared.di.DependencyContainer

open class RestartFragment: Fragment() {

    var dependencyContainer: DependencyContainer? = null

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val application = activity.application as RestartApplication
        this.dependencyContainer = application.container
    }
}
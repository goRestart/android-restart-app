package com.restart.restart.shared.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.restart.restart.shared.RestartApplication
import com.restart.restart.shared.di.DependencyContainer

open class RestartActivity : AppCompatActivity() {

    var dependencyContainer: DependencyContainer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val application = application as RestartApplication
        this.dependencyContainer = application.container
    }
}
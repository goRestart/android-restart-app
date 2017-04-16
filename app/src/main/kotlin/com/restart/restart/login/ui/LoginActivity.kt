package com.restart.restart.login.ui

import android.os.Bundle
import com.restart.restart.R
import com.restart.restart.shared.ui.RestartActivity

class LoginActivity : RestartActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
    }
}
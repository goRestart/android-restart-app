package com.restart.restart.login.ui

import android.os.Bundle
import com.restart.restart.R
import com.restart.restart.shared.ui.RestartActivity
import kotlinx.android.synthetic.main.login.*

class LoginActivity : RestartActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.action_bar_back_icon)
        toolbar.navigationIcon = resources.getDrawable(R.drawable.action_bar_back_icon)
    }
}
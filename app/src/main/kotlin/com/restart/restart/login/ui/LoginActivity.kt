package com.restart.restart.login.ui

import android.os.Bundle
import com.restart.restart.R
import com.restart.restart.shared.extensions.ui.textWatcher
import com.restart.restart.shared.ui.RestartActivity
import kotlinx.android.synthetic.main.login.*

class LoginActivity : RestartActivity(), LoginPresenter.View {

    private var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        setContentView(R.layout.login)
        configureActionBar()
        username.textWatcher {
            afterTextChanged { username -> presenter?.didUpdateUsername(username.toString()) }
        }
        password.textWatcher {
            afterTextChanged { password -> presenter?.didUpdatePassword(password.toString()) }
        }
    }

    override fun showLoginButtonEnabled(isEnabled: Boolean) {
        login.isEnabled = isEnabled
    }

    override fun showError() {

    }

    private fun inject() {
        presenter = dependencyContainer!!.login.getPresenter(this)
    }

    private fun configureActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.action_bar_back_icon)
        toolbar.navigationIcon = resources.getDrawable(R.drawable.action_bar_back_icon)
    }
}
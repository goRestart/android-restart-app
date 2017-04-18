package com.restart.restart.login.ui

import java.lang.ref.WeakReference

class LoginPresenter(
    private val view: WeakReference<View>
) {

    private var username: String = ""
    private var password: String = ""

    fun didUpdateUsername(username: String) {
        this.username = username
        updateLoginButton()
    }

    fun didUpdatePassword(password: String) {
        this.password = password
        updateLoginButton()
    }

    fun didSelectToClose() {
        view.get()?.close()
    }

    private fun updateLoginButton() {
        val isEnabled = username.isNotEmpty() && password.isNotEmpty()
        view.get()?.showLoginButtonEnabled(isEnabled)
    }

    interface View {
        fun showLoginButtonEnabled(isEnabled: Boolean)
        fun showError()
        fun close()
    }
}
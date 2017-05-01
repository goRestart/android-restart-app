package com.restart.restart.login.ui

import co.metalab.asyncawait.async
import com.restart.restart.login.domain.model.Credentials
import com.restart.restart.login.domain.usecase.Login
import com.restart.restart.shared.extensions.funktionale.onLeft
import com.restart.restart.shared.extensions.funktionale.onRight
import java.lang.ref.WeakReference

class LoginPresenter(
    private val view: WeakReference<View>,
    private val login: Login
) {

    private var username: String = ""
    private var password: String = ""

    fun onUsernameUpdated(username: String) {
        this.username = username
        updateLoginButton()
    }

    fun onPasswordUpdated(password: String) {
        this.password = password
        updateLoginButton()
    }

    fun onLoginSelected() = async {
        val credentials = Credentials(username, password)
        val result = await { login.execute(credentials) }
        result
            .onLeft { view.get()?.close() }
            .onRight {  }
    }

    fun onCloseSelected() {
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
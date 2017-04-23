package com.restart.restart.login.ui

import com.restart.restart.login.domain.model.Credentials
import com.restart.restart.login.domain.usecase.Login
import com.restart.restart.shared.domain.UseCaseExecutor
import java.lang.ref.WeakReference

class LoginPresenter(
    private val view: WeakReference<View>,
    private val login: Login,
    private val executor: UseCaseExecutor
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

    fun didSelectToLogin() {
        val credentials = Credentials(username, password)
        executor.execute(login, credentials)
            .onSuccess { }
            .onError { }
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
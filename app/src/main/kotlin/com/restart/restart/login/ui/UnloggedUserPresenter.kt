package com.restart.restart.login.ui

import java.lang.ref.WeakReference

class UnloggedUserPresenter(
    private val view: WeakReference<UnloggedUserPresenter.View>
) {

    fun onLoginSelected() {
        view.get()?.navigateToLogin()
    }

    interface View {
        fun navigateToLogin()
    }
}
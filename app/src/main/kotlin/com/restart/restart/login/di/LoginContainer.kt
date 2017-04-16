package com.restart.restart.login.di

import com.restart.restart.login.ui.LoginPresenter
import com.restart.restart.shared.di.DependencyContainer
import java.lang.ref.WeakReference

class LoginContainer(
    private val dependencyContainer: DependencyContainer
) {

    fun getPresenter(view: LoginPresenter.View): LoginPresenter {
        return LoginPresenter(
            WeakReference(view)
        )
    }
}
package com.restart.restart.login.di

import com.restart.restart.login.data.LoginDataSource
import com.restart.restart.login.data.SessionTokenStorage
import com.restart.restart.login.domain.model.Session
import com.restart.restart.login.domain.usecase.Login
import com.restart.restart.login.ui.LoginPresenter
import com.restart.restart.login.ui.UnloggedUserPresenter
import com.restart.restart.shared.di.DependencyContainer
import java.lang.ref.WeakReference

open class LoginContainer(
    private val dependencyContainer: DependencyContainer
) {
    open fun getPresenter(view: LoginPresenter.View): LoginPresenter {
        return LoginPresenter(
            WeakReference(view),
            login,
            dependencyContainer.useCaseExecutor
        )
    }

    open fun getUnloggedUserPresenter(view: UnloggedUserPresenter.View): UnloggedUserPresenter {
        return UnloggedUserPresenter(
            WeakReference(view)
        )
    }

    open val login: Login
        get() = Login(session)

    open val session: Session
        get() = Session(
            loginDataSource,
            sessionTokenStorage
        )

    open val loginDataSource: LoginDataSource
        get() = LoginDataSource()

    open val sessionTokenStorage: SessionTokenStorage
        get() = SessionTokenStorage(dependencyContainer.sharedPreferences)
}
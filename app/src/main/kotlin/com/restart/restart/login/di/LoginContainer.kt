package com.restart.restart.login.di

import com.restart.restart.login.data.LoginDataSource
import com.restart.restart.login.data.SessionTokenStorage
import com.restart.restart.login.domain.model.Session
import com.restart.restart.login.domain.model.SessionBroadcast
import com.restart.restart.login.domain.usecase.*
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
            login
        )
    }

    open fun getUnloggedUserPresenter(view: UnloggedUserPresenter.View): UnloggedUserPresenter {
        return UnloggedUserPresenter(
            WeakReference(view)
        )
    }

    open val login: Login
        get() = Login(session)

    open val logout: Logout
        get() = Logout(session)

    open val isLoggedIn: IsLoggedIn
        get() = IsLoggedIn(session)

    open val subscribeToSession: SubscribeToSession
        get() = SubscribeToSession(session)

    open val unsubscribeFromSession: UnsubscribeFromSession
        get() = UnsubscribeFromSession(session)

    open val session: Session
        get() = Session(
            loginDataSource,
            sessionTokenStorage,
            sessionBroadcast
        )

    open val loginDataSource: LoginDataSource
        get() = LoginDataSource()

    open val sessionTokenStorage: SessionTokenStorage
        get() = SessionTokenStorage(dependencyContainer.sharedPreferences)

    open val sessionBroadcast: SessionBroadcast by lazy {
        SessionBroadcast()
    }
}
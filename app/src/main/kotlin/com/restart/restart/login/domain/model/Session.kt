package com.restart.restart.login.domain.model

import com.restart.restart.login.data.LoginDataSource
import com.restart.restart.login.data.SessionTokenStorage
import org.funktionale.either.Either

class Session(
    private val dataSource: LoginDataSource,
    private val tokenStorage: SessionTokenStorage,
    private val broadcast: SessionBroadcast
) {
    val isLoggedIn: Boolean
        get() = tokenStorage.hasSessionToken

    fun login(credentials: Credentials): Either<LoginError, Unit> {
        val result = dataSource.login(credentials)
        return when (result) {
            is Either.Right -> {
                tokenStorage.store(result.right().get())
                broadcast.notifyUserLoggedIn()
                Either.right(Unit)
            }
            is Either.Left -> Either.left(result.left().get())
        }
    }

    fun logout() {
        tokenStorage.clean()
        broadcast.notifyUserLoggedOut()
    }

    fun subscribe(listener: SessionBroadcast.Listener) {
        broadcast.subscribe(listener)
    }

    fun unsubscribe(listener: SessionBroadcast.Listener) {
        broadcast.unsubscribe(listener)
    }
}
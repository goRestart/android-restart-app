package com.restart.restart.login.domain.model

import com.restart.restart.login.data.LoginDataSource
import com.restart.restart.login.data.SessionTokenStorage
import org.funktionale.either.Either

class Session(
    val dataSource: LoginDataSource,
    val tokenStorage: SessionTokenStorage
) {
    val isLoggedIn: Boolean
        get() = tokenStorage.hasSessionToken

    fun login(credentials: Credentials): Either<LoginError, Unit> {
        val result = dataSource.login(credentials)
        return when (result) {
            is Either.Right -> {
                tokenStorage.store(result.right().get())
                Either.right(Unit)
            }
            is Either.Left -> Either.right(Unit)
        }
    }
}
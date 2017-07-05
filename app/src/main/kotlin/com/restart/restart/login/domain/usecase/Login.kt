package com.restart.restart.login.domain.usecase

import com.restart.restart.login.domain.model.Credentials
import com.restart.restart.login.domain.model.LoginError
import com.restart.restart.login.domain.model.Session
import org.funktionale.either.Either

class Login(
    private val session: Session
) {
    fun execute(credentials: Credentials): Either<LoginError, Unit> {
        return session.login(credentials)
    }
}
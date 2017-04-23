package com.restart.restart.login.domain.usecase

import com.restart.restart.login.domain.model.Credentials
import com.restart.restart.login.domain.model.LoginError
import com.restart.restart.login.domain.model.Session
import com.restart.restart.shared.domain.UseCase
import org.funktionale.either.Either

class Login(
    private val session: Session
) : UseCase<Credentials, Unit, LoginError> {
    override fun execute(input: Credentials): Either<LoginError, Unit> {
        return session.login(input)
    }
}
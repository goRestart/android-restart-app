package com.restart.restart.login.data

import com.restart.restart.login.domain.model.Credentials
import com.restart.restart.login.domain.model.LoginError
import org.funktionale.either.Either

class LoginDataSource {
    fun login(credentials: Credentials): Either<LoginError, String> {
        if (credentials.username == "Sergio" && credentials.password == "12345678") {
            return Either.right("session_token")
        } else {
            return Either.left(LoginError.InvalidCredentials)
        }
    }
}
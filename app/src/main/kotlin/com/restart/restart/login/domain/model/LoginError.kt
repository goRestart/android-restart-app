package com.restart.restart.login.domain.model

sealed class LoginError {
    object InvalidCredentials : LoginError()
    object Unknown : LoginError()
}
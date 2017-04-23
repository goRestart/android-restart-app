package com.restart.restart.login.domain.usecase

import com.restart.restart.login.domain.model.Session
import com.restart.restart.shared.domain.UseCase

class IsLoggedIn(
    private val session: Session
) : UseCase.WithNoInputNoError<Boolean>() {
    override fun executeNoInputNoError(): Boolean {
        return session.isLoggedIn
    }
}
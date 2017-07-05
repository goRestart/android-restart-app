package com.restart.restart.login.domain.usecase

import com.restart.restart.login.domain.model.Session

class IsLoggedIn(
    private val session: Session
) {
    fun execute(): Boolean {
        return session.isLoggedIn
    }
}
package com.restart.restart.login.domain.usecase

import com.restart.restart.login.domain.model.Session

class Logout(
    private val session: Session
) {
    fun execute() {
        session.logout()
    }
}
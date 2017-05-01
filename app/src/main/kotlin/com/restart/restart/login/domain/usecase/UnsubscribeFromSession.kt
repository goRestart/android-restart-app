package com.restart.restart.login.domain.usecase

import com.restart.restart.login.domain.model.Session

class UnsubscribeFromSession(
    private val session: Session
) {
    fun execute(listener: Session.Listener) {
        session.unsubscribe(listener)
    }
}
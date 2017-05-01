package com.restart.restart.login.domain.usecase

import com.restart.restart.login.domain.model.Session

class SubscribeToSession(
    private val session: Session
) {
    fun execute(listener: Session.Listener) {
        session.subscribe(listener)
    }
}
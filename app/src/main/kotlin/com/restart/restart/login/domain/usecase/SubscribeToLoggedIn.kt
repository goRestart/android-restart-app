package com.restart.restart.login.domain.usecase

import com.restart.restart.login.domain.model.Session
import com.restart.restart.shared.domain.UseCase

class SubscribeToLoggedIn(
    private val session: Session
) : UseCase.WithNoError<Session.Listener, Unit>() {

    override fun executeNoError(input: Session.Listener) {
        session.listeners.add(input)
    }
}
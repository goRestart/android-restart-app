package com.restart.restart.login.domain.usecase

import com.restart.restart.login.domain.model.Session
import com.restart.restart.login.domain.model.SessionBroadcast

class SubscribeToSession(
    private val session: Session
) {
    fun execute(listener: SessionBroadcast.Listener) {
        session.subscribe(listener)
    }
}
package com.restart.restart.login.domain.model

class SessionBroadcast {

    private var listeners: MutableList<Listener> = mutableListOf()

    fun notifyUserLoggedIn() {
        listeners.forEach { it.onUserLoggedIn() }
    }

    fun notifyUserLoggedOut() {
        listeners.forEach { it.onUserLoggedOut() }
    }

    fun subscribe(listener: Listener) {
        listeners.add(listener)
    }

    fun unsubscribe(listener: Listener) {
        listeners.remove(listener)
    }

    interface Listener {
        fun onUserLoggedIn()
        fun onUserLoggedOut()
    }
}
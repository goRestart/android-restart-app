package com.restart.restart.login.data

import android.content.SharedPreferences

class SessionTokenStorage(
    val sharedPreferences: SharedPreferences
) {

    companion object {
        private val SESSION_TOKEN_KEY = "SessionToken"
    }

    fun store(token: String) {
        sharedPreferences.edit().putString(SESSION_TOKEN_KEY, token).apply()
    }

    fun clean() {
        sharedPreferences.edit().remove(SESSION_TOKEN_KEY).apply()
    }

    val hasSessionToken: Boolean
        get() = sharedPreferences.contains(SESSION_TOKEN_KEY)
}
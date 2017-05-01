package com.restart.restart.main.ui

import com.restart.restart.R
import com.restart.restart.login.domain.model.Session
import com.restart.restart.login.domain.usecase.SubscribeToSession
import com.restart.restart.login.domain.usecase.UnsubscribeFromSession
import java.lang.ref.WeakReference

class MainPresenter(
    private val view: WeakReference<View>,
    private val subscribeToSession: SubscribeToSession,
    private val unsubscribeFromLoggedIn: UnsubscribeFromSession
) : Session.Listener {

    interface View {
        fun addNavigationItems(icons: List<Int>)
        fun moveToFragment(index: Int)
    }

    fun onStarted() {
        view.get()?.addNavigationItems(
            listOf(
                R.drawable.listing_navigation_icon,
                R.drawable.favorites_navigation_icon,
                R.drawable.create_product_navigation_icon,
                R.drawable.messages_navigation_icon,
                R.drawable.profile_navigation_icon
            )
        )
        view.get()?.moveToFragment(0)
        subscribeToSession.execute(this)
    }

    fun onStopped() {
        unsubscribeFromLoggedIn.execute(this)
    }

    fun onItemSelected(index: Int) {
        view.get()?.moveToFragment(index)
    }

    override fun onUserLoggedIn() {

    }

    override fun onUserLoggedOut() {

    }
}
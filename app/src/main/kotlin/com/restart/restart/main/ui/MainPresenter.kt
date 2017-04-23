package com.restart.restart.main.ui

import com.restart.restart.R
import com.restart.restart.login.domain.model.Session
import com.restart.restart.login.domain.usecase.SubscribeToLoggedIn
import com.restart.restart.login.domain.usecase.UnsubscribeToLoggedIn
import com.restart.restart.shared.domain.UseCaseExecutor
import java.lang.ref.WeakReference

class MainPresenter(
    private val view: WeakReference<View>,
    private val subscribeToLoggedIn: SubscribeToLoggedIn,
    private val unsubscribeToLoggedIn: UnsubscribeToLoggedIn,
    private val useCaseExecutor: UseCaseExecutor
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
        useCaseExecutor.execute(subscribeToLoggedIn, this)
    }

    fun onStopped() {
        useCaseExecutor.execute(unsubscribeToLoggedIn, this)
    }

    fun onItemSelected(index: Int) {
        view.get()?.moveToFragment(index)
    }

    override fun onUserLoggedIn() {

    }

    override fun onUserLoggedOut() {

    }
}
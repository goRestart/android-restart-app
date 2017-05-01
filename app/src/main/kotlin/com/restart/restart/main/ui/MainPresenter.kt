package com.restart.restart.main.ui

import com.restart.restart.R
import com.restart.restart.login.domain.model.Session
import com.restart.restart.login.domain.usecase.IsLoggedIn
import com.restart.restart.login.domain.usecase.SubscribeToSession
import com.restart.restart.login.domain.usecase.UnsubscribeFromSession
import java.lang.ref.WeakReference

class MainPresenter(
    private val view: WeakReference<View>,
    private val isLoggedIn: IsLoggedIn,
    private val subscribeToSession: SubscribeToSession,
    private val unsubscribeFromLoggedIn: UnsubscribeFromSession
) : Session.Listener {

    interface View {
        fun addNavigationItems(icons: List<Int>)
        fun moveToScreen(screen: Screen)
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
        view.get()?.moveToScreen(Screen.Listing)
        subscribeToSession.execute(this)
    }

    fun onStopped() {
        unsubscribeFromLoggedIn.execute(this)
    }

    fun onScreenSelected(screen: Screen) {
        val displayedScreen = displayedScreenForScreen(screen)
        view.get()?.moveToScreen(displayedScreen)
    }

    override fun onUserLoggedIn() {

    }

    override fun onUserLoggedOut() {

    }

    private fun displayedScreenForScreen(screen: Screen): Screen {
        val isListing = screen != Screen.Listing
        val isLoggedIn = isLoggedIn.execute()
        return if (!isListing && !isLoggedIn) {
            Screen.Login(screen)
        } else {
            screen
        }
    }

    sealed class Screen {
        object Listing : Screen()
        object Favorites : Screen()
        object Messages : Screen()
        object Profile : Screen()
        class Login(val onScreen: Screen) : Screen()
    }
}
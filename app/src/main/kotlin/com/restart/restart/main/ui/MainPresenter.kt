package com.restart.restart.main.ui

import com.restart.restart.R
import com.restart.restart.login.domain.model.SessionBroadcast
import com.restart.restart.login.domain.usecase.IsLoggedIn
import com.restart.restart.login.domain.usecase.SubscribeToSession
import com.restart.restart.login.domain.usecase.UnsubscribeFromSession
import java.lang.ref.WeakReference

class MainPresenter(
    private val view: WeakReference<View>,
    private val isLoggedIn: IsLoggedIn,
    private val subscribeToSession: SubscribeToSession,
    private val unsubscribeFromLoggedIn: UnsubscribeFromSession
) : SessionBroadcast.Listener {

    private var currentScreen: Screen = Screen.Listing

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
        view.get()?.moveToScreen(currentScreen)
        subscribeToSession.execute(this)
    }

    fun onStopped() {
        unsubscribeFromLoggedIn.execute(this)
    }

    fun onScreenSelected(screen: Screen) {
        showScreen(screen)
    }

    override fun onUserLoggedIn() {
        print("ON USER LOGGED IN")
        val screen = currentScreen
        when (screen) {
            is Screen.Login -> showScreen(screen.onScreen)
            else -> return
        }
    }

    override fun onUserLoggedOut() {
        print("ON USER LOGGED OUT")
        val screen = currentScreen
        when (screen) {
            !is Screen.Login -> showScreen(screen)
            else -> return
        }
    }

    private fun showScreen(screen: Screen) {
        val displayedScreen = displayedScreenForScreen(screen)
        view.get()?.moveToScreen(displayedScreen)
        currentScreen = displayedScreen
    }

    private fun displayedScreenForScreen(screen: Screen): Screen {
        val isListing = screen == Screen.Listing
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
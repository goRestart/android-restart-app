package com.restart.restart.main.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import com.restart.restart.R
import com.restart.restart.favorites.ui.FavoritesFragment
import com.restart.restart.listing.ui.ListingFragment
import com.restart.restart.login.ui.UnloggedUserFragment
import com.restart.restart.messages.ui.MessagesFragment
import com.restart.restart.profile.ui.ProfileFragment
import com.restart.restart.shared.ui.RestartActivity
import com.restart.restart.shared.ui.view.bottomnavigation.ImageNavigationItem
import kotlinx.android.synthetic.main.main.*

class MainActivity : RestartActivity(), MainPresenter.View {

    var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = dependencyContainer!!.getMainPresenter(this)
        setContentView(R.layout.main)
        presenter?.onStarted()
        bottom_navigation_bar.onNavigationItemSelected = { onFragmentSelected(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onStopped()
    }

    override fun addNavigationItems(icons: List<Int>) {
        val navigationItems = icons.map { ImageNavigationItem(this, it) }
        bottom_navigation_bar.configure(navigationItems)
    }

    override fun moveToScreen(screen: MainPresenter.Screen) {
        val fragment = fragmentForScreen(screen)

        if (fragment_container.childCount == 0) {
            setFragment(fragment)
        } else {
            moveToFragment(fragment)
        }

        val index = indexOfScreen(screen)
        bottom_navigation_bar.select(index)
    }

    private fun indexOfScreen(screen: MainPresenter.Screen) =
        when (screen) {
            is MainPresenter.Screen.Login -> indexToScreens.toList().first { it.second == screen.onScreen }.first
            else -> indexToScreens.toList().first { it.second == screen }.first
        }

    private fun onFragmentSelected(index: Int) {
        val screen = indexToScreens[index] ?: return
        presenter?.onScreenSelected(screen)
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }

    private fun moveToFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.fragment_fade_in, R.anim.fragment_fade_out)
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun fragmentForScreen(screen: MainPresenter.Screen): Fragment =
        when (screen) {
            is MainPresenter.Screen.Listing -> ListingFragment()
            is MainPresenter.Screen.Favorites -> FavoritesFragment()
            is MainPresenter.Screen.Messages -> MessagesFragment()
            is MainPresenter.Screen.Profile -> ProfileFragment()
            is MainPresenter.Screen.Login -> UnloggedUserFragment()
        }

    val indexToScreens: Map<Int, MainPresenter.Screen> = mapOf(
        0 to MainPresenter.Screen.Listing,
        1 to MainPresenter.Screen.Favorites,
        3 to MainPresenter.Screen.Messages,
        4 to MainPresenter.Screen.Profile
    )
}

package com.restart.restart.main.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.restart.restart.R
import com.restart.restart.favorites.ui.FavoritesFragment
import com.restart.restart.listing.ui.ListingFragment
import com.restart.restart.messages.ui.MessagesFragment
import com.restart.restart.profile.ui.ProfileFragment
import com.restart.restart.shared.ui.view.bottomnavigation.ImageNavigationItem
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity(), MainPresenter.View {

    var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        presenter = MainPresenter(this)
        presenter?.onStart()

        bottom_navigation_bar.onNavigationItemSelected = { onFragmentSelected(it) }
    }

    override fun addNavigationItems(icons: List<Int>) {
        val navigationItems = icons.map { ImageNavigationItem(this, it) }
        bottom_navigation_bar.configure(navigationItems)
    }

    override fun moveToFragment(index: Int) {
        val fragment = fragmentByIndex(index) ?: return

        if (fragment_container.childCount == 0) {
            setFragment(fragment)
        } else {
            moveToFragment(fragment)
        }

        bottom_navigation_bar.select(index)
    }

    private fun onFragmentSelected(index: Int) {
        presenter?.onItemSelected(index)
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

    private fun fragmentByIndex(index: Int): Fragment? =
        when (index) {
            0 -> ListingFragment()
            1 -> FavoritesFragment()
            3 -> MessagesFragment()
            4 -> ProfileFragment()
            else -> null
        }
}

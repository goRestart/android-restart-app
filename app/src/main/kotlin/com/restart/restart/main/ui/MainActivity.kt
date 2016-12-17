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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        bottom_navigation_bar.configure(
            arrayOf(
                ImageNavigationItem(this, R.drawable.bottom_navigation_icon),
                ImageNavigationItem(this, R.drawable.bottom_navigation_icon),
                ImageNavigationItem(this, R.drawable.bottom_navigation_icon),
                ImageNavigationItem(this, R.drawable.bottom_navigation_icon),
                ImageNavigationItem(this, R.drawable.bottom_navigation_icon)
            ))

        bottom_navigation_bar.select(0)
        val fragment = ListingFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()

        bottom_navigation_bar.onNavigationItemSelected = { selectFragment(it) }
    }

    private fun selectFragment(index: Int) {
        val fragment = fragmentByIndex(index) ?: return

        supportFragmentManager
            .beginTransaction()
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

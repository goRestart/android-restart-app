package com.restart.restart.main.ui

import com.restart.restart.R

class MainPresenter(val view: View) {

    interface View {
        fun addNavigationItems(icons: List<Int>)
        fun moveToFragment(index: Int)
    }

    fun onStart() {
        view.addNavigationItems(
            listOf(
                R.drawable.listing_navigation_icon,
                R.drawable.favorites_navigation_icon,
                R.drawable.create_ad_navigation_icon,
                R.drawable.messages_navigation_icon,
                R.drawable.profile_navigation_icon
            )
        )
        view.moveToFragment(0)
    }

    fun onItemSelected(index: Int) {
        view.moveToFragment(index)
    }
}
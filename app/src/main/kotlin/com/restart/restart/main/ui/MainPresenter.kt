package com.restart.restart.main.ui

import com.restart.restart.R
import java.lang.ref.WeakReference

class MainPresenter(private val view: WeakReference<View>) {

    interface View {
        fun addNavigationItems(icons: List<Int>)
        fun moveToFragment(index: Int)
    }

    fun onStart() {
        view.get()?.addNavigationItems(
            listOf(
                R.drawable.listing_navigation_icon,
                R.drawable.favorites_navigation_icon,
                R.drawable.create_ad_navigation_icon,
                R.drawable.messages_navigation_icon,
                R.drawable.profile_navigation_icon
            )
        )
        view.get()?.moveToFragment(0)
    }

    fun onItemSelected(index: Int) {
        view.get()?.moveToFragment(index)
    }
}
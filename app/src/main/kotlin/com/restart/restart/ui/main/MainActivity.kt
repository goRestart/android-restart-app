package com.restart.restart.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.restart.restart.R
import com.restart.restart.ui.view.bottomnavigation.ImageNavigationItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation_bar.configure(
            arrayOf(
                ImageNavigationItem(this, R.drawable.bottom_navigation_icon),
                ImageNavigationItem(this, R.drawable.bottom_navigation_icon),
                ImageNavigationItem(this, R.drawable.bottom_navigation_icon),
                ImageNavigationItem(this, R.drawable.bottom_navigation_icon),
                ImageNavigationItem(this, R.drawable.bottom_navigation_icon)
            ))
    }
}

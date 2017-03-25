package com.restart.restart.listing.ui

import android.support.test.espresso.intent.rule.IntentsTestRule
import com.facebook.testing.screenshot.Screenshot
import com.restart.restart.main.ui.MainActivity
import org.junit.Rule
import org.junit.Test


class ListingFragmentScreenshotTest {

    @get:Rule var activityRule: IntentsTestRule<MainActivity> =
        IntentsTestRule(MainActivity::class.java, true, false)

    @Test
    fun shouldRenderAllProductsWhenThereAreSeveralProductsAvailable() {
        val activity = activityRule.launchActivity(null)

        Screenshot.snapActivity(activity).record()
    }
}
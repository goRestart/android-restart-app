package com.restart.restart.product.ui

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.intent.rule.IntentsTestRule
import com.facebook.testing.screenshot.Screenshot
import org.junit.Rule
import org.junit.Test

class ProductActivityScreenshotTest {

    @get:Rule var activityRule: IntentsTestRule<ProductActivity> =
        IntentsTestRule(ProductActivity::class.java, true, false)

    @Test
    fun shouldRenderProductWhenThereIsInformationAvailable() {
        val activity = launchActivity()

        Screenshot.snapActivity(activity).record()
    }

    private fun launchActivity(): ProductActivity {
        val launchIntent = ProductActivity.intent(InstrumentationRegistry.getContext(), "product id")
        val activity = activityRule.launchActivity(launchIntent)
        return activity
    }
}
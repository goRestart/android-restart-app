package com.restart.restart.login.ui

import android.support.test.espresso.intent.rule.IntentsTestRule
import com.facebook.testing.screenshot.Screenshot
import org.junit.Rule
import org.junit.Test

class LoginActivityScreenshotTest {

    @get:Rule var activityRule: IntentsTestRule<LoginActivity> =
        IntentsTestRule(LoginActivity::class.java, true, false)

    @Test
    fun shouldRenderLoginScreenWithButtonDisabled() {
        val activity = activityRule.launchActivity(null)

        Screenshot.snapActivity(activity).record()
    }
}
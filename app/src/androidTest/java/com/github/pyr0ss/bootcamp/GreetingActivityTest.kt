package com.github.pyr0ss.bootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GreetingActivityTest {

    @Test
    fun correctGreetingIsDisplayed() {
        val i = Intent(ApplicationProvider.getApplicationContext(), GreetingActivity::class.java)
        i.putExtra("mainName", testConstants.NAME)
        val activityScenario: ActivityScenario<AppCompatActivity> = launch(i)
        activityScenario.use {
            val greetingMessage = onView(ViewMatchers.withId(R.id.greetingMessage))
            greetingMessage.check(matches(withText("Hello ${testConstants.NAME}!")))
        }
    }
}
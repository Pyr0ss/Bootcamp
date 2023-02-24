package com.github.pyr0ss.bootcamp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.equalTo
import org.hamcrest.core.IsEqual
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun intentIsFiredWhenButtonIsPressed() {
        Intents.init()
        val button = onView(ViewMatchers.withId(R.id.mainGoButton))
        val textField = onView(ViewMatchers.withId(R.id.mainName))
        textField.perform(ViewActions.typeText(testConstants.NAME), ViewActions.closeSoftKeyboard())
        button.perform(ViewActions.click())
        intended(allOf(hasComponent(GreetingActivity::class.java.name), hasExtraWithKey("mainName")))
        Intents.release()
    }
}
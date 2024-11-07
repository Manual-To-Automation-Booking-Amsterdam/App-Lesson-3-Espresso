package com.example.lesson2_basictest.pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.lesson2_basictest.R

class AlertScreen {
    private var alertPageGoBackButton = Espresso.onView(withId(R.id.alertPageGoBackButton))
    private var alertPageText = Espresso.onView(withId(R.id.alertPageText))
    private var alertDialogYesButton = Espresso.onView(withId(android.R.id.button1))
    private var alertDialogNoButton = Espresso.onView(withId(android.R.id.button2))

    fun goBackToHomePage() {
        alertPageGoBackButton
            .check(matches(isDisplayed()))
            .perform(click())
    }

    fun handleAlertDialog(decision: String) {
        if (decision == "Yes") {
            alertDialogYesButton
                .check(matches(isDisplayed()))
                    .perform(click())
        } else if (decision == "No") {
            alertDialogNoButton
                .check(matches(isDisplayed()))
                    .perform(click())
        } else {
            error("Invalid option passed to function")
        }
    }

    fun verifyAlertPageText() {
        alertPageText
            .check(matches(withText("You are on the Alert page!")))
    }
}
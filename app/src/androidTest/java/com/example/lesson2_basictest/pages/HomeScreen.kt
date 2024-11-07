package com.example.lesson2_basictest.pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.lesson2_basictest.R

class HomeScreen () {
    private var alertButton = Espresso.onView(withId(R.id.alertButton))
    private var textFieldButton = Espresso.onView(withId(R.id.textFieldButton))
    private var formButton = Espresso.onView(withId(R.id.formButton))
    private var datePickerButton = Espresso.onView(withId(R.id.datePickerButton))
    private var switchesButton = Espresso.onView(withId(R.id.switchesButton))
    private var loginButton = Espresso.onView(withId(R.id.loginButton))

    fun verifyHomePageLoaded() {
        alertButton
            .check(matches(isDisplayed()))
    }

    fun goToAlertScreen() {
        alertButton
            .check(matches(isDisplayed()))
                .perform(click())
    }

    fun goToTextFieldScreen() {
        textFieldButton
            .check(matches(isDisplayed()))
            .perform(click())
    }

    fun goToFormScreen() {
        formButton
            .check(matches(isDisplayed()))
            .perform(click())
    }

    fun goToDatePickerScreen() {
        datePickerButton
            .check(matches(isDisplayed()))
            .perform(click())
    }

    fun goToSwitchesScreen() {
        switchesButton
            .check(matches(isDisplayed()))
            .perform(click())
    }

    fun goToLoginScreen() {
        loginButton
            .check(matches(isDisplayed()))
            .perform(click())
    }
}
package com.example.lesson2_basictest.pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.lesson2_basictest.R

class TextFieldScreen {
    private var textFieldPageGoBackButton = Espresso.onView(withId(R.id.textFieldPageGoBackButton))
    private var textField = Espresso.onView(withId(R.id.textField))
    private var submitButton = Espresso.onView(withId(R.id.textFieldSubmitButton))
    private var enteredTextLabel = Espresso.onView(withId(R.id.enteredTextLabel))

    fun goBackToHomePage() {
        textFieldPageGoBackButton
            .check(matches(isDisplayed()))
            .perform(click())
    }

    fun enterTextAndSubmit(textToEnter: String) {
        textField
            .check(matches(isDisplayed()))
                .perform(replaceText(textToEnter), closeSoftKeyboard())

        submitButton
            .check(matches(isDisplayed()))
                .perform(click())
    }

    fun verifyTextEntered(textToEnter: String) {
        enteredTextLabel
            .check(matches(isDisplayed()))
            .check(matches(withText("Entered Text: $textToEnter")))
    }
}
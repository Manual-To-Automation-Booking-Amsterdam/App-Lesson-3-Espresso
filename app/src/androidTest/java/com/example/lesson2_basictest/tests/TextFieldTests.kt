package com.example.lesson2_basictest.tests


import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.lesson2_basictest.MainActivity
import com.example.lesson2_basictest.pages.HomeScreen
import com.example.lesson2_basictest.pages.TextFieldScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TextFieldTests {

    var textToEnter = "Some text"
    private var homeScreen = HomeScreen()
    private var textFieldScreen = TextFieldScreen()

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun textFieldTests() {
        /*
        This will click on the Text Field button on the Home screen
         */
        homeScreen.goToTextFieldScreen()

        /*
        This will enter text in the text field
         */
        textFieldScreen.enterTextAndSubmit(textToEnter)

        /*
        This will verify that the text you entered previously is present in
        the label
         */
        textFieldScreen.verifyTextEntered(textToEnter)
    }
}

package com.example.lesson2_basictest.tests


import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.lesson2_basictest.MainActivity
import com.example.lesson2_basictest.pages.AlertScreen
import com.example.lesson2_basictest.pages.HomeScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class AlertTests {

    private var homeScreen = HomeScreen()
    private var alertScreen = AlertScreen()

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun alertTestYes() {
        /*
        This will click the Alert Button on the Home screen of the app.
         */
        homeScreen.goToAlertScreen()

        /*
        This will click the Yes button in the dialog that appears, taking us to the
        Alert page
         */
        alertScreen.handleAlertDialog("Yes")

        /*
        This will verify that the text on the Alert Page is currently displayed,
        verifying that we have made it to the page
         */
        alertScreen.verifyAlertPageText()
    }

    @Test
    fun alertTestNo() {
        /*
        This will click the Alert Button on the Home screen of the app.
         */
        homeScreen.goToAlertScreen()

        /*
        This will click the No button in the dialog that appears, allowing
        us to remain on the Home Screen
         */
        alertScreen.handleAlertDialog("No")

        /*
        This will verify that the Home Screen is currently displayed,
        verifying that we have not changed screens
         */
        homeScreen.verifyHomePageLoaded()
    }
}

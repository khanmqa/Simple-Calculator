package com.simplemobiletools.calculator.activities.com.simplemobiletools.calculator.object;

import android.support.test.espresso.ViewInteraction;
import com.simplemobiletools.calculator.R;
import com.simplemobiletools.calculator.activities.com.simplemobiletools.calculator.object.mainscreenObject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

//Creating a Setting Screen page object so that we can perform different actions on the screen
//Starting off with a method to to validate we are on the setting scree

public class settingsScreen {

    public static void openSetting() {
    //calling method from mainscreenObject class to open menu options
        mainscreenObject.openSettingscreen();

        ViewInteraction selectSettings= onView(allOf(withId(R.id.title), withText("Settings"),
                        isDisplayed()));
                        selectSettings.perform(click());

        ViewInteraction verifyScreen = onView(allOf(withId(R.id.settings_customize_colors_label), withText("Customize colors"),
                                        isDisplayed()));
        verifyScreen.check(matches(withText("Customize colors")));
    }

    }























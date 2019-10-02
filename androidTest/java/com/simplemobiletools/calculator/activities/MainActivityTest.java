package com.simplemobiletools.calculator.activities;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.simplemobiletools.calculator.R;
import com.simplemobiletools.calculator.activities.com.simplemobiletools.calculator.object.mainscreenObject;
import com.simplemobiletools.calculator.activities.com.simplemobiletools.calculator.object.settingsScreen;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

//imported all dependencies need to run this this. We will create a method that allows use to call the methods in the mainscreenObject class

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest  {

//Since I am still learning JAVA i have placed these elements here for now because the should be in their relative object class where t
//they are global variables

        private int btn8 = R.id.btn_8;

        private int btn3 = R.id.btn_3;

        private String ans = "11";

        private String ans2 = "5";

//This rule needs to be set to test the MainActivity where the tests will be performed

        @Rule
        public ActivityTestRule<MainActivity> mActivityTestRule =
                new ActivityTestRule<>(MainActivity.class);

//this is the method that will call on the Page Object class and respective method to make an additions
// based on the values i press (called operands)
        @Test
        public void addNumbers() {

            mainscreenObject.addition(btn8, btn3, ans);
        }

        @Test
        public void subtractNumbers() {
                mainscreenObject.subtraction(btn8, btn3, ans2);

        }
        //this method opens the setting screen there by calling on a different page object and this is to outline how i'd go about
        //create this page object
        @Test
        public void openSettings()  {
                settingsScreen.openSetting();

        }

}



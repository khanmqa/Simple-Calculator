//This is the Page Object class where all the relevant methods and elements should be used to perform
//actions on the calculator screen

package com.simplemobiletools.calculator.activities.com.simplemobiletools.calculator.object;

import android.support.annotation.IdRes;

import android.support.test.espresso.ViewInteraction;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.simplemobiletools.calculator.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;


import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

//I have created methods here to do an addition, subtration, and click on options menu where the same template can be used for other calculations
//where simply need to change the operator in the method. This method is dynamic so I can use the operands i wish to make an
//addition and also make an assertion that the correct result is displayed

public class mainscreenObject {

    public static void addition(@IdRes int firstOperand, @IdRes int secondOperand,@IdRes String answer) {

        onView(withId(firstOperand))
                .perform(click());
        onView(withId(R.id.btn_plus))
                .perform(click());
        onView((withId(secondOperand)))
                .perform(click());
        onView(withId(R.id.btn_equals))
                .perform(click());
        onView(withId(R.id.calculator_holder))
                .check(matches(isDisplayed()));

        ViewInteraction validateAnswer = onView(
                allOf(withId(R.id.result), withText(answer),
                        isDisplayed()));
        validateAnswer.check(matches(withText(answer)));
    }
//dynamic method to make subtraction

    public static void subtraction(@IdRes int firstOperand, @IdRes int secondOperand,@IdRes String answer) {

        onView(withId(firstOperand))
                .perform(click());
        onView(withId(R.id.btn_minus))
                .perform(click());
        onView((withId(secondOperand)))
                .perform(click());
        onView(withId(R.id.btn_equals))
                .perform(click());
        onView(withId(R.id.calculator_holder))
                .check(matches(isDisplayed()));
        ViewInteraction validateSubtraction = onView(
                allOf(withId(R.id.result), withText(answer),
                        childAtPosition(
                                allOf(withId(R.id.calculator_holder),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        validateSubtraction.check(matches(withText(answer)));

    }

//this is a method to click on options menu and select settings
//this method is in this object because the element exists on the main screen#

    public static void openSettingscreen() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
    }

 //this method was provided by espress recorder when I did the assertion for subtraction method
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {


        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };



    }
}






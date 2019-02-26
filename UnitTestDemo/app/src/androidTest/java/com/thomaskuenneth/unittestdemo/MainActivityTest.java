package com.thomaskuenneth.unittestdemo;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    // https://developer.android.com/training/testing/espresso/setup

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test1() {
        onView(withId(R.id.button_easy)).perform(click());
        onView(withId(R.id.edittext_guess)).perform(typeText("3"));
        onView(withId(R.id.butoon_guess)).perform(click());
    }
}

package com.example.myapplicationespresso;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.EspressoKey;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.KeyEvent;

import com.example.myapplicationespresso.MainActivity;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class EspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);
    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.editText))
                .perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        // Check that the text was changed.
        onView(withId(R.id.textView)).check(matches(withText("HELLO")));
        //onView(withContentDescription("Navigate up")).perform(click());

        //checking date range input for search
        onView(withId(R.id.editText4))
                .perform(typeText("1/1/2010"), closeSoftKeyboard());
        onView(withId(R.id.editText5))
                .perform(typeText("1/1/2015"), closeSoftKeyboard());
        onView(withId(R.id.button2)).perform(click());
        // Check something
        onView(withId(R.id.textView)).check(matches(withText("HELLO")));
        //onView(withContentDescription("Navigate up")).perform(click());

    }
}

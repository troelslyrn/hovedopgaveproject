package com.app.andel.andelsapp.Viewmap;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import com.app.andel.andelsapp.Controller.AgendaKommentare;
import com.app.andel.andelsapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class AgendaKommentareTest {
@Rule
public ActivityTestRule<AgendaKommentare> mActivityTestRule = new ActivityTestRule<AgendaKommentare>(AgendaKommentare.class);

private String eName = "Tony";
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void testUserInputScenario(){
        //input some text in the dit text
        Espresso.onView(withId(R.id.Writer2)).perform(typeText(eName));
        // close soft keyboard
        Espresso.closeSoftKeyboard();
        //perfom button click
        Espresso.onView(withId(R.id.SaveNow2)).perform(click());
        // checking the text in the textView
       // Espresso.onView(withId(R.id.).check(matches(withText(eName)));
    }
    @After
    public void tearDown() throws Exception {
    }
}

package com.app.andel.andelsapp.Viewmap;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.app.andel.andelsapp.Controller.MainActivity;
import com.app.andel.andelsapp.Controller.MødeOversigt;
import com.app.andel.andelsapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static org.junit.Assert.*;

public class MainActivityTest {

 @Rule
public ActivityTestRule<MainActivity> mActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
 private MainActivity mActivity = null;

 Instrumentation.ActivityMonitor monitor = InstrumentationRegistry.getInstrumentation().addMonitor(MødeOversigt.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityActivityTestRule.getActivity();
    }

    @Test
    public void  testLaunchOnSecondActivityOnButtonClick()
    {
        assertNotNull(mActivity.findViewById(R.id.AgandaAfholderButton2));
        onView(withId(R.id.AgandaAfholderButton2)).perform(click());
        Activity secondActivity = InstrumentationRegistry.getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(secondActivity);

        secondActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}
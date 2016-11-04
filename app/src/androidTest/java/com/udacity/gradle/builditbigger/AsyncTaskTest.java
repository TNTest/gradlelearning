package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.TextView;

import com.udacity.gradle.jokemaker.JokeMaker;
import com.udacity.gradle.jokescreen.JokeScreenActivity;

import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AsyncTaskTest extends ActivityInstrumentationTestCase2<JokeScreenActivity> {

    private Activity activity;

    public AsyncTaskTest() {
        super(JokeScreenActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //setActivityInitialTouchMode(true);
        activity = getActivity();
    }

    @MediumTest
    public void testJokeContent_iscorrect() throws Exception {
        // Context of the app under test.
        String content = new EndpointsAsyncTask().execute(activity).get();
        Assert.assertEquals(JokeMaker.content, ((TextView)activity.findViewById(R.id.screen_text)).getText());
    }
}

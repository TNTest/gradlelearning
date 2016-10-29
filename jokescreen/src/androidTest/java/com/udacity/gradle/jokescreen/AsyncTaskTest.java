package com.udacity.gradle.jokescreen;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.TextView;

import com.udacity.gradle.jokemaker.JokeMaker;

import junit.framework.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AsyncTaskTest extends ActivityInstrumentationTestCase2<JokeScreenActivity> {

    private TextView mTv;

    public AsyncTaskTest() {
        super(JokeScreenActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //setActivityInitialTouchMode(true);
        mTv = (TextView) getActivity().findViewById(R.id.screen_text);
    }

    @MediumTest
    public void testJokeContent_iscorrect() throws Exception {
        // Context of the app under test.
        String content = new EndpointsAsyncTask().execute(mTv).get(60000, TimeUnit.MICROSECONDS);
        Assert.assertEquals(JokeMaker.content, mTv.getText());
    }
}

package com.example.oshrat.bookstore;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class BookStoreUnitTests {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    private LoginActivity la = null;

    @Before
    public void setUp(){
        la = mActivityRule.getActivity();

    }
//The test checks if an email address is invalid
//(the email address that`s given is invalid in deliberately).
    @Test
    public void testInvalidEmail(){
        final TextView emailView = (TextView) la.findViewById(R.id.email);
        final Button signInBtn = (Button) la.findViewById(R.id.email_sign_in_button);

        la.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                emailView.setText("sparta1.gmail.com");
                signInBtn.performClick();

                assertEquals(emailView.getError().toString(), "This email address is invalid");
            }
        });
    }

//The test checks if a password is invalid
//(the password that`s given is invalid in deliberately -suppose to include at least 6 figure).
    @Test
    public void testInvalidPassword(){
        final TextView emailView = (TextView) la.findViewById(R.id.email);
        final TextView passView = (TextView) la.findViewById(R.id.password);
        final Button signInBtn = (Button) la.findViewById(R.id.email_sign_in_button);

        la.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                emailView.setText("sparta1@gmail.com");
                passView.setText("aaa");
                signInBtn.performClick();

                assertEquals(passView.getError().toString(), "This password is too short");
            }
        });
    }

    @After
    public void tearDown(){
        la = null;
    }
}

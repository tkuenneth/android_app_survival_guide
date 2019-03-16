package com.thomaskuenneth.debugdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int Factorial = 1;
        System.out.println("0! = " + Factorial);
        for (int i = 1; i <= 5; i++) {
            Factorial = i * Factorial;
            System.out.println(i + "! = " + Factorial);
        }

        Log.d(TAG, "debug");
        Log.v(TAG, "verbose");
        Log.i(TAG, "info");
        Log.w(TAG, "warn");
        Log.e(TAG, "error");

        Log.println(Log.ASSERT, TAG, "assert");

        Log.i(TAG, "VERBOSE: " + Boolean.toString(Log.isLoggable(TAG, Log.VERBOSE)));
        Log.i(TAG, "DEBUG: " + Boolean.toString(Log.isLoggable(TAG, Log.DEBUG)));
        Log.i(TAG, "INFO: " + Boolean.toString(Log.isLoggable(TAG, Log.INFO)));
        Log.i(TAG, "WARN: " + Boolean.toString(Log.isLoggable(TAG, Log.WARN)));
        Log.i(TAG, "ERROR: " + Boolean.toString(Log.isLoggable(TAG, Log.ERROR)));
        Log.i(TAG, "ASSERT: " + Boolean.toString(Log.isLoggable(TAG, Log.ASSERT)));

        String s = null;
        try {
            int l = s.length();
        } catch (NullPointerException e) {
            Log.wtf(TAG, "What a terrible failure ;-)", e);
        }

        // ordinaryBreakpointTest();
        for (int i = 0; i < 1000; i++) {
            exceptionBreakpointTest();
        }
    }

    void ordinaryBreakpointTest() {
        for (int i = 0; i < 1000; i++) {
            int j = i * i;
            Log.i(TAG, "j = " + j);
        }
    }

    void exceptionBreakpointTest() {
        int i = (int) (Math.random() * 10f);
        int j = 100 / i;
        Log.i(TAG, "100 / " + i + " = " + j);
    }
}

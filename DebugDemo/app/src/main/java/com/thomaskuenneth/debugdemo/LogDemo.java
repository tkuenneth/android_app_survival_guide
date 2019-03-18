package com.thomaskuenneth.debugdemo;

import android.util.Log;

class LogDemo {

    private static final String TAG = MainActivity.class.getSimpleName();

    static void logLevelDemo() {
        Log.d(TAG, "debug");
        Log.v(TAG, "verbose");
        Log.i(TAG, "info");
        Log.w(TAG, "warn");
        Log.e(TAG, "error");
        Log.println(Log.ASSERT, TAG, "assert");
    }

    static void isLoggableDemo() {
        Log.i(TAG, "VERBOSE: " + Boolean.toString(Log.isLoggable(TAG, Log.VERBOSE)));
        Log.i(TAG, "DEBUG: " + Boolean.toString(Log.isLoggable(TAG, Log.DEBUG)));
        Log.i(TAG, "INFO: " + Boolean.toString(Log.isLoggable(TAG, Log.INFO)));
        Log.i(TAG, "WARN: " + Boolean.toString(Log.isLoggable(TAG, Log.WARN)));
        Log.i(TAG, "ERROR: " + Boolean.toString(Log.isLoggable(TAG, Log.ERROR)));
        Log.i(TAG, "ASSERT: " + Boolean.toString(Log.isLoggable(TAG, Log.ASSERT)));
    }

    static void wtfDemo() {

        String s = null;
        try {
            int l = s.length();
        } catch (NullPointerException e) {
            Log.wtf(TAG, "What a terrible failure ;-)", e);
        }
    }
}

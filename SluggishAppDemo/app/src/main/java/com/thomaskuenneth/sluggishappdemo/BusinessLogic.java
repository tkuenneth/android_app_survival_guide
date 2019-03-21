package com.thomaskuenneth.sluggishappdemo;

import android.util.Log;

class BusinessLogic {

    static void doComplexStuff() {
        sleep();
    }

    static void doVeryComplexStuff() {
        while (true) {
            doComplexStuff();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            Log.e(SluggishAppDemo.TAG, "sleep()", e);
        }
    }
}

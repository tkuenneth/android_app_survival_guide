package com.thomaskuenneth.sluggishappdemo;

import java.util.HashMap;
import java.util.Map;

class BusinessLogic {

    private static Map<Double, byte []> map = new HashMap<>();

    static void doComplexStuff() {
        compute();
    }

    static void doVeryComplexStuff() {
        while (true) {
            doComplexStuff();
        }
    }

    private static void compute() {
        double f = Math.random();
        long current = System.currentTimeMillis();
        while (System.currentTimeMillis() - current < 3500) {
            f *= Math.random();
            Double key = new Double(f);
            byte [] bytes = new byte[65536];
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (Math.random() * 256f);
            }
            map.put(key, bytes);
        }
    }
}

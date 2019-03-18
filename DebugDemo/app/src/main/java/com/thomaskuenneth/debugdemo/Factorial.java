package com.thomaskuenneth.debugdemo;

class Factorial {

    static int factorial(int f) {
        int result = 1;
        System.out.println("0! = " + result);
        for (int i = 1; i <= f; i++) {
            result = i * result;
            System.out.println(i + "! = " + result);
        }
        return result;
    }
}

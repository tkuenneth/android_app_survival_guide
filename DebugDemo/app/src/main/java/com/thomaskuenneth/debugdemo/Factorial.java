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

    static int factorialRecursive(int n) {
        if (n <= 1) {
            return 1;
        }
        return factorialRecursive(n - 1) * n;
    }
}

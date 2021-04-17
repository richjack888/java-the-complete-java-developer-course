package com.mylibrary;

public class Series {
    public static int nSum(int n) {
//        int num = 0;
//        for (int i = 1; i <= n; i++) {
//            num += i - 1;
//        }
//        return num;
        if (n == 0) {
            return 0;
        } else
            return n + nSum(n - 1);

    }

    public static int factorial(int n) {
//        int num = 1;
//        for (int i = 1; i <= n; i++) {
//            num *= i;
//        }
//        return num;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else
            return n * factorial(n - 1);
    }


    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }

}
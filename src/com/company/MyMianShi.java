package com.company;

import com.sun.xml.internal.fastinfoset.stax.events.Util;

public class MyMianShi {

    public static void main(String[] args) {
        String test = "1 2 3 4 5 6 7";
        // power(test);
        System.out.println(prime(10000));
    }

    public static long power(String input) {
        // write code here
        String[] test = input.split(" ");
        long sum = 0;
        for (int i = 5; i > -1; i--) {
            long result = Long.parseLong(test[i]);
            for (int j = 1; j < Long.parseLong(test[i + 1]); j++) {
                result *= Integer.parseInt(test[i]);
            }
            sum += result;
        }
        System.out.println(sum);
        return sum;
    }


    public static int prime(int i) {
        // write code here
        int testInt = 0;
        if (i < 1 || i > 9999) {
            return -1;
        }

        int left = 0, right = 0;
        int leftTemp = i;
        for (; leftTemp > 0; leftTemp--) {
            if (checkSu(leftTemp)) {
                left = leftTemp;
                break;
            }
        }
        int rightTemp = i;
        for (; rightTemp < 10000; rightTemp++) {
            if (checkSu(rightTemp)) {
                right = rightTemp;
                break;
            }
        }
        if (left == 0 || right == 0) {
            testInt = 0;
        } else {
            testInt = Math.abs(right - left);
        }
        return testInt;

    }

    public static boolean checkSu(int test) {
        boolean reult = true;
        if (test < 4) return true;
        for (int i = 2; i < test; i++) {
            if (test % i == 0) {
                reult = false;
            }
        }
        return reult;
    }


}

package com.company.nowcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author SmileAlfred
 * @create 2021-03-09 20:35
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 数组容器
 */
public class ArrContainer {

    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{3,1,2,5,2,4};
        long res = getVolume(arr);
        System.out.println(res);
    }

    public static long getVolume(int[] arr) {
        if (arr == null || arr.length < 3) return 0;

        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int l = 1;
        int r = arr.length - 2;
        long volume = 0;

        while (l <= r) {
            //木桶效应，以 低边 为准；
            if (leftMax <= rightMax) {
                volume += Math.max(leftMax - arr[l], 0);
                leftMax = Math.max(leftMax, arr[l++]);
            } else {
                volume += Math.max(rightMax - arr[r], 0);
                rightMax = Math.max(rightMax, arr[r--]);
            }
        }
        return volume;
    }
}
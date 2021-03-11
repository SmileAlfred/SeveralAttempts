package com.company.nowcode;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import javax.swing.*;
import java.nio.channels.Pipe;
import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-11 9:21
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 给定一个无序数组arr，找到数组中未出现的最小正整数
 * 例如arr = [-1, 2, 3, 4]。返回1
 * arr = [1, 2, 3, 4]。返回5
 * <p>
 * [要求] 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 */
public class NC30MinNum {
    @Test
    public void test() {
        int[] arr = new int[]{-1, 2, 3, 4};
        int i = minNumberdisappered2(arr);
        System.out.println(Arrays.toString(arr) + " 中没有出现的最小正整数是：" + i);
    }
    public int minNumberdisappered2(int[] arr) {
        // write code here
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == i + 1 || arr[i] > n || arr[i] <= 0) continue;
            while (arr[i] != i + 1 && arr[i] <= n && arr[i] > 0) {
                swap(arr,i, arr[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) if (arr[i] != i + 1) return i + 1;
        return n + 1;
    }

    private int[] swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public int minNumberdisappered(int[] arr) {
        // write code here.
        if (arr.length == 0) return -1;

        Arrays.sort(arr);
        if (arr[0] > 1) return 1;
        boolean firstZhengshu = true;
        for (int i = 0; i < arr.length - 1; i++) {

            //找到第一个 正数
            if (arr[i] <= 0) continue;
            if (firstZhengshu) {
                if (arr[i] > 1) return 1;
                firstZhengshu = false;
            }
            if (arr[i + 1] - arr[i] > 1) return arr[i] + 1;
        }
        return arr[arr.length - 1] + 1;


    }

    @Test
    public void test1() {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println("替换前：" + Arrays.toString(arr));
        int[] swap = swap(arr, 0, 3);
        System.out.println("替换后：" + Arrays.toString(swap));


    }
}

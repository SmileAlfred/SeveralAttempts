package com.company.nowcode;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-11 19:33
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * 题目保证没有全为负数的数据
 * 注意：子串的意思是：连续！连续！连续！
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 */
public class N19SubArr {
    @Test
    public void test() {
        int[] arr = new int[]{1, -2, 3, 5, -2, 6, -1};

        int sum = maxSum3(arr);
        System.out.println("方法 maxSum3() " + Arrays.toString(arr) + " 中最大子数组之和：" + sum);

        int sum1 = maxsumofSubarray(arr);
        System.out.println("方法 maxsumofSubarray() " + Arrays.toString(arr) + " 中最大子数组之和：" + sum1);

        int sum2 = maxsumofSubarray2(arr);
        System.out.println("方法 maxsumofSubarray2() " + Arrays.toString(arr) + " 中最大子数组之和：" + sum2);
    }
    /**
     * 遇到这种动态公式非常明显的题，直接考虑动态规划，并且列出转移方程
     * 设置动态数组 dp[i]：下标为 i 处之前的最大累加和(可能不包括自己也可能包括自己)以下为转移方程
     *
     * 初始化dp[0] = arr[0]
     * dp[i-1] > 0 -> dp[i] = dp[i-1] + arr[i]
     * dp[i-1] <= 0 -> dp[i] = arr[i]
     *
     * @param arr
     * @return
     */
    public int maxsumofSubarray2(int[] arr) {
        // write code here
        if (arr.length == 0) return 0;
        int sum = arr[0];
        int max = sum;
        for (int i = 1; i < arr.length; i++) {
            sum = sum > 0 ? sum + arr[i] : arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }
    /**
     * 解题思路就是从前往后推，要保证每个位置的值都起码比原本的大。注意每次都要用m保存当前时刻的最大累积和，最后直接返回就ok。
     *
     * @param arr
     * @return
     */
    public int maxsumofSubarray(int[] arr) {
        if (arr.length == 1) return arr[0];
        int m = 0; // 保存最大累加和
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i - 1] + arr[i]);
            m = Math.max(m, arr[i]);
        }
        return m;
    }
    private int maxSum3(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];

        int start = arr[n - 1];
        int all = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            start = Integer.max(arr[i], start + arr[i]);
            all = Integer.max(all, start);
        }

        return all;
    }
}

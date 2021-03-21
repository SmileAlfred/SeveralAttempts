package com.company.nowcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-16 8:48
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/9ce534c8132b4e189fd3130519420cde?tpId=188&tqId=38044&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC101缺失数字
 * 从0, 1, 2, ..., n这n+1个数中选择n个数，组成有序数组，请找出缺失的那个数，要求O(n)尽可能小。
 * 示例1
 * 输入  [0,1,2,3,4,5,7]
 * 返回值  6
 */
public class NC101FindNumFromArr {
    @Test
    public void test() {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 8};
        int solve = solve3(a);
        System.out.println("数组：" + Arrays.toString(a) + " 中没有：" + solve);
    }

    /**
     * 我的错误 二分
     *
     * @param a
     * @return
     */
    public int solve(int[] a) {
        // write code here
        if (a[0] != 0) return 0;
        int leftIndex = 0, rightIndex = a.length - 1, midIndex = (leftIndex + rightIndex) / 2;
        while (rightIndex > midIndex || leftIndex > midIndex) {
            if (a[midIndex] == midIndex && a[midIndex + 1] > midIndex + 1) {
                return midIndex + 1;
            }
            if (a[midIndex] == midIndex && a[midIndex - 1] < midIndex - 1) {
                return midIndex - 1;
            }

            if (a[midIndex] <= midIndex) {
                //向右找
                leftIndex = midIndex;
            } else {
                rightIndex = midIndex;
            }
            midIndex = (leftIndex + rightIndex) / 2;


        }
        return 0;
    }

    /**
     * 大手的解法 的二分
     *
     * @param a
     * @return
     */
    public int solve2(int[] a) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (a[mid] == mid) l = mid + 1;
            else if (a[mid] > mid) r = mid;
        }
        if (a[l] == l) return l + 1;
        return l;
    }

    /**
     * 位元算
     *
     * @param a
     * @return
     */
    public int solve3(int[] a) {
        // write code here
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            //不能再用n，会变，不再是数组a的长度
            n ^= i ^ a[i];
        }
        return n;
    }

    @Test
    public void test1() {
        System.out.println("6^7 = " + (6 ^ 7));
        System.out.println("7^1 = " + (7 ^ 1));
        System.out.println("8^1 = " + (8 ^ 1));
        System.out.println("9^1 = " + (9 ^ 1));

        System.out.println("8 ^ 7 ^ 8 = " + (8 ^ 7 ^ 8));
    }
}

package com.company.nowcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-09 13:46
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 有一个整数数组，请你根据快速排序的思路，找出数组中第 K 大的数。
 * 给定一个整数数组 a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第 K大的数，保证答案存在。
 */
public class QuickSort {
    @Test
    public void test() {
        int[] a = {1, 3, 5, 2, 2};
        int n = 5, k = 3;
        int res = findKth(a, n, k);
        System.out.println("数组 "+Arrays.toString(a)+" 中，第 "+ k + " 大的数是："+res);
    }

    /**
     * 返回第 K 个最大数
     *
     * @param a 数组
     * @param n 数组长度
     * @param K 序号
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        // write code here
        int[] ints = QuickSortB2S(a, 0, a.length - 1);
        if (a.length < K) return -1;
        if (a.length == K) return ints[a.length - 1];
        for (int i = 0; i < K; i++) {
            if (i + 1 == K) return ints[i];

        }

        return -1;
    }

    /**
     * 从大到小的排序
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    public int[] QuickSortB2S(int[] a, int left, int right) {

        if (left >= right) {
            return a;
        }
        int pivot = left;
        int pivotVal = a[pivot];
        int l = left;
        int r = right;

        while (l < r) {
            while (l < r && a[r] <= pivotVal) {
                r--;
            }
            a[l] = a[r];
            while (l < r && a[l] >= pivotVal) {
                l++;
            }
            a[r] = a[l];
        }
        a[l] = pivotVal;

        //报错：栈溢出，这里永远不会结束！
        //findKth(a, left, (right - left) / 2 + 1);
        //findKth(a, (right - left) / 2 + 1, right + 1);

        QuickSortB2S(a, left, l - 1);
        QuickSortB2S(a, l + 1, right);

        return a;
    }


}

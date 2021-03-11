package com.company.nowcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-09 15:00
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description
 */
public class QuickSortJava {

    @Test
    public void test() {
        int[] a = {1, 3, 5, 2, 2};
        int n = 5, k = 3;
        //int[] kth = findKth(a, 0, a.length - 1);
        QuickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));//2
    }
    private static int count;
    /**
     * 递增 的快速排序
     *
     * @param num   排序的数组
     * @param left  数组的前针
     * @param right 数组后针
     */
    private static void QuickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if (left >= right) {
            return;
        }
        //设置最左边的元素为基准值
        int pivot = num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int l = left;
        int r = right;
        while (l < r) {
            //j向左移，直到遇到比key小的值
            while (num[r] >= pivot && l < r) {
                r--;
            }
            //i向右移，直到遇到比key大的值
            while (num[l] <= pivot && l < r) {
                l++;
            }
            //i和j指向的元素交换
            if (l < r) {
                int temp = num[l];
                num[l] = num[r];
                num[r] = temp;
            }
        }
        num[left] = num[l];
        num[l] = pivot;
        count++;
        QuickSort(num, left, l - 1);
        QuickSort(num, l + 1, right);
    }

}

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
        System.out.println("快排一：" + Arrays.toString(a));//2

        QuickSort2(a, 0, a.length - 1);
        System.out.println("快排二：" + Arrays.toString(a));//2

    }


    /**
     * 从小到大的快排
     *
     * @param arr   待排序数组
     * @param left  左侧节点
     * @param right 右侧节点
     */
    private void QuickSort2(int[] arr, int left, int right) {
        if(left >= right)return;

        int  pivotVal = arr[left];
        int l = left, r = right;

        while (l < r) {
            while (l < r && arr[l] <= pivotVal) {
                l++;
            }
            //TODO:null
            while (l < r && arr[r] >= pivotVal) {
                r--;
            }
            //TODO:交换元素
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        //TODO:
        arr[left] = arr[l];
        arr[l] = pivotVal;
        //迭代的时候一定要注意传入的区间；
        QuickSort(arr, left, l);
        QuickSort(arr, l+1, right);
    }


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
        QuickSort(num, left, l - 1);
        QuickSort(num, l + 1, right);
    }

}

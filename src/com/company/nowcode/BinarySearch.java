package com.company.nowcode;

import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-09 16:37
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 二分法查找
 */
public class BinarySearch {


    @Test
    public void test() {
        int[] arr = {3,1};
        int target = 1;
        //int index = Search(arr, 0, arr.length - 1, target);
        //System.out.println("数组：" + Arrays.toString(arr) + " 中：" + target + " 在 " + index);

        int rotate = rotate(arr, target);
        System.out.println("数组：" + Arrays.toString(arr) + " 中：" + target + " 在 " + rotate);

    }

    public int rotate(int[] A, int target) {

        //没有反转
        if (A.length == 1 || A[0] < A[A.length - 1]) return Search(A, 0, A.length - 1, target);

        //此处规定断电索引为 最大值的索引，如：4，5，6，1，2；端点位置即 6 所在索引 2
        int duanDianIndex = -1;

        //通过遍历的方法找断点是有问题的，太慢了！
       /* for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] >= A[0]) {
                duanDian = i;
                break;
            }
        }*/
        int left = 0, right = A.length - 1;
        while (left <= right) {
            if (A[left] > A[left + 1]) {
                duanDianIndex = left;
                break;
            } else if (A[right] < A[right - 1]) {
                //注意，这里需要 right -1；统一 断电位置为，最大值 的索引
                duanDianIndex = right -1;
                break;
            } else {
                left++;
                right--;
            }
        }


        if (target >= A[0]) {
            //左侧查找
            return Search(A, 0, duanDianIndex, target);
        } else {
            return Search(A, duanDianIndex + 1, A.length - 1, target);
        }
    }

    /**
     * 二分法查找
     *
     * @param arr
     * @param left   左侧 索引
     * @param right  传入的是 索引值，不是长度值
     * @param target
     * @return 返回索引
     */
    private int Search(int[] arr, int left, int right, int target) {
        if (left >= right) {
            if (arr[left] == target) return left;
            return -1;
        }
        int midIndex = (left + right) / 2;
        int midVal = arr[midIndex];
        if (midVal == target) {
            return midIndex;
        } else if (midVal < target) {
            //向右去遍历；
            return Search(arr, midIndex + 1, right, target);
        } else {
            //向左去遍历；
            return Search(arr, left, midIndex, target);
        }
    }
}

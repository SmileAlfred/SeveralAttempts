package com.company.nowcode;

import com.sun.javafx.image.BytePixelSetter;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-20 16:42
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description NC36在两个长度相等的排序数组中找到上中位数
 * 题目描述
 * 给定两个有序数组arr1和arr2，已知两个数组的长度都为N，求两个数组中所有数的上中位数。
 * 上中位数：假设递增序列长度为n，若n为奇数，则上中位数为第n/2+1个数；否则为第n/2个数
 * [要求]
 * 时间复杂度为O(logN)O(logN)，额外空间复杂度为O(1)O(1)
 * 示例1
 * 输入  [1,2,3,4],[3,4,5,6]
 * 返回值  3
 * 说明
 * 总共有8个数，上中位数是第4小的数，所以返回3。
 * 示例2
 * 输入  [0,1,2],[3,4,5]
 * 返回值  2
 * 说明
 * 总共有6个数，那么上中位数是第3小的数，所以返回2
 * 备注:
 * 1 ≤ N ≤ 10^5
 * 0 ≤ arr_{1i}, arr_{2i} ≤ 10^9
 */
public class NC36ZhongWeiNum {
    @Test
    public void test() {
        int[] arr1 = new int[]{0, 1, 2};
        int[] arr2 = new int[]{3, 4, 5};

        int medianinTwoSortedAray = findMedianinTwoSortedAray(arr1, arr2);
        System.out.println("数组：" + Arrays.toString(arr1) + " 和数组：" + Arrays.toString(arr2) + "上中位数为:" + medianinTwoSortedAray);
    }

    /**
     * https://blog.nowcoder.net/n/b2ba01ea9b9a4ab38166b826525f3079?f=comment
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        // write code here
        if (arr1.length == 1) return Math.min(arr1[0], arr2[0]);///特判

        int n = arr1.length;///数组长度
        int l1 = 0, r1 = n - 1, l2 = 0, r2 = n - 1;///初始指针
        //元素个数位为奇数，flag = 1，为偶数 flag =0
        int flag = ((r1 - l1 + 1) & 1);

        while (l1 < r1) {
            int mid1 = l1 + ((r1 - l1) >> 1);
            int mid2 = l2 + ((r2 - l2) >> 1);
            //更新区域的个数，奇数，flag = 1，为偶数flag =0
            flag = ((r1 - l1 + 1) & 1);
              //若两数组中位数相等，整体的中位数也是这个
            if (arr1[mid1] == arr2[mid2]) return arr1[mid1];
            else if (arr1[mid1] > arr2[mid2]) {
                ///如果区域个数是奇数
                if (flag == 1) {
                    r1 = mid1;
                    l2 = mid2;
                } else {
                    ///如果区域个数是偶数
                    r1 = mid1;
                    l2 = mid2 + 1;
                }

            } else {
                ///如果区域个数是奇数
                if (flag == 1) {
                    l1 = mid1;
                    r2 = mid2;

                } else {
                    ///如果区域个数是偶数
                    l1 = mid1 + 1;
                    r2 = mid2;
                }
            }

        }

        return Math.min(arr1[l1], arr2[l2]);

    }

    /**
     * 思路：因为两个数组是有序数组，那么最重要的是，大数组的首位元素在小数组中的索引，那么，这个索引 + 数组长度就是总长度；
     * 根据题目要求可以得到中位数的索引，注意，具体的值，肯定在小数组里面找。因为两数组长度一致
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int findMedianinTwoSortedArayError(int[] arr1, int[] arr2) {
        // write code here
        if (arr1.length == 0) return -1;

        int arr1Length = 0;//记录数组 1 中有效元素的长度

        if (arr1[arr1.length - 1] < arr2[0]) arr1Length = arr1.length;
        else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr2[0] == arr1[i]) {
                    arr1Length = i;
                    break;
                }
            }
        }
        int length = arr1Length + arr2.length;
        int no = length % 2 == 0 ? length / 2 : (1 + length / 2);
        //注意这个 no 不是索引，是第几个数据
        return arr1[no - 1];
    }
}

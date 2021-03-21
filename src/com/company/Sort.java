package com.company;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-21 11:12
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 排序算法汇总
 */
public class Sort {
    @Test
    public void test() {
        int[] arr = new int[10];

        for (int m = 0; m < 10000; m++) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 100 + 1);
            }
            //System.out.print("数组：" + Arrays.toString(arr));
            int[] insertionSort = InsertionSort(arr);
            //System.out.println("排序后：" + Arrays.toString(insertionSort));

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    System.out.println("\nflase");
                    break;
                } else if (i == arr.length - 2) {
                    // System.out.print("true");

                }
            }
        }

    }


    /**
     * 插入排序
     * 是一个对少量元素进行排序的有效算法。
     * 工作机理跟打牌一样：开始摸牌时我们的左手是空的，牌面朝下放在桌面上，依次从桌上抄起一张牌并将它插入左手中正确的位置；
     * 为了找到这辆正确的位置，要将他手中已有的每一张牌从 【右到左】 依次比较。
     * 无论在什么时候左手肿的排都是排好序的，而这些牌首先都是桌上那副牌里最顶上的牌。
     */
    public int[] InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            //这里不需要双层循环，因为左侧 总 是 有序的，只需通过前一个数据判断即可！
            if (arr[i] > arr[j]) continue;
            else {
                int temp = arr[i];
                int k = i - 1;
                for (; k >= 0; k--) {
                    //注意此处，从右向左比较，用 temp 比较因为 arr[i] 被重新赋值了
                    if (arr[k] > temp) arr[k + 1] = arr[k];
                    else break;
                }
                //注意此处 k + 1 不然会报错
                arr[k + 1] = temp;
            }

        }

        return arr;
    }
}

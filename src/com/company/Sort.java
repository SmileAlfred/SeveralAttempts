package com.company;

import javafx.scene.layout.BackgroundRepeat;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-21 11:12
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 排序算法汇总
 * 一、插入排序
 * 二、堆排序
 * 三、归并排序
 * 四、快速排序
 */
public class Sort {

    @Test
    public void test() {


        int[] arr = new int[10];
        //arr = new int[]{7, 2, 4, 7, 9, 8, 5, 9, 5, 8};
        //System.out.println("排序前：" + Arrays.toString(arr));
        //quickSort(arr, 0, arr.length - 1);
        //System.out.println("排序后：" + Arrays.toString(arr));

        for (int m = 0; m < 10000; m++) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 100 + 1);
            }
            System.out.print("排序前：" + Arrays.toString(arr));
            //排序一：插入排序
            //int[] insertionSort = insertionSort(arr);

            //排序二：堆排序
            //int[] heapSort = heapSort(arr);

            //排序三：归并排序
            //mergeSort(arr, 0, arr.length - 1);

            //排序四：快速排序
            quickSort(arr, 0, arr.length - 1);


            System.out.println("\t排序后：" + Arrays.toString(arr));

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
     * 排序四：快速排序
     * 1. 找到 pivot,把小于pivot值放在左侧，大于的值放在右侧，继续递归
     */
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivotVal = arr[left], l = left, r = right;
        while (l < r) {
            while (l < r && arr[r] >= pivotVal) {
                r--;
            }

            while (l < r && arr[l] <= pivotVal) {
                l++;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        arr[left] = arr[l];
        arr[l] = pivotVal;

        quickSort(arr, left, l-1);
        quickSort(arr, l + 1, right);
    }


    /**
     * 排序三：归并排序
     * 两两比较，比较滞后进行交换
     * 这个代码有些难懂！
     */

    public void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1; // (left + right) / 2

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    /**
     * 对小数组两辆对比
     *
     * @param arr   原始数组
     * @param left  左侧索引 → arr1[0]
     * @param mid   两数组长度的一半，实际指向 → arr1[arr1.length -1]
     * @param right 右侧索引 → arr2[arr2.length - 1]
     */
    public void merge(int[] arr, int left, int mid, int right) {
        //1. 创建用来合并的数组
        int[] temp = new int[right - left + 1];
        //j 表示第二个数组的首位 → arr2[0]；k 指向 temp 的索引
        int i = left, j = mid + 1, k = 0;

        //2. 给 temp 装数据
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        //3. 如果有一侧全部插入，那么剩余另一数组全部插入 temp;
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        //for (int p = 0; p < temp.length; p++) {
        //    arr[left + p] = temp[p];
        //}
        //4. 将 temp 覆盖到原数组
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    /**
     * 排序二：堆排序
     * 1. 首先，传入的树，必须是完全二叉树；
     * 2. 其次将其按照从上到下从左到右的顺序排序成数组；
     * 3. 要注意！根节点的索引 root，通过 2 * root + 1 和 2 * root + 2 可以的到子节点的索引；
     * 4. 通过子节点的索引 c1 通过（c1 - 1）/ 2 得到！
     * 5. 操作开始，一定是构建一个 【堆】！完全二叉树且，根节点比子节点数据大！
     * 6. 从下向上把每一个结点进行 heapify ，从而保证最大值在堆顶，此时将堆顶和最后一额元素进行对调，之后，将数组元素 -1 继续进行heapify，递归操作
     */
    public int[] heapSort(int[] arr) {
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            buildHeap(arr, i);
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    /**
     * 1. 对完全二叉树进行排序，如果根节点比子节点小，那么交换；保证根节点比子节点大！
     *
     * @param arr    传入的完全二叉树 数组
     * @param length 还是需要传入的完全二叉树 的结点个数！使用 arr.length 是有局限的
     * @param i      待排序的（根）结点
     */
    public void heapifu(int[] arr, int length, int i) {
        int max = i;
        int c1 = 2 * i + 1;//左子节点的索引
        int c2 = 2 * i + 2;//右子节点的索引
        if (c1 < length && arr[c1] > arr[max]) max = c1;
        if (c2 < length && arr[c2] > arr[max]) max = c2;
        //如果根节点比子节点小，那么交换
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }

    /**
     * 2. 构建堆，
     * 已经写好了 heapify,那么接下来就是构建堆，注意，要逆序！
     *
     * @param arr 表示待构建的树
     * @param n   表示节点个数-1，实际上，树的结点个数在排序过程中实会减少的！
     */
    public void buildHeap(int[] arr, int n) {
        int lastIndex = n;
        int lastNode = (lastIndex - 1) / 2;
        for (int i = lastNode; i >= 0; i--) {
            heapifu(arr, n + 1, i);
        }
    }


    /**
     * 排序一：插入排序
     * 是一个对少量元素进行排序的有效算法。
     * 工作机理跟打牌一样：开始摸牌时我们的左手是空的，牌面朝下放在桌面上，依次从桌上抄起一张牌并将它插入左手中正确的位置；
     * 为了找到这辆正确的位置，要将他手中已有的每一张牌从 【右到左】 依次比较。
     * 无论在什么时候左手肿的排都是排好序的，而这些牌首先都是桌上那副牌里最顶上的牌。
     */
    public int[] insertionSort(int[] arr) {
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

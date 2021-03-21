package com.company.nowcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SmileAlfred
 * @create 2021-03-14 13:59
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=188&tqId=38030&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC22 合并两个有序数组
 * 给出两个有序的整数数组 A和B ，请将数组B 合并到数组A 中，变成一个有序的数组
 * 注意：
 * 可以假设 A数组有足够的空间存放 B数组的元素， A和 B中初始的元素数目分别为 m和n个
 */
public class NC22MergeArr {
    @Test
    public void test() {
        int[] A = new int[15];
        int[] B = new int[15];

        A[0] = 1;
        A[1] = 3;
        A[2] = 35;
        A[3] = 40;
        A[4] = 44;
        B[0] = 5;
        B[1] = 6;
        B[2] = 35;
        B[3] = 43;
        B[4] = 55;

        System.out.println("A:\t" + Arrays.toString(A) + "\nB:\t" + Arrays.toString(B));

        merge3(A, 5, B, 5);
        System.out.println("合并后：\t" + Arrays.toString(A));
    }

    private void merge3(int[] A, int m, int[] B, int n) {

        int aPtr = m - 1, bPtr = n - 1;

        //  两数组元素从右至左比较，大的去 A 尾部，直至有一方指针到头为止
        for (int ptr = m + n - 1; aPtr >= 0 && bPtr >= 0; ptr--) {
            A[ptr] = A[aPtr] > B[bPtr] ? A[aPtr--] : B[bPtr--];
        }
        //  A 指针先走完的情况，B 中剩余元素直接copy至 A 对应位置即可； B先走完，A 不用动；
        while (bPtr >= 0) {
            A[bPtr] = B[bPtr--];
        }

    }

    /**
     * 逆序遍历将尾部的较大值，放在末尾
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    private void merge2(int[] A, int m, int[] B, int n) {
        int index = m + n - 1;
        while (index >= 0 && m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[index] = A[m - 1];
                m--;
            } else {
                A[index] = B[n - 1];
                n--;
            }
            index--;
        }


        if (n > 0) {
            for (int i = n; i > 0; i--) {
                A[index] = B[n - 1];
                n--;
                index--;
            }
        }
    }


    /**
     * 使用队列，有些笨啊
     *
     * @param A 数组A
     * @param m 数组A 中的有效元素个数
     * @param B 数组B
     * @param n 数组B 中的有效元素个数
     */
    public void merge(int A[], int m, int B[], int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                A[i] = B[i];
            }
            return;
        }
        if (n == 0) return;
        Queue<Integer> queueA = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            queueA.add(A[i]);
        }
        Queue<Integer> queueB = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queueB.add(B[i]);
        }

        int index = 0;
        while (!queueA.isEmpty() || !queueB.isEmpty()) {
            int tempA = queueA.isEmpty() ? Integer.MAX_VALUE : queueA.peek();
            int tempB = queueB.isEmpty() ? Integer.MAX_VALUE : queueB.peek();

            if (tempA < tempB) {
                A[index] = tempA;
                queueA.poll();
            } else {
                A[index] = tempB;
                queueB.poll();
            }
            index++;
        }
        /*index = 0;
        while (!queueA.isEmpty()){
            A[index] = queueA.poll();
            index++;
        }*/

    }
}

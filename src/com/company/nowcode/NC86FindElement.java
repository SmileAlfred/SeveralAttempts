package com.company.nowcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-27 14:50
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/3afe6fabdb2c46ed98f06cfd9a20f2ce?tpId=117&tqId=37788&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC86矩阵元素查找
 * 题目描述
 * 已知int一个有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，且矩阵的行和列都是从小到大有序的。设计查找算法返回所查找元素的二元数组，代表该元素的行号和列号(均从零开始)。保证元素互异。
 * <p>
 * 示例1
 * 输入  [[1,2,3],[4,5,6]],2,3,6
 * 返回值  [1,2]
 */
public class NC86FindElement {
    @Test
    public void test() {
        int n = 2, m = 3, count = 1;
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = count++;
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
        int x = 7;
        int[] res = findElement(mat, n, m, x);
        System.out.println(x + " 的索引为：" + Arrays.toString(res));
        System.out.println();


    }

    /**
     * 分治？其实关键的思想在于，起点。若以左上角为起点，判断该点结果小于待查结果，那么怎么走？毕竟向左向右都是递增的！
     * 多以选择右上角，如果该点小向下，如果该点大那么向右！
     * @param mat
     * @param n
     * @param m
     * @param x
     * @return
     */
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int col = m-1, hang = 0;
        while (col >= 0 && hang < n) {
            if (mat[hang][col] == x) return new int[]{hang, col};
            else if (mat[hang][col] > x) {
                col--;
                continue;
            }else{
                hang++;
                continue;
            }
        }

        return new int[]{-1,-1};
    }
}

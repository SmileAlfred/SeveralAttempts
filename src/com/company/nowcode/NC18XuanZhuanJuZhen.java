package com.company.nowcode;

import org.junit.Test;

import javax.xml.transform.Source;

/**
 * @author SmileAlfred
 * @create 2021-03-19 15:41
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/2e95333fbdd4451395066957e24909cc?tpId=188&tqId=38079&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC18顺时针旋转矩阵
 * 题目描述
 * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证 N 小于等于300。
 * <p>
 * 示例1
 * 输入    [[1,2,3],[4,5,6],[7,8,9]],3
 * 返回值  [[7,4,1],[8,5,2],[9,6,3]]
 */
public class NC18XuanZhuanJuZhen {
    @Test
    public void test() {
        int n = 1;
        int[][] mat = new int[n][n];
        int item = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = item++;
            }
        }
        Mat2String(mat);

        int[][] res = rotateMatrix(mat, n);
        System.out.println("旋转后");
        Mat2String(res);


        System.out.println("\n");
        Think mThink = new Think();
        mThink.test();
    }

    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        if (n < 2) return mat;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - i - 1] = mat[i][j];
            }
        }

        return res;
    }

    public void Mat2String(int[][] mat) {
        if (mat.length == 0) return;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }

    }
}

class Think {
    public void test() {
        int n = 5;
        String[][] mat = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = i + "" + j;
            }
        }
        Mat2String(mat);

        String[][] res = rotateMatrix(mat, n);
        System.out.println("\n旋转后\n");
        Mat2String(res);

    }

    public String[][] rotateMatrix(String[][] mat, int n) {
        // write code here
        if (n < 2) return mat;
        String[][] res = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - i - 1] = mat[i][j];
            }
        }

        return res;
    }

    public void Mat2String(String[][] mat) {
        if (mat.length == 0) return;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
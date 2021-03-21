package com.company.nowcode;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.ArrayList;

/**
 * @author SmileAlfred
 * @create 2021-03-17 19:58
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/7edf70f2d29c4b599693dc3aaeea1d31?tpId=188&tqId=38051&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * <p>
 * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 * 示例1
 * 输入  [[1,2,3],[4,5,6],[7,8,9]]
 * 返回值  [1,2,3,6,9,8,7,4,5]
 */
public class NC38LuoXuanJuZhen {
    @Test
    public void test() {
        int n = 3;
        int[][] matrix = new int[2][1];
        int val = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = val++;
            }
        }

        System.out.println("矩阵如下：");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        ArrayList<Integer> list = spiralOrder(matrix);
        //System.out.println("逆序输出结果：" + list);


    }

    private ArrayList<Integer> spiralOrder(int[][] matrix) {
        //  1 2 3    螺旋 1 2 3 6 9 8 7 4 5
        //  4 5 6
        //  7 8 9
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top < (matrix.length + 1) / 2 && left < (matrix[0].length + 1) / 2) {
            //上面  左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }

            //右边 上到下
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }

            //下面  右到左
            for (int i = right - 1; top != bottom && i >= left; i--) {
                res.add(matrix[bottom][i]);
            }

            //左边 下到上
            for (int i = bottom - 1; left != right && i >= top + 1; i--) {
                res.add(matrix[i][left]);
            }
            ++top;
            --bottom;
            ++left;
            --right;
        }
        return res;
    }


    /**
     * 可行，但是不太好，笨……
     *
     * @param matrix
     * @return
     */
    private ArrayList<Integer> mSpiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) return res;

        int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;
        System.out.println("left = " + left + " ; right = " + right + " ; top = " + top + " ; bottom = " + bottom);
        int i = 0, j = 0;

        while (left < right && top < bottom) {
            if (i == top && j == left) {
                //此时在左上角，向右走
                for (; j < right; j++) {
                    res.add(matrix[i][j]);
                }
                top++;
                i++;
            }
            System.out.println("向 右 走后:i = " + i + " ; j = " + j + ";" + res);
            if (i == top && j == right) {
                //此时在右上角，向下走
                j--;
                for (; i < bottom; i++) {
                    res.add(matrix[i][j]);
                }
                right--;
            }
            System.out.println("向 下 走后:i = " + i + " ; j = " + j + ";" + res);

            if (i != top && i == bottom && j == right) {
                //此时在右下角，向左走
                i--;
                j--;
                for (; j >= left; j--) {
                    res.add(matrix[i][j]);
                }
                j++;
                bottom--;
            }
            System.out.println("向 左 走后:i = " + i + " ; j = " + j + ";" + res + " ; top = " + top);
            if (j != right && i == bottom && j == left) {
                //此时在左下角，向上走
                i--;
                for (; i >= top; i--) {
                    res.add(matrix[i][j]);
                }
                left++;
            }
            System.out.println("向 上 走后:i = " + i + " ; j = " + j + ";" + res + "上下左右" + top + " ; " + bottom + " ; " + left + " ; " + right);
            i = top;
            j = left;
            System.out.println();

        }


        return res;
    }

    /**
     * 写错了呀！人家是螺旋输出，是回字形输出，不是一条龙的；
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> spiralOrderHui(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i % 2 == 0) {
                    res.add(matrix[i][j]);
                } else {
                    res.add(i * matrix.length, matrix[i][j]);
                }
            }
        }
        //1, 2, 3, 6, 5, 4, 7, 8, 9
        return res;
    }
}

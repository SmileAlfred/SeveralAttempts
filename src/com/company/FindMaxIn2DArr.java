package com.company;

import com.company.nowcode.StackAsQueue;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-09-26 14:58
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description：找出二维数组中的最大值
 */
public class FindMaxIn2DArr {
    private static DecimalFormat decimalFormat = new DecimalFormat("00.00");
    private static double[][] dArr;
    private static int count = 250;

    public static void main(String[] args) {
        /*for (int i = 0; i < 100; i++) {
            //获取随机数
            double round = Math.random() * 2 - 1;
            //格式化数据
            System.out.println(decimalFormat.format(round));
        }*/

        dArr = get2DArr(count);
        int i = (int) (Math.random() * count);
        int j = (int) (Math.random() * count);
        System.out.println("起始:["  + i + "," + j + "] = " + dArr[i][j]);
        //int[] res = findMax(i, j, count);
        findMaxPower(0, i, j, step);
        System.out.println("粗调:[" + x1 + "，" + y1 + "] = " + maxV);
        findMaxPower(maxV, x1, y1, microStep);
        System.out.println("微调:[" + x1 + "，" + y1 + "] = " + maxV);

        //System.out.println("最大值在：" + Arrays.toString(res) + " 值为：" + dArr[res[0]][res[1]]);
    }

    /**
     * 递归回溯实现
     * 注意：此处没有找到合适的递归跳出语句；仅仅是在获取到最大值时得到了最大值；
     * 另外；准确度和递归的步长step和数据的密度间关系，密切相关，要巧妙地调整；
     * 策略应该根据实际地镜子进行调整，因为，如果镜子最大位置在右下，那么算法地策略就是游侠左上；所以此处地策略有瑕疵地。
     *
     * @param preMaxPower
     * @param i
     * @param j
     */
    private static int step = count/10, microStep = 1;
    private static int x1 = -1, y1 = -1;
    private static double maxV = -1;

    private static boolean findMaxPower(double preMaxPower, int i, int j, int autoStep) {
        if (i < 0 || j < 0 || i >= dArr.length || j >= dArr.length || dArr[i][j] < preMaxPower) {
            return false;
        } else {
            if (i > 0 && findMaxPower(dArr[i][j], i - autoStep, j, autoStep)) {//向左
                i = step;
                return true;
            } else if (i < dArr.length && findMaxPower(dArr[i][j], i + autoStep, j, autoStep)) {//向右
                i += step;
                return true;
            } else if (j < dArr.length && findMaxPower(dArr[i][j], i, j + autoStep, autoStep)) {//向下
                j += step;
                return true;
            } else if (j > 0 && findMaxPower(dArr[i][j], i, j - autoStep, autoStep)) {//向上
                j -= step;
                return true;
            } else {
                //System.out.println("第 " + num++ + " 次递归：i = " + i + " ; j = " + j + " ; maxValue = " + dArr[i][j]);
                if (dArr[i][j] > maxV) {
                    maxV = dArr[i][j];
                    x1 = i;
                    y1 = j;
                }
                return false;
            }
        }
    }

    /**
     * 找到最大值的 i 和 j
     * 思路，如果 左大 且 右小那么左移；而后比较上下，如果左右均大则比较左右，而后记录位置，如果左右均小不处理；
     * 可递归，可循环
     * 【局部】最大；并非全部的最大
     *
     * @param i 起始 X
     * @param j 起始 Y
     * @return 最大值的 i j 坐标
     */
    private static int[] findMax(int i, int j, int count) {

        while (true) {
            if (i < count && dArr[i][j] > dArr[i + 1][j] && dArr[i][j] < dArr[i - 1][j]) i--;
            else if (i < count && dArr[i][j] < dArr[i + 1][j] && dArr[i][j] > dArr[i - 1][j]) i++;
            else if (i > 0 && dArr[i][j] < dArr[i + 1][j] && dArr[i][j] < dArr[i - 1][j])
                i = (i < count && i > 0 && dArr[i + 1][j] > dArr[i - 1][j]) ? ++i : --i;

            if (j < count && dArr[i][j] > dArr[i][j + 1] && dArr[i][j] < dArr[i][j - 1]) j--;
            else if (dArr[i][j] < dArr[i][j + 1] && dArr[i][j] > dArr[i][j - 1]) j++;
            else if (dArr[i][j] < dArr[i + 1][j] && dArr[i][j] < dArr[i - 1][j])
                j = (dArr[i][j + 1] > dArr[i][j - 1]) ? ++j : --j;
            if (i < count && j > 0 && i > 0 && j < count &&
                    dArr[i][j] > dArr[i + 1][j] &&
                    dArr[i][j] > dArr[i][j - 1] &&
                    dArr[i][j] > dArr[i - 1][j] &&
                    dArr[i][j] > dArr[i][j + 1]
            ) break;
        }
        return new int[]{i, j};
    }

    /**
     * 创建50×50的二维 高斯型 数组
     */
    private static double[][] get2DArr(int count) {
        double[][] arr = new double[count][count];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) arr[0][0] = 1;
            else if (i < arr.length / 2 + 1) arr[i][0] = arr[i - 1][0] + 1;
            else arr[i][0] = arr[i - 1][0] - 1;
            for (int j = 1; j < arr[0].length; j++) {
                if (i < arr.length / 2 + 1 && j < arr[0].length / 2 + 1) {
                    arr[i][j] = arr[i][j - 1] + 1;
                } else if (i > arr.length / 2 && j < arr[0].length / 2 + 1) {
                    arr[i][j] = arr[i][j - 1] + 1;
                } else if (i < arr.length / 2 + 1 && j > arr[0].length / 2) {
                    arr[i][j] = arr[i][j - 1] - 1;
                } else if (i > arr.length / 2 && j > arr[0].length / 2) {
                    arr[i][j] = arr[i][j - 1] - 1;
                }
                double round = 0;
                //double round = Math.random() * 3 - 1.5;
                //格式化数据
                arr[i][j] = Double.parseDouble(decimalFormat.format(arr[i][j] + round));
            }
        }

        double max = 0;
        int X = 0, Y = 0;
        //打印
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > max) {
                    X = i;
                    Y = j;
                    max = arr[i][j];
                }
                //System.out.print(arr[i][j] + " ");
            }
            //System.out.println("");
        }
        System.out.println("理论最大值在:[" + X + "," + Y + "];值为：" + max);
        return arr;
    }

}

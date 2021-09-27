package com.company.nowcode;

import org.junit.Test;

/**
 * @author SmileAlfred
 * @create 2021-03-28 9:33
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/166eaff8439d4cd898e3ba933fbc6358?tpId=117&tqId=37736&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC34求路径
 * 题目描述
 * 一个机器人在m×n大小的地图的左上角（起点）。
 * 机器人每次向下或向右移动。机器人要到达地图的右下角（终点）。
 * 可以有多少种不同的路径从起点走到终点？
 * ----------------------------------
 * |起点|   |   |   |   |   |   |   |
 * ----------------------------------
 * |   |   |   |   |   |   |   |   |
 * ----------------------------------
 * |   |   |   |   |   |   |   |   |
 * ----------------------------------
 * |   |   |   |   |   |   |   |终点|
 * ----------------------------------
 * 备注：m和n小于等于100,并保证计算结果在int范围内
 * <p>
 * 示例1
 * 输入  2,1
 * 返回值  1
 * 示例2
 * 输入  2,2
 * 返回值  2
 */
public class NC34DynamicPath {

    @Test
    public void test() {
        int m = 2, n = 2;
        int res = uniquePaths(m, n);
        System.out.println("在 " + m + " x " + n + " 的矩阵中，从左上角到右下角共有 " + res + " 条路经");
    }

    /**
     * 智慧解法：
     * 首先，我们可以发现第一行和第一列的位置只能有一种方法到达
     * 对于其它位置来说，到达这个位置有两种情况：
     * 一种是从上面的格子走过来的     * 另一种是从左边的格子走过来的
     * 所以，我们定义一个𝑚×𝑛大小的二维数组𝑑𝑝
     * 𝑑𝑝[𝑖][𝑗]表示从起点到达第𝑖行第𝑗列的方案数。
     * 先把第一行第一列赋值为 1
     * 然后从第二行第二列的元素开始循环
     * 𝑑𝑝[𝑖][𝑗]=𝑑𝑝[𝑖−1][𝑗]+𝑑𝑝[𝑖][𝑗−1]
     * 右下角的dp值就是我们要求的答案
     *
     * @param m
     * @param n
     * @return
     */
    private int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        //第一列赋值为1
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        //第一行赋值为1
        for (int j = 1; j <= n; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    /**
     * 题目写的是简单，提示有动态规划，可我怎么那么想用递归呢？又是想到了优惠券的问题
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsError(int m, int n) {
        // write code here
        /**
         * 从{右、下}中选取办法，当坐标到达 (m,n) 为止；
         * 情况分为三种
         * 1. 在中间，此时 右、下 都可以走；
         * 2. 在上、下两条边，只能向右走；
         * 3. 在最右边时，只能向下走
         */
        //写不下去了，感觉可以使用购物券一样解题，奈何……
        return -1;
    }

}

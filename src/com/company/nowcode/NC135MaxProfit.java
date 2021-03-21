package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author SmileAlfred
 * @create 2021-03-18 10:17
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/4892d3ff304a4880b7a89ba01f48daf9?tpId=188&tqId=38038&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC135股票交易最大收益（）二
 * 题目描述
 * 假定你知道某只股票每一天价格的变动。
 * 你最多可以同时持有一只股票。但你最多只能进行两次交易（一次买进和一次卖出记为一次交易。买进和卖出均无手续费）。
 * 请设计一个函数，计算你所能获得的最大收益。
 * 示例1
 * 输入  [8,9,3,5,1,3]
 * 返回值  4
 */
public class NC135MaxProfit {
    @Test
    public void test() {
        int[] prices = new int[]{8, 9, 3, 5, 1, 3};
        int maxProfit = maxProfit(prices);
        //System.out.println("数组：" + Arrays.toString(prices) + " 中，最大收益为：" + maxProfit);
    }

    /**
     * 这题的难点在于如何处理第二次交易。
     * 我首先从后往前遍历数组，f[i]表示从i点开始到结尾 进行的一次交易的最大收益。
     * 第二次交易处理完了，就可以用常见的方法进行类似一次交易，每次比较时再加上对应的f[i+1]即可。
     * res  = Math.max(res,prices[i]-min + f[i+1]);
     * 最后需要注意一点，并没有要求一定要进行两次交易。
     */
    public int maxProfit2(int[] prices) {
        // write code here
        int n = prices.length;
        if (n < 2) return 0;

        //从后往前遍历,f[i] 表示从i点到之后的一次交易的最大收益
        int[] f = new int[n];
        int max = prices[n - 1];
        f[n - 1] = 0;    //初始化
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            f[i] = Math.max(f[i + 1], max - prices[i]);
        }
        System.out.println("prices " + Arrays.toString(prices));
        System.out.println("f[]    " + Arrays.toString(f));
        int res = 0;
        //从前往后遍历
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("min =  Math.min -> min =  " + min + " | prices[" + i + "] = " + prices[i]);
            min = Math.min(min, prices[i]);
            System.out.println("res =  Math.max -> res =  " + res + " | prices[" + i + "] = " + prices[i] + " - min = " + min + " + f[" + (i + 1) + "] = " + f[i + 1]);
            res = Math.max(res, prices[i] - min + f[i + 1]);
        }
        return res;
    }

    /**
     * https://blog.nowcoder.net/n/e8fb8be2723d45cb9e941149abe4d7c0?f=comment
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // write code here
        if (prices.length == 0) return 0;
        /**
         * 5个状态：1）不操作2）第一次购买3）第一次卖出4）第二次购买5）第二次卖出
         *         dp[i][j]代表第i天状态为j时产生的最大收益
         */
        int[][] dp = new int[prices.length][5];
        //初始化
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            //其中dp[i][1]有两个操作1）第i天没有操作2）第i天买入股票，所以此时最大收益，应该为这两个操作比大小
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //其中dp[i][2]有两个操作1）第i天没有操作2）第i天卖出股票，所以此时最大收益，应该为这两个操作比大小
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            //其中dp[i][3]有两个操作1）第i天没有操作2）第i天买入股票，所以此时最大收益，应该为这两个操作比大小
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            //其中dp[i][4]有两个操作1）第i天没有操作2）第i天卖出股票，所以此时最大收益，应该为这两个操作比大小
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];

    }

}

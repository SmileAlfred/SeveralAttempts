package com.company.nowcode;

import org.junit.Test;

/**
 * @author SmileAlfred
 * @create 2021-03-09 15:32
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 假设你有一个数组，其中第  i 个元素是股票在第   i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 */
public class MaxProfit {

    @Test
    public void test() {
        int[] arr1 = {1, 3, 2, 0, 7, -1};
        System.out.println(MaxProfit(arr1));
        int[] arr2 = {4, 3, 2, 0, 7, -1};
        System.out.println(MaxProfit(arr2));

        int[] arr3 = {1, 2, -1, -3, 5};
        System.out.println("贪心算法×：" + MaxProfit1(arr3) + "\t动态规划√：" + MaxProfit(arr3)+"\t贪心二×：" + MaxProfit2(arr3));
    }

    public int MaxProfit(int[] prices) {
        // write code here
        int minVal = prices[0], profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            //if (prices[i] < minVal) minVal = prices[i];
            minVal = Math.min(minVal, prices[i]);
            profit = Math.max(profit, prices[i] - minVal);
        }
        return profit;
    }

    //贪心算法二:代码有问题，结果不正确
    public int MaxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }

    //贪心算法：代码有问题，结果不正确
    public int MaxProfit1(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            //同样，本体也是只要最后的结果！所以，只要最好的结果，只要下一天是正收益，那就加上
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                ans += diff;
            }
        }
        return ans;
    }
}

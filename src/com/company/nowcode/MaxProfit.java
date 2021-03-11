package com.company.nowcode;

import org.junit.Test;

/**
 * @author SmileAlfred
 * @create 2021-03-09 15:32
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description
 * 假设你有一个数组，其中第  i 个元素是股票在第   i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 */
public class MaxProfit {

    @Test
    public void test(){
        int[] arr1 = {1,3,2,0,7,-1};
        System.out.println(MaxProfit(arr1));
        int[] arr2 = {4,3,2,0,7,-1};
        System.out.println(MaxProfit(arr2));
    }

    public int MaxProfit(int[] prices){
        // write code here
        int minVal = prices[0], profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            //if (prices[i] < minVal) minVal = prices[i];
            minVal = Math.min(minVal,prices[i]);
            profit = Math.max(profit, prices[i] - minVal);
        }
        return profit;
    }
}

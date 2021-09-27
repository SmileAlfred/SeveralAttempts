package com.company.nowcode;

import org.junit.Test;

/**
 * @author SmileAlfred
 * @create 2021-03-27 15:14
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://blog.nowcoder.net/n/0abe873e758e43b398dc8ac98c592dda?f=comment
 * NC35最小编辑代价   较难
 * 题目描述
 * 给定两个字符串str1和str2，再给定三个整数 ic，dc 和 rc，分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。
 * 示例1
 * 输入  "abc","adc",5,3,2
 * 返回值  2
 * 示例2
 * 输入  "abc","adc",5,3,100
 * 返回值  8
 * 备注:
 * 1 ≤ |str_1|, |str_2| ≤ 5000
 * 1 ≤ ic, dc, rc ≤ 10000
 */
public class NC35MinEditCost {
    @Test
    public void test() {
        String str1 = "abc", str2 = "abc";
        int ic = 5, dc = 3, rc = 2;
        int res = minEditCost(str1, str2, ic, dc, rc);
        System.out.println(str1 + " 变换成 " + str2 + " 的最小编辑代价是:" + res);
    }

    /**
     * 动态规划(优化空间)：因为根据未优化版本可得知，求解dp[i][j]只需要直到dp[i-1][j-1],dp[i][j-1],dp[i-1][j]
     * 不需要之后的数据，则可轻易得知，我们可以将其化为一维数组dp[n+1]的动态数组
     * 首先需要初始化 dp[0][i]->先给dp赋值完成
     * 使用一个prev存储dp[i-1][j-1],每当读取当前dp[i]时，将其用一个temp存储下来，当做当前的dp[i-1][j]以及下一个的dp[i-1][j-1]即可
     *
     * @param str1
     * @param str2
     * @param ic
     * @param dc
     * @param rc
     * @return
     */
    public int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        int m = str1.length();
        int n = str2.length();
        //初始化一位动态数组
        int[] dp = new int[n + 1];
        //初始化dp[0][i]
        for (int i = 1; i <= n; i++) {
            dp[i] = i * ic;
        }

        //开始遍历
        for (int i = 1; i <= m; i++) {
            char c1 = str1.charAt(i - 1);
            int prev = dp[0];
            dp[0] = i * dc;
            for (int j = 1; j <= n; j++) {
                char c2 = str2.charAt(j - 1);
                //获取dp[i-1][j]
                int temp = dp[j];
                if (c1 == c2) {
                    dp[j] = prev;
                } else {
                    int insert = dp[j - 1] + ic;
                    int delete = temp + dc;
                    int replace = prev + rc;
                    dp[j] = Math.min(insert, Math.min(delete, replace));
                }
                //更新dp[i-1][j-1]的局部变量
                prev = temp;
            }
        }
        return dp[n];
    }


    /**
     * 方法一、未优化版本
     * 较难的动态规划题目(主要要着眼于三个基本操作带来的操作)：
     * 如果选择将str1的前i个字符转换为str2的前j个字符则需要分类讨论->dp[i]
     * 如果str1[i] == str2[j]->则只需要将前i-1个字符转换为前j-1个字符即可，最后一个字符不动：dp[i][j] = dp[i-1][j-1]
     * 如果str1[i] != str2[j]->分三类操作：
     * 1.插入：将i个字符串转变为前j-1个字符串在插入第j个字符->dp[i][j-1]+ic
     * 2.删除：将i-1个字符串转换为前j个字符串删除第i个字符->dp[i-1][j]+dc
     * 3.替换：将i-1个字符串转换为前j-1个字符串替换掉第i个字符为第j个字符->dp[i-1][j-1]+rc
     * 取最小的即可
     */
    // write code here
    public int minEditCost1(String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int m = str1.length();
        int n = str2.length();
        //初始化dp[0][i]与dp[i][0]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i * dc;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i * ic;
        }

        //开始遍历
        for (int i = 1; i <= m; i++) {
            char c1 = str1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //分类讨论，找到最小代价
                    int insert = dp[i][j - 1] + ic;
                    int delete = dp[i - 1][j] + dc;
                    int replace = dp[i - 1][j - 1] + rc;
                    dp[i][j] = Math.min(replace, Math.min(delete, insert));
                }
            }
        }
        return dp[m][n];
    }

}
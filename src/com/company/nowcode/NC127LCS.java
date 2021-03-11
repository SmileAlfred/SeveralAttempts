package com.company.nowcode;

import org.junit.Test;

/**
 * @author SmileAlfred
 * @create 2021-03-11 10:20
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 给定两个字符串str1和str2, 输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 * 输入："1AB2345CD","12345EF" 返回值  "2345"
 */
public class NC127LCS {
    @Test
    public void test() {
        String str = "1AB2345CD", str2 = "12345EF";
        String lcs = LCS(str, str2);
        System.out.println(str + " 和 " + str2 + " 中最长公共子串是： " + lcs);
    }

    /**
     * 动态规划 大神写法
     * 这里dp的索引是从1开始，0位是防止数组越界，并且也有实际意义，可以理解为空子串，结果自然也是0
     * <p>
     * 还有几个优化的点
     * <p>
     * 最大公共子串的出现，必然发生在有字符相等的时候。这个应该很好理解，所以算法里只关心出现这个情况的dp值，
     * 但是同时需要注意，此时dp里记录的值不再是连续的值了，不能再认为dp[i][j]描述的是str1中从0~i与str2中从0~j的最大公共子串，
     * 此时的dp记录值有点类似滑动窗口了，某一段时间内是持续增长的，所以 他 用 maxLen来记录出现的最大值
     * 几个临时变量存储。首先是 maxLen 和 x，这两个变量描述了一个子串，当出现更大的字串时更新这两个值；还有ch1和ch2，也有一定性能优化
     * 从上面的分析可以发现，效率优化了，但是理解变困难了，
     *
     * @param str1
     * @param str2
     * @return
     */
    public String LCS(String str1, String str2) {
        // write code here

        if (str1.isEmpty() || str2.isEmpty()) return "-1";
        int n1 = str1.length(), n2 = str2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        int maxLen = 0, x = 0;
        for (int i = 1; i <= n1; i++) {
            char ch1 = str1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                char ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    //这几句是关键！dp[i - 1][j - 1] 记录了两个 str 的上一个 字符是否相等！若不等值为0；若想等即 该点前相同字串的长数
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        x = i;
                    }
                }
            }
        }

        return maxLen == 0 ? "-1" : str1.substring(x - maxLen, x);

    }
}

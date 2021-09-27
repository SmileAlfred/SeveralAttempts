package com.company.nowcode;

import org.junit.Test;

import javax.xml.transform.Source;

/**
 * @author SmileAlfred
 * @create 2021-03-31 8:17
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/6d29638c85bb4ffd80c020fe244baf11?tpId=117&tqId=37798&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC92最长公共子序列
 * 题目描述
 * 给定两个字符串str1和str2，输出连个字符串的最长公共子序列。如过最长公共子序列为空，则输出-1。
 * 示例1
 * 输入  "1A2C3D4B56","B1D23CA45B6A"
 * 返回值 "123456"
 * 说明
 * "123456"和“12C4B6”都是最长公共子序列，任意输出一个。
 * 备注:
 * 1 ≤ |str_1|, |str_2| ≤ 5,000
 */
public class NC92LongestGongGongSubQue {
    @Test
    public void test() {
        String s1 = "1A2C3D4B56", s2 = "B1D23CA45B6A";
        String lcs = LCS(s1, s2);
        System.out.println(s1 + " 和 " + s2 + " 中最长公共子序列是：" + lcs);
    }

    // LCS（longest common sequence（还有另一种LCS,longest common string，中文名为最长公共子串，
    // 他和sequence的区别是，sequence不要求连续，string要求连续））
    public static String LCS(String s1, String s2) {
        int row = s1.length();
        int column = s2.length();
        //注意dp的长度问题，是 s1.length+1 与 s2.length+1，为什么要加 1 呢，虽然 s1,s2 的索引范围为[0,row-1],[0,column-1]
        //但是要多记录一种情况即s1和s2为空字符串的情况，使用dp[i][0]与dp[0][j]来记录，那么肯定为 0，dp[0][j]与dp[i][0]使用默认的0就行。
        //所以dp的行数范围为[0,row],列数范围为[0,column]，比s1和s2的长度多1，即dp[i,j]表示s1长度为i-1，s2长度为j-1的最长公共子序列的长度,.
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < column + 1; j++) {
                //dp[i,j]表示s1长度为i-1，s2长度为j-1的最长公共子序列的长度，所以这里要比较s1.charAt(i - 1) == s2.charAt(j - 1)
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        //目前dp记录了s1和s2的最长子序列的长度
        //最长子序列长度为0时，按照题意输出-1；
        if (dp[row][column] == 0) return "-1";
        // lcs用来储存结果数组
        char[] lcs = new char[dp[row][column]];
        // 因为要对dp倒着查看，所以lcs也倒着插入，cur表示当前插入的位置
        int cur = lcs.length - 1;
        /**
         * 插入的思想：
         *若dp[8][9] = 5，且S1[7] != S2[8]，所以倒推回去，dp[8][9]的值来源于dp[8][8]与dp[7][9]的值的最大值。根据情况让row-1或者column-1。
         *若dp[8][9] = 5, 且S1[7] = S2[8], 所以倒推回去，dp[8][9]的值来源于 dp[7][8]。row-1且column-1。
         *有种特殊情况：
         *若dp[8][9] = 5,且S1[7] != S2[8] ，且dp[8][8] = c[7][9] 这种存在分支的情况，这里请都选择一个方向（之后遇到这样的情况，也选择相同的方向）。
         *最长子序列的解不是唯一的，在每次遇到dp[8][9] = 5,且S1[7] != S2[8] ，且dp[8][8] = c[7][9]这种情况时，选择不同的方向就会造成不同的解。
         *牛客的示例中是向左走，参考的算法的网站中是向上走的~怎么走都可以。
         */
        while (true) {
            // s1.charAt(row - 1) == s2.charAt(column - 1)时，就记录下当前的字符
            if (s1.charAt(row - 1) == s2.charAt(column - 1)) {
                //记录字符
                lcs[cur--] = s1.charAt(row - 1);
                //cur<0即意味着lcs已经填充完毕，直接return吧
                if (cur < 0) return new String(lcs);
                row--;
                column--;
            } else {
                // s1.charAt(row - 1) != s2.charAt(column - 1)时，就比较dp[row - 1][column] 和 dp[row][column - 1]
                // 这里用的是>而不是>=，所以dp[row - 1][column] ==dp[row][column - 1]时，走的是左边~
                if (dp[row - 1][column] > dp[row][column - 1]) {
                    //走上面，row--
                    row--;
                } else {
                    //走左面，column--
                    column--;
                }
            }
        }
    }

    /**
     * longest common subsequence
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String mLCS(String s1, String s2) {
        // 思路：题目提示是冬天规划解决，动态规划的话，一般不都是新建一个 dp[m+1][n+1]，将可能的结果存放在首行首列，
        // 而后通过递归的发过誓对每一个位置赋值，最后选出最大值。
        return "";
    }
}

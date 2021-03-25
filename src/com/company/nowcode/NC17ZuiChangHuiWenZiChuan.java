package com.company.nowcode;

import org.junit.Test;

/**
 * @author SmileAlfred
 * @create 2021-03-22 13:22
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=117&tqId=37789&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC17最长回文子串
 * 题目描述
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。给定字符串A以及它的长度n，请返回最长回文子串的长度。
 * 示例1
 * 输入  "abc1234321ab",12
 * 返回值  7
 */
public class NC17ZuiChangHuiWenZiChuan {


    @Test
    public void test() {
        String A = "abc1234321cab";
        int n = A.length();
        int longestPalindrome = getLongestPalindrome(A, n);
        System.out.println(A + " 中最长回文子串是：" + longestPalindrome);
    }

    /**
     * ???动态规划法，应该是题目所希望的样子：https://blog.nowcoder.net/n/54d0da6bc6df40a782d59c48606a5cb0?f=comment
     * 注意字符串的遍历顺序一定是从后向前的，因为这样才能解决之前没有计算而直接出答案的问题。
     * 这里的dp数组比较难想，是应该存储所经过的子字符串是否是回文数
     *
     * @param A
     * @param n
     * @return
     */
    public static int getLongestPalindrome(String A, int n) {
        // write code here
        char[] aa = A.toCharArray();
        int max = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++)//i指向的是字符的最后一位
            for (int j = i - 1; j >= 0; j--) {//j指向的是字符的前部。
                if (i - j == 1) {//当两个指针靠近时，直接判断
                    dp[j][i] = (aa[i] == aa[j]);
                    max = max < i - j + 1 ? i - j + 1 : max;
                } else {
                    if (dp[j + 1][i - 1] && aa[i] == aa[j]) {
                        dp[j][i] = true;
                        max = max < i - j + 1 ? i - j + 1 : max;
                    } else dp[j][i] = false;
                }
            }
        return max;
    }


    /**
     * 中心扩散法：https://blog.nowcoder.net/n/8f3cdfd619724ae08ab916d456ff579c?f=comment
     * 其实复杂度也是 > n,这是肯定的，但是效率高了很多！
     *
     * @param A
     * @param n
     * @return
     */
    public int getLongestPalindrome1(String A, int n) {
        if (n == 0)
            return 0;
        int maxLen = 1;
        //中心枚举到n-2位置
        for (int i = 0; i < n - 1; i++) {
            // 比较以i为中心扩散的回文子串 && 以i和i+1为中心扩散的回文子串 哪个大取哪个 ← 就比较巧妙
            int len = centerSpread1(A, i, i) > centerSpread1(A, i, i + 1) ? centerSpread1(A, i, i) : centerSpread1(A, i, i + 1);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    //若left==right 则扩散中点为一个，此时的回文子串为奇数
    //若left!=right，则扩散的中点为 left和right，此时的回文子串为偶数
    public int centerSpread1(String s, int left, int right) {
        int len = s.length();
        int l = left;
        int r = right;
        while (l >= 0 && r <= len - 1) {
            //若相等则继续扩散
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        //为什么还要减2  因为上面while循环终止了，此时s.charAt(l) != s.charAt(r)
        //所以此时的回文子串的左右边界其实是  l-1，  r-1
        return r - l + 1 - 2;
    }


    /**
     * 双指针，两次便利的方法，复杂度 n²
     * 太暴力，复杂度太大！
     *
     * @param A
     * @param n
     * @return
     */
    public int mGetLongestPalindrome(String A, int n) {
        // write code here
        int left = 0, right = n - 1, maxLength = 0;
        for (int i = 0; i < n; i++) {
            //这一层是 左指针依次右移；
            for (int j = n - 1; j > i; j--) {
                //这一层是 右指针 依次左移，判断是否是回文数；
                String str = A.substring(i, j + 1);
                int res = mIsHuiWen(str);
                if (res > 0) {
                    maxLength = Math.max(maxLength, res);
                    break;
                }
            }
        }
        return maxLength;
    }

    public int mIsHuiWen(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return -1;
            l++;
            r--;
        }
        return str.length();
    }
}

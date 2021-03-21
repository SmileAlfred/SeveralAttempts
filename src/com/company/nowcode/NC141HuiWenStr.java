package com.company.nowcode;

import org.junit.Test;

/**
 * @author SmileAlfred
 * @create 2021-03-17 21:52
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/e297fdd8e9f543059b0b5f05f3a7f3b2?tpId=188&tqId=38054&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * 题目描述
 * 给定一个字符串，请编写一个函数判断该字符串是否回文。如果回文请返回true，否则返回false。
 */
public class NC141HuiWenStr {
    @Test
    public void test() {
        String str = "abs1ba";
        boolean judge = judge(str);
        System.out.println(str + " 回文？ " + judge);
    }


    public boolean judge(String str) {
        // write code here
        if(str.length()<2)return true;
        int left = 0;
        int right = str.length() - 1;
        boolean res = true;
        while (left < right) {
            char lChar = str.charAt(left);
            char rChar = str.charAt(right);
            if (lChar == rChar) {
                left++;
                right--;
            } else return false;
        }
        return res;
    }
}

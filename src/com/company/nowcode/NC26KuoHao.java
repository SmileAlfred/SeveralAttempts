package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author SmileAlfred
 * @create 2021-03-19 16:43
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/c9addb265cdf4cdd92c092c655d164ca?tpId=188&tqId=38081&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC26括号生成
 * 题目描述
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())",
 * 示例1
 * 输入  1
 * 返回值  ["()"]
 * 示例2
 * 输入  2
 * 返回值  ["(())","()()"]
 */
public class NC26KuoHao {
    @Test
    public void test() {
        int n = 3;
        ArrayList<String> list = generateParenthesis(n);
        System.out.println(n + " 对括号的组合：" + list);
    }

    public ArrayList<String> generateParenthesisError(int n) {
        // write code here
        ArrayList<String> res = new ArrayList<String>();
        //1. 首位末尾肯定分别是 （ 和 ）；得出所有的组合形式

        //2. 把 （ 看作 -1，）看作 1，计算过程中，前一个符号是 （ 时才可以加 ），即如果前方已经饱和，和为 0 了，不可以再加 ）；

        return res;
    }


    /**
     * 来自文章 https://blog.nowcoder.net/n/41828456916a4f239a29c25e3a139fc5?f=comment
     * 递归搜索，尝试增加括号，如果剩余的括号里左括号多于右括号，则不可能完成任务，抛弃结果；
     * 如果没有括号剩下，那么任务完成，把结果temp添加到ans。
     * 注意python没有传参，需要不断对原list对象赋值。
     *
     * @param n
     * @return
     */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        return recurve(n, n, "", list);
    }

    /**
     *
     * @param left 左括号的个数
     * @param right 右括号的个数
     * @param temp  拼接的字符串
     * @param res   用于返回的集合；
     * @return
     */
    public ArrayList<String> recurve(int left, int right, String temp, ArrayList<String> res) {
        if (left > right) return res;
        if (left == 0 && right == 0) res.add(temp);
        else {
            if (left > 0) res = recurve(left - 1, right, temp + "(", res);
            if (right > 0) res = recurve(left, right - 1, temp + ")", res);
        }
        return res;
    }

}

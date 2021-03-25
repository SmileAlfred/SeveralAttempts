package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author SmileAlfred
 * @create 2021-03-24 10:18
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/c215ba61c8b1443b996351df929dc4d4?tpId=117&tqId=37849&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC137表达式求值
 * 题目描述
 * 请写一个整数计算器，支持加减乘三种运算和括号。
 * 示例1
 * 输入  "1+2"
 * 返回值  3
 * 示例2
 * 输入  "(2*(3-4))*5"
 * 返回值  -10
 * 示例3
 * 输入  "3+2*3*4-1"
 * 返回值  26
 */
public class NC137Calculate {
    @Test
    public void test() {
        //复杂情况1：多位数
        String str1 = "100+2";
        int solve1 = solve(str1);
        System.out.println(str1 + " = " + solve1);
        String str2 = "(2*(3-4))*5";
        int solve = solve(str2);
        System.out.println(str2 + " = " + solve);
        String str3 = "3+2*3*4-1";
        System.out.println(str3 + " = " + solve(str3));
        //复杂情况2
        String str4 = "((10+2)*10-(100-(10+20*10-(2*3)))*10*1*2)-2";
        int solve4 = solve(str4);
        System.out.println(str4 + " = " + solve4);
        //复杂情况3
        String str5 = "1-2-3";
        int solve5 = solve(str5);
        System.out.println(str5 + " = " + solve5);
    }

    public int solve(String s) {
        s = s.trim();
        //双端队列
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 0;
        char sign = '+';
        char[] charArray = s.toCharArray();
        for (int i = 0, n = charArray.length; i < n; i++) {
            char c = charArray[i];
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            }
            if (c == '(') {
                int j = i + 1;
                int counterPartition = 1;
                while (counterPartition > 0) {
                    if (charArray[j] == '(') {
                        counterPartition++;
                    }
                    if (charArray[j] == ')') {
                        counterPartition--;
                    }
                    j++;
                }
                number = solve(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(c) || i == n - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = c;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }











    /**
     * 没有学明白，思路时，添加到对应栈，如果遇到 * 那么看一眼后面的数吗？如果是数，那么直接处理；遇到 ) 时，直接处理，直到遇到 （ ,
     * 出现的问题，最终剩下 1 - 2 - 3;此时怎么处理呢？弹出 2-3？然后 1 - -1？记过就从 -4 变成了 2 ……
     * @param s
     * @return
     */
    public int solveError(String s) {
        // write code here
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            switch (item) {
                case '(':
                case '+':
                case '-':
                    charStack.push(item);
                    break;
                case '*':
                    if ((int) s.charAt(i + 1) - 48 >= 0 && (int) s.charAt(i + 1) - 48 < 10) {
                        StringBuilder sb = new StringBuilder("");
                        while (i < s.length() - 1 && (int) s.charAt(i + 1) - 48 >= 0 && (int) s.charAt(i + 1) - 48 < 10) {
                            sb.append("" + s.charAt(++i));
                        }
                        int next = Integer.parseInt(sb.toString());

                        int numTop = numStack.pop();
                        numStack.push(numTop * next);
                    } else charStack.push(item);
                    break;
                case ')':
                    while (!charStack.isEmpty()) {
                        char ch = charStack.pop();
                        if (ch == '(') break;
                        int numTop = numStack.pop();
                        int numBottom = numStack.pop();
                        switch (ch) {
                            case '+':
                                numStack.push(numBottom + numTop);
                                break;
                            case '-':
                                numStack.push(numBottom - numTop);
                                break;
                            case '*':
                                numStack.push(numBottom * numTop);
                                break;
                            default:
                                break;

                        }
                    }
                    break;
                default:
                    //对数字的判断
                    StringBuilder sb = new StringBuilder("" + item);
                    while (i < s.length() - 1 && (int) s.charAt(i + 1) - 48 >= 0 && (int) s.charAt(i + 1) - 48 < 10) {
                        sb.append("" + s.charAt(++i));
                    }
                    numStack.push(Integer.parseInt(sb.toString()));
                    break;
            }
        }

        while (!charStack.isEmpty()) {
            char ch = charStack.pop();
            int numTop = numStack.pop();
            int numBottom = numStack.pop();
            switch (ch) {
                case '*':
                    numStack.push(numBottom * numTop);
                    break;
                case '+':
                    numStack.push(numBottom + numTop);
                    break;
                case '-':
                    numStack.push(numBottom - numTop);
                    break;
                default:
                    break;
            }
        }


        return numStack.pop();
    }
}

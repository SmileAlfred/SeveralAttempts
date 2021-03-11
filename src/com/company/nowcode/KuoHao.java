package com.company.nowcode;

import org.junit.Test;

import java.sql.Statement;
import java.util.Stack;

/**
 * @author SmileAlfred
 * @create 2021-03-10 14:22
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 */
public class KuoHao {
    @Test
    public void test(){
        String s = "()";
        boolean valid = isValid(s);
        System.out.println(s + " -> "+valid);
    }
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        char temp;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case '(':
                case '[':
                case '{':
                    stack.push(chars[i]);
                    break;
                case ')':
                    //注意：pop 前首先要判空！
                    if(stack.empty())return false;
                     temp = stack.pop();
                    if(temp != '(')return false;
                    break;
                case ']':
                    if(stack.empty())return false;
                    temp = stack.pop();
                    if(temp != '[')return false;
                    break;
                case '}':
                    if(stack.empty())return false;
                    temp = stack.pop();
                    if(temp != '{')return false;
                    break;
                default:
                    break;
            }
        }
        if(stack.empty())return true;
        return false;
    }
}

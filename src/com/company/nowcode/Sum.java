package com.company.nowcode;

import org.junit.Test;

import javax.xml.transform.Source;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListResourceBundle;
import java.util.Stack;

/**
 * @author SmileAlfred
 * @create 2021-03-06 14:35
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 大叔求和
 */
public class Sum {

    @Test
    public void test() {

        /**
         * 投机取巧
         */
        String s = "4567623456789876676543232345";
        String t = "9878987654323456";
        /*BigInteger bigInteger1 = new BigInteger(s);
        BigInteger bigInteger2 = new BigInteger(t);

        System.out.println(bigInteger1.add(bigInteger2).toString());*/


        String res = mSum(s, t);
        System.out.println("输入：" + s + "\n输入：" + t + "\n输出：" + res);


    }

    /**
     * 大数求和 -- 栈
     *
     * @param s
     * @param t
     * @return
     */
    private String mSum(String s, String t) {
        Stack<String> sStack = new Stack<>();
        Stack<String> tStack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sStack.push(s.substring(i, i + 1));
        }
        for (int i = 0; i < t.length(); i++) {
            tStack.push(t.substring(i, i + 1));
        }
        int jinwei = 0;
        while (!sStack.empty() && !tStack.empty()) {
            int temps = Integer.parseInt(sStack.pop());
            int tempt = Integer.parseInt(tStack.pop());
            int sum = (jinwei + temps + tempt) % 10;
            stringBuilder.append(String.valueOf(sum));
            jinwei = (jinwei + temps + tempt) / 10;
        }
        if (jinwei != 0 && sStack.empty() && tStack.empty()) stringBuilder.append("1");

        while (!sStack.empty()) {
            int temps = Integer.parseInt(sStack.pop());
            int sum = (jinwei + temps) % 10;
            stringBuilder.append(String.valueOf(sum));
            jinwei = (jinwei + temps) / 10;
            if (sStack.empty() && jinwei != 0) stringBuilder.append(String.valueOf(1));
        }
        while (!tStack.empty()) {
            int temps = Integer.parseInt(tStack.pop());
            int sum = (jinwei + temps) % 10;
            stringBuilder.append(String.valueOf(sum));
            jinwei = (jinwei + temps) / 10;
            if (tStack.empty() && jinwei != 0) stringBuilder.append(String.valueOf(1));
        }


        return stringBuilder.reverse().toString();
    }

    /**
     * 大数求和 -- 反向取出 9 个数进行操作
     *
     * @param s
     * @param t
     * @return
     */
    private String mSum2(String s, String t) {
        StringBuilder stringBuilder = new StringBuilder();


        return stringBuilder.reverse().toString();
    }


    @Test
    public void test2() {


    }
}

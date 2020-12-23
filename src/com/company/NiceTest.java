package com.company;

import java.util.*;

public class NiceTest {

    public static void main(String[] args) {
        reverseStr();
    }

    /**
     * 收集了多个单词线索，并将单词按要求加一个空格组 成了句子，最终要求把句子按单词反转解密。
     * 说明：收集的时候单词前后可能会有多个空格，反转后单词不能有多个空格，具体见输入输出样例。
     *
     * 输入描述:     * 输入一个字符串。包含空格和可见字符。长度<=100000。
     *
     * 输出描述:     * 输出一个字符串，表示反转后结果。
     * 示例1
     * 输入
     * the	sky	is												blue!
     * 输出
     * blue! is sky the
     */
    public static void reverseStr(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        List<String> words = Arrays.asList(str.split("\\s+"));//正则表达式，表示匹配所有的空白
        Collections.reverse(words);                                 //反转数组
        String res = String.join(" ", words);               //将数组连接起来
        System.out.print(res);
    }
}

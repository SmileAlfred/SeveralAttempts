package com.company.nowcode;

import org.junit.Test;

import javax.swing.text.rtf.RTFEditorKit;

/**
 * @author SmileAlfred
 * @create 2021-03-22 13:05
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/c3a6afee325e472386a1c4eb1ef987f3?tpId=117&tqId=37827&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC103反转字符串
 * 题目描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 示例1
 * 输入  "abcd"
 * 返回值  "dcba"
 */
public class NC103ReverseStr {
    @Test
    public void test() {

        String str = "asdfghjkl;";
        String reverseStr = solve(str);
        System.out.println(str + "\n" + reverseStr);
    }

    /**
     * 方法：
     * StringBuilder ，不可行，应该不是这个思路；
     * 通过栈？会有空间消耗；
     * 逆序遍历？也没有区别，
     * ※ str 转为 char[]，交换较方便
     *
     * @param str
     * @return
     */
    public String solve(String str) {
        // write code here
        char[] chars = str.toCharArray();

        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp;
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}

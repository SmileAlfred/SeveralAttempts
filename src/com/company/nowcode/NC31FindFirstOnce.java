package com.company.nowcode;

import org.junit.Test;

import java.util.*;

/**
 * @author SmileAlfred
 * @create 2021-03-20 15:01
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=188&tqId=38078&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC31第一个只出现一次的字符
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * 示例1
 * 输入  "google"
 * 返回值  4
 */
public class NC31FindFirstOnce {

    @Test
    public void test() {
        String str = "googgle";
        int i = FirstNotRepeatingChar(str);
        if (i > 0) System.out.println(str + " 中第一次出现过一次的字符的索引是是： " + i + " ; 字符是:" + str.charAt(i));
        else System.out.println(str + " 没有出现过一次的字符");

    }

    public int mFirstNotRepeatingChar2(String str) {
        if (str == null || str.length() == 0) return -1;
        int[] count = new int[256];
        //用一个类似hash的东西来存储字符出现的次数，很方便
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
        //其实这个第二步应该也是ka我的地方，没有在第一时间想到只要在遍历一遍数组并访问hash记录就可以了
        for (int i = 0; i < str.length(); i++)
            if (count[str.charAt(i)] == 1)
                return i;
        return -1;
    }


    /**
     * 思路：ascii 表，数据就 128 个，根据其对应的十进制进行记录，需要记录出现次数以及索引值，
     * 参考了 一夜浮沉 new int[256] 的思路
     *
     * @param str
     * @return
     */
    private int mFirstNotRepeatingChar(String str) {
        if (str.isEmpty()) return -1;
        //0 - 127 存放对应 char 的出现次数；128 - 256 存放对应 char 的出现索引；遍历一遍 str 之后，从 0 -127 遍历,出现一次的 char 找到最小的索引
        int[] ints = new int[256];
        for (int i = 0; i < str.length(); i++) {
            //temp 即 char 对应的十进制数据
            int temp = (int) str.charAt(i);
            ints[temp]++;
            ints[temp + 128] = i;
        }
        //System.out.println(Arrays.toString(ints));
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 128; i++) {
            if (ints[i] == 1) res = Math.min(res, ints[128 + i]);
        }
        if (res != Integer.MAX_VALUE) return res;
        return -1;
    }

    /**
     * 通过遍历 + contains 的方式
     * 在 FirstNotRepeatingCharError2()基础上进行的改进 这次的 contains 使用分段的方式
     *
     * @param str
     * @return
     */
    private int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) return -1;

        for (int i = 0; i < str.length(); i++) {
            //分成左右两半
            if (!(str.substring(0, i)).contains("" + str.charAt(i)) &&
                    !(str.substring(i + 1)).contains("" + str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 通过遍历 + contains 的方式
     * @param str
     * @return
     */
    private int FirstNotRepeatingCharError2(String str) {
        if (str.length() == 0) return -1;

        for (int i = 0; i < str.length(); i++) {
            //也不对，从 str 中取出来的数据，怎么可能会不包含呢？
            if (!str.contains("" + str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingCharError(String str) {
        if (str.length() == 0) return -1;

        //<值，索引>
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.keySet().contains(str.charAt(i))) {
                //错误：不可以直接移除，否则对于 "goggle" 字符本该是 l 结果却是第三个 g;
                map.remove(str.charAt(i));
            } else {
                map.put(str.charAt(i), i);
            }
        }
        if (map.isEmpty()) return -1;

        int minIndex = Integer.MAX_VALUE;
        Set<Character> characters = map.keySet();
        Iterator<Character> iterator = characters.iterator();
        while (iterator.hasNext()) {
            Character next = iterator.next();
            minIndex = Math.min(map.get(next), minIndex);
        }

        return minIndex;
    }
}

package com.company.nowcode;

import com.sun.org.apache.bcel.internal.generic.DALOAD;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

/**
 * @author SmileAlfred
 * @create 2021-03-18 20:41
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/bb1615c381cc4237919d1aa448083bcc?tpId=188&tqId=38088&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC149kmp算法
 * 题目描述
 * 给你一个非空模板串S，一个文本串T，问S在T中出现了多少次
 * 示例1
 * 输入  "ababab","abababab"
 * 返回值  2
 * 示例2
 * 输入  "abab","abacabab"
 * 返回值   1
 */
public class NC149KMP {
    @Test
    public void test() {
        String S = "ababab";
        String T = "abababab";
        int kmp = kmp(S, T);
        System.out.println(S + " 在 " + T + " 中出现了 " + kmp + " 次。");
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算模板串S在文本串T中出现了多少次
     *
     * @param S string字符串 模板串
     * @param T string字符串 文本串
     * @return int整型
     */
    private int kmp(String S, String T) {

        return 0;
    }


    /**
     * ???投机算法？这显然不是 KMP 算法，仅仅是可以解决问题而已
     *
     * @param S
     * @param T
     * @return
     */
    public int kmp1(String S, String T) {
        int time = 0;
        int longLen = T.length(), shortLen = S.length();

        for (int i = 0; i <= longLen - shortLen; i++) {
            if (S.equals(T.substring(i, shortLen + i))) time++;
        }
  
        return time;
    }

    /**
     * 错解，实际上 KMP 算法室友深奥的算法基础的，我忘记了，仅仅记得如果匹配不成功了，不会从下一个位置开始，而是从一个公式计算开始的位置
     *
     * @param S
     * @param T
     * @return
     */
    public int kmpError(String S, String T) {
        // write code here
        boolean isContains = true;
        int count = 0;
        int i = 0, j = 0;
        while (j < S.length()) {
            int index = j;
            for (; i < S.length(); i++, index++) {
                if (S.charAt(i) != T.charAt(index)) {
                    isContains = false;
                    break;
                }
            }
            if (isContains) {
                count++;
                isContains = true;
            } else {
                i = 0;
            }
            j++;
        }

        return count;
    }
}

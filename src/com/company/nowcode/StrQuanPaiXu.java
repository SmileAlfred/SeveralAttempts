package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author SmileAlfred
 * @create 2021-03-09 13:40
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 传入字符串，进行全排序
 */
public class StrQuanPaiXu {
    @Test
    public void test3() {
        Permutation("ABC");
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 0) {
            return result;
        }

        recur(str, "", result);
        return result;
    }

    public void recur(String str, String cur, ArrayList<String> result) {
        if (str.length() == 0) {
            if (!result.contains(cur)) {
                result.add(cur);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            recur(str.substring(0, i) + str.substring(i + 1, str.length()), cur + str.charAt(i), result);
            System.out.println(" ========== i = " + i);
        }
    }
}

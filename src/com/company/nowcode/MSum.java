package com.company.nowcode;

import org.junit.Test;

import javax.xml.transform.Source;
import java.awt.*;
import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-10 19:14
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description
 */
public class MSum {
    @Test
    public void test() {
        int[] numbers = new int[]{-3, 4, 3, 90};
        int target = 0;
        int[] ints = twoSum(numbers, target);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] numbers, int target) {
        // write code here
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }
}

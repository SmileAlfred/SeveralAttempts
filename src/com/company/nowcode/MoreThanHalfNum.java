package com.company.nowcode;

import org.junit.Test;

import java.util.*;

/**
 * @author SmileAlfred
 * @create 2021-03-09 21:19
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 2, 4};
        int res = MoreThanHalfNum_Solution(arr);
        System.out.println("重复次数超过数组一半的数据是:" + res + "\n");

        int i = More2(arr);
        System.out.println();
    }


    public int MoreThanHalfNum_Solution(int[] array) {
        if (0 == array.length) return 0;
        if (1 == array.length) return array[0];
        HashMap<Integer, Integer> map = new HashMap();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!temp.contains(array[i])) {
                temp.add(array[i]);
                map.put(array[i], 1);
            } else {
                int count = map.get(array[i]);
                count++;
                map.put(array[i], count);
                if (count > array.length / 2) return array[i];
            }
        }

        return 0;
    }


    /**
     * 假如数组中存在众数，那么众数一定大于数组的长度的一半。
     * 思想就是：如果两个数不相等，就消去这两个数，最坏情况下，每次消去一个众数和一个非众数，那么如果存在众数，最后留下的数肯定是众数。
     * <p>
     * 初始化：候选人cond = -1， 候选人的投票次数cnt = 0
     * 遍历数组，如果cnt=0， 表示没有候选人，则选取当前数为候选人，++cnt
     * 否则，如果cnt > 0, 表示有候选人，如果当前数=cond，则++cnt，否则--cnt
     * 直到数组遍历完毕，最后检查cond是否为众数
     *
     * @param array
     * @return
     */
    public int More2(int[] array) {
        int cond = -1;
        int cnt = 0;

        for (int i = 0; i < array.length; ++i) {
            if (cnt == 0) {
                cond = array[i];
                ++cnt;
            } else {
                if (cond == array[i]) ++cnt;
                else --cnt;
            }

        }
        cnt = 0;
        for (int k : array) {
            if (cond == k) ++cnt;
        }
        if (cnt > array.length / 2) return cond;
        return 0;
    }


}

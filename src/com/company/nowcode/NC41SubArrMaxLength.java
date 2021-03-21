package com.company.nowcode;

import org.junit.Test;
import sun.awt.windows.WLightweightFramePeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author SmileAlfred
 * @create 2021-03-12 14:08
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 * 示例1
 * 输入  [2,3,4,5]
 * 返回值  4
 * 示例2
 * 输入  [2,2,3,4,3]
 * 返回值    3
 */
public class NC41SubArrMaxLength {
    @Test
    public void test() {
        int[] arr = new int[]{2, 2, 3, 2, 4, 5};
        int i = maxLength2(arr);
        System.out.println("数组：" + Arrays.toString(arr) + " 中最长无重复字串的长度：" + i);
    }


    public int maxLength(int[] arr) {
        // write code here
        if (null == arr) return 0;
        if (arr.length < 2) return arr.length;

        //<value,index>
        HashMap<Integer,Integer> list = new HashMap<>();
        int count = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            if (list.containsKey(temp)) {
                count = 0;
                //回退到上一个位置，重新来一遍！解决的情况是[2,3,2,4];当走到第二个2时，应从第一个2的下一个点开始从新开始
                i = list.get(temp);
                list.clear();
                continue;
            } else {
                count++;
                maxLength = Math.max(count, maxLength);
            }
            list.put(temp,i);
        }
        System.out.println(list);
        return maxLength;
    }

    public int maxLength2(int[] arr) {
        //<值，索引>
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for(int start = 0, end = 0; end<arr.length ; end++){
            if(map.containsKey(arr[end])){
                //重复了；此时或缺了该重复节点的索引【最右侧的索引，即max】，确定新的start
                start = Math.max(start, map.get(arr[end])+1);
                //注意：这里一定要取最大的start，不然就错误了
                //为什么？ 因为重复数字的索引很可能比start小
            }
            max = Math.max(max , end-start+1);
            map.put(arr[end],end);
        }
        return max;
    }
}

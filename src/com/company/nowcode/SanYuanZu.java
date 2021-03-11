package com.company.nowcode;

import com.sun.media.sound.SoftTuning;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.*;
import java.util.zip.CheckedOutputStream;

/**
 * @author SmileAlfred
 * @create 2021-03-10 14:35
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 * 注意：
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 * 解集中不能包含重复的三元组。
 * 例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, 0, 10) (-10, -10, 20)
 * 例如，[-2,0,1,1,2] 返回值  [[-2,0,2],[-2,1,1]]
 * <p>
 * 思路：类似于猿辅导的拿到优惠券的题目，差别在于，每个数字只能取一次
 * <p>
 * 该方法是可行的，通过递归，每一次取出一个数据，替换最后一个数据，有类似于 DFS 算法，实际上，优惠券的解决思路也来自于《DFS -> 二叉树》
 *
 *
 *
 * 第二种方法也可，但是会出现，错误;如输入：[-2,0,1,1,2]；与其输出：[[-2,0,2],[-2,1,1]]；实际输出：[[-2,1,1],[-2,0,2]] 就给报凑了……
 */
public class SanYuanZu {
    @Test
    public void test() {
        int[] S = new int[]{-2, 0, 1, 1, 2};
        ArrayList<ArrayList<Integer>> arrayLists = threeSum(S);
        System.out.println("方法一、" + arrayLists);

        ArrayList<ArrayList<Integer>> arrayLists2 = threeSum2(S);
        System.out.println("方法二、" + arrayLists2);
    }

    int sum = 0;

    private ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        ArrayList<Integer> itemList = new ArrayList<>();

        int left = 0;
        int right = num.length - 1;
        while (right > (left + right) / 2) {
            for (int pivot = 0; pivot < right; pivot++) {
                if (pivot != left && pivot != right) {
                    sum = num[pivot] + num[left] + num[right];
                    if (sum == 0) {
                        itemList.add(num[left]);
                        itemList.add(num[right]);
                        itemList.add(num[pivot]);

                        Collections.sort(itemList);
                        res.add(new ArrayList<>(itemList));
                        itemList.clear();
                    }
                }
            }
            itemList.clear();
            right--;
        }
        System.out.println(new ArrayList<>(res));
        right = num.length - 1;


        while (left < (left + right) / 2) {
            for (int pivot = left; pivot < right; pivot++) {
                if (pivot != left && pivot != right) {
                    sum = num[pivot] + num[left] + num[right];
                    if (sum == 0) {
                        itemList.add(num[left]);
                        itemList.add(num[right]);
                        itemList.add(num[pivot]);

                        Collections.sort(itemList);
                        res.add(new ArrayList<>(itemList));
                        itemList.clear();
                    }
                }
            }
            itemList.clear();
            left++;
        }
        System.out.println(new ArrayList<>(res));

        return new ArrayList<>(res);
    }

    HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
    ArrayList<Integer> itemList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        //记录获取到数据的 index
        List<Integer> counts = new ArrayList();
        threeSumHelper(num, 0, counts);

        return new ArrayList<>(res);
    }

    /**
     * 递归帮助类
     *
     * @param num    传入的数组
     * @param sum    加和
     * @param indexs 取出了几个数？？那几个数？
     * @return
     */
    public void threeSumHelper(int[] num, int sum, List<Integer> indexs) {
        if (num.length < 3 - indexs.size()) {
            return;
        }

        if (indexs.size() >= 3) {
            if (sum == 0) {
                if (itemList.get(0) <= itemList.get(1) && itemList.get(1) <= itemList.get(2)) {
                    res.add(new ArrayList<>(itemList));
                    //System.out.println(itemList);
                }
            }
            return;
        }

        /**
         * 循环体
         */
        for (int i = 0; i < num.length; i++) {
            //因为存在的数组中元素不可以重复取，所以使用 indexs 保存已经取出的下表，
            if (indexs.contains(i)) continue;
            indexs.add(i);
            int temp = num[i % num.length];

            sum += temp;
            itemList.add(temp);

            threeSumHelper(num, sum, indexs);

            sum -= temp;
            indexs.remove(indexs.size() - 1);
            itemList.remove(itemList.size() - 1);
        }
    }


    @Test
    public void tes1() {
        ArrayList ar1 = new ArrayList();
        ar1.add(-1);
        ar1.add(1);
        ar1.add(0);

        ArrayList ar2 = new ArrayList();
        ar2.add(-1);
        ar2.add(0);
        ar2.add(1);

        Collections.sort(ar1);
        Collections.sort(ar2);

        System.out.println(ar1 + "\n" + ar2);
    }
}

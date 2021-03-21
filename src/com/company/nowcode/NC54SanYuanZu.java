package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-16 19:03
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/345e2ed5f81d4017bbb8cc6055b0b711?tpId=188&tqId=38027&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC54数组中相加和为 0 的三元组
 * 题目描述给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。注意：
 * 1. 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 * 2. 解集中不能包含重复的三元组。
 * <p>
 * 例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, 0, 10) (-10, -10, 20)
 */
public class NC54SanYuanZu {

    @Test
    public void test() {
        int[] sum = {-10, 0, 10, 20, -10, -40};
        ArrayList<ArrayList<Integer>> res = threeSum(sum);

        System.out.println("数组 " + Arrays.toString(sum) + " 中和为 0 的三元组有：" + res);
    }

    /**
     * 这道题还是执着于“优惠券那道题”的递归思想，实在是想不明白，其实是可以的，不过，有些麻烦；
     * 注意，题目要求非降序排列，那么不如先将其排序，排序后计算的时候直接去重，省去了对计算结果的去重问题；
     * 1. 排序；
     * 2. 设置三个标记位，分别表示 a b c，注意，b 在 a 后， c 在 b 后，避免重复问题，另外，例如数组[-40,-10,-10,0]，将 a 记录 -40，b 记录为第一个 -10，当 b 走到下一个位置就是第二个 -10 时，应该进行判断，如果该数等于上一个数（上一个数不能是 a 的标记位）那么就直接跳过，因为已经计算过相同的值了；
     * 3. 首先固定 a ，随后将 b 放在 a+1 ，c 放在 b+1 ，随后 c 依次向后取出元素进行计算和判断，当 c 取到末位，跳出循环，b 后移一位，c 重置在 b+1，继续进行 c 的查找；
     * 4. 本方法是固定一个数据，随后一个一个数据的查找，效率应该不会高；加上开始就排序了，应该不是最佳！
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        if (num == null) {
            return list1;
        }

        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] > 0) {
                break;
            }
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length - 1; j++) {
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < num.length; k++) {
                    if (k != j + 1 && num[k] == num[k - 1]) {//这个判断没看明白
                        continue;
                    }
                    int sum = num[i] + num[j] + num[k];
                    if (sum == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        list1.add(list);
                    }
                }
            }
        }
        return list1;
    }

    /**
     * 先排序，然后以第一个值为基准开始遍历，用双指针求第二个值和第三个值。
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();


        if (num.length < 3) return res;

        for (int i = 0; i < num.length - 2; ++i) {
            int j = i + 1;
            int k = num.length - 1;
            int target = -num[i];
            while (j < k) {
                if (num[j] + num[k] > target) --k;
                else if (num[j] + num[k] < target) ++j;
                else {
                    ArrayList<Integer> current = new ArrayList<>();
                    current .add(num[i]);
                    current .add(num[j]);
                    current .add(num[k]);
                    res.add(current);
                    while (j + 1 < k && num[j + 1] == num[j]) ++j;  // 防止重复
                    while (k - 1 > j && num[k - 1] == num[k]) --k;  // 防止重复
                    ++j;
                    --k;
                }
            }
            while (i + 1 < num.length - 2 && num[i + 1] == num[i]) ++i;   // 防止重复
        }
        return res;
    }


}

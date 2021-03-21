package com.company.nowcode;

import org.junit.Test;

import java.rmi.MarshalException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author SmileAlfred
 * @create 2021-03-17 17:45
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/269b4dbd74e540aabd3aa9438208ed8d?tpId=188&tqId=38039&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC144不相邻的最大子序列和
 * 题目描述
 * 给你一个n（1 ≤ n ≤ 10），和一个长度为n的数组，在不同时选位置相邻的两个数的基础上，求该序列的最大子序列和（挑选出的子序列可以为空）。
 * 示例1  输入   3,[1,2,3]
 * 返回值  4
 * 说明 ： 有[],[1],[2],[3],[1,3] 4种选取方式其中[1,3]选取最优，答案为4
 * 示例2
 * 输入  4,[4,2,3,5]
 * 返回值   9
 * Error:理解跑偏了，误以为只可以选择两个数，那可就永远都做不对嘛……
 */
public class NC144MaxSum {
    @Test
    public void test() {
        int[] array = new int[]{4, 2, 3, 5,12,1,24,6};
        long subsequence = subsequence(array.length, array);
        System.out.println("数组：" + Arrays.toString(array) + " 中<最大子序列和>为：" + subsequence);
    }

    /**
     * C++ 思路 题目要求是不相邻的子序列值。 什么样子会帮助满足最大呢？
     * 1，序列包含尽可能多的数
     * 2，序列包含尽可能大的数。
     * 考虑不相邻的话，要不要加入第i个数，需要考虑的问题是它前一个 i-1 要不要加入，
     * 至于i-2则不需要考虑，因为加入第i个数必然可以加入不相邻的 i-2 。换句话说，你不会跳过3个数。
     * 换成代码就是 dp[i+3] = max(dp[i+2], dp[i+1]+arr[i])
     *
     * @param n
     * @param array
     * @return
     */
    private long subsequenceC(int n, int[] array) {
        // write code
        long dp1 = 0, dp2 = 0;
        //dp3 记录每一次的最大值，并在将其 dp2；中，dp2 用于返回，并且记录上一次的最大值，用于这一次 dp3 的比较；
        for (int it : array) {
            long dp3 = Math.max(dp1 + it, dp2);
            dp1 = dp2;
            dp2 = dp3;
        }
        return dp2;
    }


    /**
     * 打家劫舍问题
     *其实就是一个打家劫舍的问题，数组中每一个元素值就是可以偷的金额，相邻的不能偷，求能够偷出的最大金额是多少。
     *
     * 设置一个状态转移数组dp，dp[i]表示数组中前i个元素 所能偷的最大金额是多少
     *
     * 状态转移表达式：
     * (1)对于当前的元素arr[i],如果偷，那么dp[i] = dp[i-2] + arr[i]
     * (2)如果不偷，那么dp[i] = dp[i-1]
     * @param n
     * @param array
     * @return
     */
    private long subsequence(int n, int[] array) {
        // write code
        long[] dp = new long[n + 1];

        dp[0] = 0;
        dp[1] = array[0];

        for (int i = 2; i <= n; i++) {
            //打劫第 6 家时，判断：dp[5] 大？还是 dp[4] + array[5] 大？;因为 array[5] 其实就是第 6 家的财产；
            //dp[i - 1] 表示的就是选择打劫上一家，放弃这一家；| 而 【dp[i - 2] + array[i - 1]】表示打劫上上家和这一家
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i - 1]);
            System.out.println("打劫第 " +i+" 家时，判断：dp["+(i-1)+"] 大？还是 "+"dp["+(i-2)+"] + array["+(i-1)+"] 大？" );
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }


    /**
     * 两次查找，超出了时间，显然是需要使用二分
     *
     * @param n     int整型 数组的长度
     * @param array int整型一维数组 长度为n的数组
     * @return long长整型
     */
    public long subsequenceError1(int n, int[] array) {
        // write code here
        long max = 0L;
        for (int i = 0; i < array.length - 2; i++) {
            int left = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int right = array[j];
                max = Math.max(left + right, max);
            }
        }
        return max;
    }

    /**
     * 二分法；错误，因为无法保证 最大的两个数分别在左右两边
     *
     * @param n
     * @param array
     * @return
     */
    public long subsequenceError2(int n, int[] array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        if (array.length == 2) return array[0] > array[1] ? array[0] : array[1];

        int leftIndex = 0;
        int rightIndex = n - 1;

        int leftMax = array[leftIndex];
        int rightMax = array[rightIndex];
        long max = 0L;

        while (leftIndex < rightIndex) {
            leftMax = leftMax > array[leftIndex] ? leftMax : array[leftIndex];
            rightMax = rightMax > array[rightIndex] ? rightMax : array[rightIndex];

            max = Math.max(max, 0L + leftMax + rightMax);

            leftIndex++;
            rightIndex--;
        }

        return max;
    }


    /**
     * 思路：分成三段分别查找，找出三个最大值及其索引插入 map，最后找出最大的两个数（索引不挨着）
     * ……没有写，感觉不太靠谱****
     *
     * @param n
     * @param array
     * @return
     */
    public long subsequenceError3(int n, int[] array) {
        long max = 0l;
        HashMap<Integer, Integer> maxMap = new HashMap<>();
        //

        return max;
    }


}

package com.company.nowcode;

import com.sun.org.apache.bcel.internal.generic.RET;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author SmileAlfred
 * @create 2021-03-28 10:13
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/fc897457408f4bbe9d3f87588f497729?tpId=117&tqId=37835&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC111最大数
 * 题目描述
 * 给定一个数组由一些非负整数组成，现需要将他们进行排列并拼接，使得最后的结果最大，返回值需要是string类型 否则可能会溢出
 * 示例1
 * 输入  [30,1]
 * 返回值  "301"
 * 备注:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class NC111MaxNum {
    @Test
    public void test() {
        int[] nums = new int[]{91, 92, 9, 90, 99, 100};
        String res = solve(nums);
        System.out.println(Arrays.toString(nums) + " 组合最大数为：" + res);
    }


    /**
     * 思路；一定要写比较器，比如 30 和 20101，一定是 30 放在前面，
     * 对于排序的逻辑可以用插入即可
     */
    public String solve(int[] nums) {
        // write code here
        for (int i = 1; i < nums.length; i++) {
            if (compare(nums[i], nums[i - 1])) {
                int temp = nums[i];
                int j = i - 1;
                while (j >= 0 && compare(temp, nums[j])) {
                    nums[j+1] = nums[j--];
                }
                nums[j + 1] = temp;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("" + nums[0]);
        for (int i = 1; i < nums.length; i++) {
            stringBuilder.append("" + nums[i]);
        }
        String res = stringBuilder.toString();
        while (res.startsWith("0") && res.length() > 1) {
            res = res.substring(1);
        }
        return res;
    }

    /**
     * 比较两个数，如 30 20102 ，从首位依次比较，直到数据短的一方比完为止；
     *
     * @param num1
     * @param num2
     * @return 数据大的返回 true；
     */
    public boolean compare(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);

        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) < str2.charAt(i)) return false;
        }
        return true;
    }
}

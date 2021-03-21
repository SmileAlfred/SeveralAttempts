package com.company.nowcode;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-17 9:32
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/9cf027bf54714ad889d4f30ff0ae5481?tpId=188&tqId=38034&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC91最长递增子序列
 * 题目描述
 * 给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中字典序最小的）
 * 示例1   输入  [2,1,5,3,6,4,8,9,7]
 * 返回值  [1,3,4,8,9]
 * 示例2   输入 [1,2,8,6,4]
 * 返回值  [1,2,4]
 * 说明
 * 其最长递增子序列有3个，（1，2，8）、（1，2，6）、（1，2，4）其中第三个字典序最小，故答案为（1，2，4）
 * 注意：子串一定是连续的，而子序列不一定是连续的
 */
public class NC91LongestSubArr {
    @Test
    public void test() {
        int[] arr = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] lis = LIS(arr);
        System.out.println("数组：" + Arrays.toString(arr) + " 中最长递增子序列是：" + Arrays.toString(lis));
    }


    public int[] LIS(int[] arr) {
        // write code here
        //每当子问题增加一个元素 e 时，e 就与 temp 最后一个元素就进行比较，如果 e 比 temp 的最后一个元素大，则直接在 temp 最后面添加 e；
        // 反之，则在 temp 中从左往右寻找第一个比 e 大的数，并用 e 替换之。然后 e 在 temp 中的索引就是我们要找的标号，我们将标号存 在 nums
        int[] temp = new int[arr.length];
        int[] nums = new int[arr.length];
        nums[0] = 1;
        int tempIndex = 0;
        temp[tempIndex] = arr[0];

        for (int i = 1; i < arr.length; ++i) {
            int left = 0, right = tempIndex;
            if (arr[i] > temp[tempIndex]) {
                ++tempIndex;
                nums[i] = tempIndex + 1;
                temp[tempIndex] = arr[i];
            } else {
                // 注意这里 left <= right 而不是 left < right，我们要替换的是第一个比 arr[i] 大的元素
                while (left <= right) {
                    int mid = (right + left) / 2;
                    if (temp[mid] > arr[i]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                temp[left] = arr[i];
                nums[i] = left + 1;
            }
        }
        System.out.println("arr  = " + Arrays.toString(arr));
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("temp = " + Arrays.toString(temp));

        int[] LCS = new int[tempIndex + 1];
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] == tempIndex + 1) {
                LCS[tempIndex] = arr[i];
                --tempIndex;
            }
        }
        return LCS;
    }


}

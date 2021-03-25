package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author SmileAlfred
 * @create 2021-03-23 10:15
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/c9480213597e45f4807880c763ddd5f0?tpId=117&tqId=37848&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC136输出二叉树的右视图
 * 题目描述
 * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
 * 示例1
 * 输入  [1,2,4,5,3],[4,2,5,1,3]
 * 返回值  [1,3,5]
 * 备注:
 * 二叉树每个节点的值在区间[1,10000]内，且保证每个节点的值互不相同。
 */
public class NC136BinTreeRightView {
    @Test
    public void test() {
        int[] xianxu = new int[]{1, 2, 4, 5, 3};
        int[] zhongxu = new int[]{4, 2, 5, 1, 3};
        int[] solve = solve(xianxu, zhongxu);
        System.out.println(Arrays.toString(xianxu) + " ; " + Arrays.toString(zhongxu) + " ;右视图为：" + Arrays.toString(solve));
        System.out.println();

        int[] ints = new int[3];
        System.arraycopy(xianxu, 1, ints, 0, ints.length);
        //System.out.println(Arrays.toString(ints));//2,4,5
    }


    private List<Integer> res;
    private int[] myPre;
    private int[] myIn;
    private int len;

    public int[] solve(int[] xianxu, int[] zhongxu) {
        res = new ArrayList<>();
        myPre = xianxu;
        myIn = zhongxu;
        len = xianxu.length;
        dfs(0, len - 1, 0, len - 1, 0);
        int[] ans = new int[res.size()]; // 转成数组返回
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dfs(int start1, int end1, int start2, int end2, int level) {
        if (start1 > end1) {
            return;
        }
        int rootVal = myPre[start1]; // 当前根结点
        if (res.size() <= level) { // 说明当前是最左节点，只能add，不能覆盖
            res.add(rootVal);
        } else {
            res.set(level, rootVal); // 覆盖同一level中之前记录过的节点，最终保留的就是每一level的最右节点
        }
        for (int i = 0; i < len; i++) {
            if (myIn[i] == rootVal) { // 递归调用
                dfs(start1 + 1, start1 + i - start2, start2, i - 1, level + 1);
                dfs(start1 + i - start2 + 1, end1, i + 1, end2, level + 1);
                break;
            }
        }
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     *
     * @param xianxu  int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    ArrayList<Integer> list = new ArrayList<>();

    public int[] solveError(int[] xianxu, int[] zhongxu) {
        //System.out.println("xianxu ; " + Arrays.toString(xianxu) + " ; zhongxu ; " + Arrays.toString(zhongxu));
        // write code here
        if (xianxu.length == 0) return xianxu;
        //思路一，想 广度优先遍历一样，每层的数据从左往右压入栈后，pop 出最后一个元素插入数组；分析，不可行，太浪费太笨
        //思路二，注意这个是右视图，题目给了前序和中序遍历，那么前序的第一个数据一定是结果的第一个元素；
        //1.根据先序和中序遍历的特点分别找出左子树和右子树，如果右子树不为空没那么，将改由字数的根节点插入结果数组，注意插入的时候插入其根节点
        //2.右子树不为空时，仍要递归左子树，但不进行添加，直到右子树为空，此时一次遍历其左子树，并添加其右子节点
        //终极思路：前面两步有些花里胡哨！实际上！递归的思路！如果右子树不为空那么添加右子树的根节点，否则递归其左子树的右子树！
        //思路是对了，但是递归写的不对，实现不了
        int root = xianxu[0];
        list.add(root);
        int index = zhongxu.length - 1;
        for (; index > 0; index--) {
            if (root == zhongxu[index]) break;
        }
        //先保存左子树
        int[] lefttZhongxu = new int[index];
        System.arraycopy(zhongxu, 0, lefttZhongxu, 0, lefttZhongxu.length);

        int[] leftXianxu = new int[index];
        System.arraycopy(xianxu, 1, leftXianxu, 0, leftXianxu.length);
        //System.out.println("lefttZhongxu = " + Arrays.toString(lefttZhongxu) + " ; leftXianxu = " + Arrays.toString(leftXianxu));

        //递归右子树
        if (index != zhongxu.length - 1) {
            int[] rightZhongxu = new int[zhongxu.length - 1 - index];
            System.arraycopy(zhongxu, index + 1, rightZhongxu, 0, rightZhongxu.length);

            int[] rightXianxu = new int[zhongxu.length - 1 - index];
            System.arraycopy(xianxu, index + 1, rightXianxu, 0, rightXianxu.length);
            //System.out.println("rightZhongxu = " + Arrays.toString(rightZhongxu) + " ; rightXianxu = " + Arrays.toString(rightXianxu));
            solve(rightXianxu, rightZhongxu);
        } else {
            System.out.println("leftXianxu = " + Arrays.toString(leftXianxu) + " ; lefttZhongxu = " + Arrays.toString(lefttZhongxu));
            solve(leftXianxu, lefttZhongxu);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

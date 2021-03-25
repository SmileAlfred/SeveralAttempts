package com.company.nowcode;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * @author SmileAlfred
 * @create 2021-03-24 9:50
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/8a2b2bf6c19b4f23a9bdb9b233eefa73?tpId=117&tqId=37721&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC13二叉树的最大深度
 * 题目描述
 * 求给定二叉树的最大深度，
 * 最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
 * 示例1
 * 输入 {1,2}
 * 返回值  2
 * 示例2
 * 输入  {1,2,3,4,#,#,5}
 * 返回值  3
 */
public class NC13MaxDepth {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

        int depth = maxDepth(root);
        System.out.println("最大深度度为：" + depth);
    }

    /**
     * 一叶浮沉的解答
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);

    }


    int maxDepth, count;

    public int mMaxDepth(TreeNode root) {
        // write code here
        if (null == root) return 0;
        count++;
        if (null == root.left && null == root.right) maxDepth = Math.max(maxDepth, count);

        if (null != root.left) mMaxDepth(root.left);
        if (null != root.right) mMaxDepth(root.right);
        count--;
        return maxDepth;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

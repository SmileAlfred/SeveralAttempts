package com.company.nowcode;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author SmileAlfred
 * @create 2021-03-17 22:45
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=188&tqId=38033&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC62平衡二叉树
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 示例1
 * 输入  {1,2,3,4,5,6,7}
 * 返回值  true
 */
public class NC62BalanceTree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.left.left.left.left = new TreeNode(7);

        root.left.right = new TreeNode(4);

        root.right = new TreeNode(6);

        ArrayList res = new ArrayList();
        root.List(res);
        System.out.print("二叉树：" + res + " 是平衡二叉树吗？");

        boolean b = IsBalanced_Solution(root);
        System.out.println(b);

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }

    /**
     * 返回 -1 表示不平衡；
     * @param root
     * @return
     */
    public int depth(TreeNode root) {
        if (root == null) return 0;

        int left = depth(root.left);
        if (left == -1) return -1; //如果发现子树不平衡之后就没有必要进行下面的高度的求解了

        int right = depth(root.right);
        if (right == -1) return -1;//如果发现子树不平衡之后就没有必要进行下面的高度的求解了

        if (Math.abs(left - right) > 1) return -1;
        else return 1 + (left > right ? left : right);
    }


    public boolean mIsBalanced_Solution(TreeNode root) {
        if (null == root || (null == root.left && null == root.right)) return true;
        ArrayList<Integer> res = new ArrayList();

        ArrayList<Integer> list = helper(root, res);
        System.out.println("叶子节点长度：" + list);

        Collections.sort(list);
        return (list.size() > 1 && list.get(list.size() - 1) - list.get(0) < 2) || (list.size() == 1 && list.get(0) <= 2);
    }

    int count = 0;

    /**
     * 将每个叶子节点的路径长度添加道集合中，返回
     *
     * @param root
     * @return
     */
    private ArrayList helper(TreeNode root, ArrayList<Integer> res) {
        count++;
        if (null == root.left && null == root.right) {
            res.add(count);
        }

        if (null != root.left) helper(root.left, res);

        if (null != root.right) helper(root.right, res);

        count--;

        return res;
    }


    int max = 1, min = Integer.MAX_VALUE;

    /**
     * 不必存入集合，进存放最大最小的根结点个数即可
     * 不可，结果不通过，原因是，如果时单路，那么 max = min，结果为 true
     *
     * @param root
     * @return
     */
    private boolean helper2(TreeNode root, ArrayList<Integer> res) {
        count++;
        if (null == root.left && null == root.right) {
            max = Math.max(max, count);
            min = Math.min(min, count);
            if (max - min > 1) return false;
        }

        if (null != root.left) helper(root.left, res);

        if (null != root.right) helper(root.right, res);

        count--;

        return max - min < 2;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public void List(ArrayList<Integer> res) {
        if (null != this.left) this.left.List(res);
        res.add(this.val);
        if (null != this.right) this.right.List(res);
    }
}

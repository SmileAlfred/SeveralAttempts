package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author SmileAlfred
 * @create 2021-03-11 17:17
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 给定一个二叉树和一个值\ sum sum，判断是否有从根节点到叶子节点的节点值之和等于\ sum sum 的路径，
 */
public class NC9SumPath {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(11);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);

        boolean b = hasPathSum(root, 22);
        System.out.println(root + "\n中 存在 吗？  " + b);
    }


    /**
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    boolean flag = false; //用于返回最后的结果

    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(root, sum, 0);
        return flag;

    }

    public void dfs(TreeNode root, int sum, int value) {
        //如果节点为空或者flag已经为true直接返回
        if (root == null || flag == true) return;
        value += root.val; //用于存储路径和
        if (root.left == null && root.right == null) { //已经到达了叶子节点
            if (sum == value) {//进行判断当前路径和是否等于给定的预期值
                flag = true;
            }
        } else {
            dfs(root.left, sum, value);//递归左子树
            dfs(root.right, sum, value); //递归右子树
        }
    }


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return left + "←"+ val   + "→" + right;
        }
    }
}

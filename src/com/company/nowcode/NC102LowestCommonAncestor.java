package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-22 10:40
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116?tpId=117&tqId=37826&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC102最近公共祖先
 * 题目描述
 * 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 * 示例1
 * 输入  [3,5,1,6,2,0,8,#,#,7,4],5,1
 * 返回值  3
 */
public class NC102LowestCommonAncestor {
    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(root.list());

        int o1 = 0, o2 = 4;
        int lowestCommonAncestor = lowestCommonAncestor(root, o1, o2);
        System.out.println(o1 + " " + o2 + " 的公共祖先是：" + lowestCommonAncestor);

        System.out.println("==========Math.pow(2, 0) = " + Math.pow(2, 0));

        FormatTree();
    }

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        return dfs(root, o1, o2).val;
    }

    public TreeNode dfs(TreeNode root, int o1, int o2) {
        //如果当前节点为空，或者当前节点等于o1或者等于o2就返回值给父亲节点
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }
        //递归遍历左子树
        TreeNode left = dfs(root.left, o1, o2);
        //递归遍历右子树
        TreeNode right = dfs(root.right, o1, o2);
        //如果left、right都不为空，那么代表o1、o2在root的两侧，所以root为他们的公共祖先
        if (left != null && right != null) return root;
        //如果left、right有一个为空，那么就返回不为空的那一个
        return left != null ? left : right;
    }


    /**
     * {27,32,34,19,41,17,18,9,14,44,39,#,#,24,30,#,#,#,2,7,42,28,36,#,#,11,6,#,1,#,#,#,31,16,4,22,33,#,#,#,5,10,15,37,12,8,#,35,3,#,23,21,#,#,#,29,#,#,#,40,#,#,#,#,#,#,#,#,#,13,43,#,#,#,#,#,#,25,20,#,#,38,#,26},32,38
     *
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public int lowestCommonAncestorError(TreeNode root, int o1, int o2) {
        // write code here
        if (null == root || null == root.left || null == root.right) return -1;
        if (root.left.val == o1 && root.right.val == o2) return root.val;
        int resL = lowestCommonAncestorError(root.left, o1, o2);
        int resR = lowestCommonAncestorError(root.right, o1, o2);
        //如果不是同一个父节点那么判断是都是包含关系

        return resL == -1 ? resR : resL;
    }


    public void FormatTree() {
        //{27,32,34,19,41,17,18,9,14,44,39,#,#,24,30,#,#,#,2,7,42,28,36,#,#,11,6,#,1,#,#,#,31,16,4,22,33,#,#,#,5,10,
        // 15,37,12,8,#,35,3,#,23,21,#,#,#,29,#,#,#,40,#,#,#,#,#,#,#,#,#,13,43,#,#,#,#,#,#,25,20,#,#,38,#,26}
        String strs = "27,32,34,19,41,17,18,9,14,44,39,#,#,24,30,#,#,#,2,7,42,28,36,#,#,11,6,#,1,#,#,#,31,16,4,22,33,#,#,#,5,10,15,37,12,8,#,35,3,#,23,21,#,#,#,29,#,#,#,40,#,#,#,#,#,#,#,#,#,13,43,#,#,#,#,#,#,25,20,#,#,38,#,26";
        String[] preOrder = strs.split(",");
        System.out.println(preOrder.length + "\t" + Arrays.toString(preOrder));
        int floor = 1, index = 0;
        while (true) {
            try {
                int temp = index;
                for (; index < temp + Math.pow(2, (floor - 1)); index++) {

                    System.out.print(preOrder[index] + "\t");

                }
                floor++;

                System.out.println();
                if (index >= preOrder.length) break;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public ArrayList<Integer> list() {
            ArrayList<Integer> treeNodes = new ArrayList<>();
            if (null != this.left) treeNodes.addAll(this.left.list());
            if (null != this) treeNodes.add(this.val);
            if (null != this.right) treeNodes.addAll(this.right.list());

            return treeNodes;
        }
    }

}
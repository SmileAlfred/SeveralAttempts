package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author SmileAlfred
 * @create 2021-03-14 15:53
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/f31fc6d3caf24e7f8b4deb5cd9b5fa97?tpId=188&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * NC60判断一棵树是否为搜索二叉树和完全二叉树
 * <p>
 * 二叉搜索树（Binary Search Tree），它或者是一棵空树，或者是具有下列性质的二叉树：
 * 1. 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 2. 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 3. 它的左、右子树也分别为二叉搜索树。二叉搜索树作为一种经典的数据结构，它既有链表的快速插入与删除操作的特点，又有数组快速查找的优势；
 * 所以应用十分广泛，例如在文件系统和数据库系统一般会采用这种数据结构进行高效率的排序与检索操作。
 * <p>
 * 完全二叉树:如果左子树为空而右子树不为空那么即为 false；
 * 一棵深度为k的有n个结点的二叉树，对树中的结点按从上至下、从左到右的顺序进行编号，
 * 如果编号为i（1≤i≤n）的结点与满二叉树中编号为i的结点在二叉树中的位置相同，则这棵二叉树称为完全二叉树。
 */
public class NC60JudgeTree {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(9);

        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(8);

        ArrayList<Integer> res = new ArrayList<>();
        root.List(res);
        System.out.print("二叉树：" + res);

        boolean[] booleans = judgeIt(root);
        System.out.println(" 是搜索二叉树吗？" + booleans[0] + " 是完全二叉树吗？" + booleans[1]);

    }

    public boolean[] judgeIt(TreeNode root) {
        // write code here
        boolean[] res = new boolean[2];
        res[0] = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        res[1] = isCBT(root);


        return res;
    }


    private boolean isBST(TreeNode root, int left, int right) {
        if (root == null) return true;
        if (root.val < left || root.val > right) return false;
        return isBST(root.left, left, root.val) && isBST(root.right, root.val, right);
    }

    private boolean isCBT(TreeNode root) {
        if (root == null) return true;
        if (null != root.left && root.right == null) return isCBT(root.left);
        if (root.left == null && null != root.right) return false;
        return isCBT(root.left) && isCBT(root.right);
    }


    public class TreeNode {
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
}

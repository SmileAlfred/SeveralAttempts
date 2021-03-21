package com.company.nowcode;

import org.junit.Test;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;

/**
 * @author SmileAlfred
 * @create 2021-03-18 11:20
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/4eaccec5ee8f4fe8a4309463b807a542?tpId=188&tqId=38043&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC98判断t1树中是否有与t2树拓扑结构完全相同的子树
 * 题目描述
 * 给定彼此独立的两棵二叉树，判断 t1 树是否有与 t2 树拓扑结构完全相同的子树。
 * 设 t1 树的边集为 E1，t2 树的边集为 E2，若 E2 等于 E1 ，则表示 t1 树和t2 树的拓扑结构完全相同。
 * 示例1
 * 输入  {1,2,3,4,5,6,7,#,8,9},{2,4,5,#,8,9}
 * 返回值  true
 */
public class NC98TipPuStruct {
    @Test
    public void test() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(9);
        root1.left.left.right = new TreeNode(8);

        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        System.out.println("root1 = " + root1.mToString());

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.left.right = new TreeNode(8);

        root2.right = new TreeNode(5);
        root2.right.left = new TreeNode(9);

        System.out.println("root2 = " + root2.mToString());

        boolean contains = isContains(root1, root2);
        System.out.println("包含吗？" + contains);
    }

    boolean leftRes = false, rightRes = false;
    public boolean isContainsRight(TreeNode root1, TreeNode root2) {
        // write code here
        if (root1 == null && root2 == null) {
            return true;
        }

        if (null != root1 && null != root2) {
            if (root1.val == root2.val) {
                leftRes = isContainsRight(root1.left, root2.left);
                rightRes = isContainsRight(root1.right, root2.right);
            } else {
                //注意，如果数值不相等，此时直应该迭代而不该对 leftRes、rightRes 进行赋值操作
                isContainsRight(root1.left, root2);
                isContainsRight(root1.right, root2);
            }
            //注意，如果数值不相等，我没有给 leftRes、rightRes 赋值，仅当数值相等时在进行赋值，所以次数应是 &&
            return leftRes && rightRes;
        } else {
            return false;
        }
    }

    /**
     * 一个不知名的牛客
     * @param root1
     * @param root2
     * @return
     */
    public boolean isContains(TreeNode root1, TreeNode root2) {
        // write code here
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        return isEquals(root1, root2) || isContains(root1.left, root2) || isContains(root1.right, root2);
    }

    public boolean isEquals(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        return root1.val == root2.val && isEquals(root1.left, root2.left) && isEquals(root1.right, root2.right);
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        ArrayList<Integer> res;

        public ArrayList mToString() {
            res = new ArrayList<>();
            List(res);
            return res;
        }

        public void List(ArrayList<Integer> res) {
            if (null != this.left) this.left.List(res);
            res.add(this.val);
            if (null != this.right) this.right.List(res);
        }
    }
}


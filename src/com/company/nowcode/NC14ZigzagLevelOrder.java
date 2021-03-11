package com.company.nowcode;

import org.junit.Test;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SmileAlfred
 * @create 2021-03-11 13:37
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 */
public class NC14ZigzagLevelOrder {
    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> arrayLists = zigzagLevelOrder(root);
        System.out.println(arrayLists);
    }


    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (null == root) return res;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int height = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> itemList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (height % 2 == 1) {
                    itemList.add(poll.val);
                } else {
                    itemList.add(0, poll.val);
                }

                if (null != poll.left) queue.add(poll.left);
                if (null != poll.right) queue.add(poll.right);

            }
            height++;
            res.add(new ArrayList<>(itemList));
        }

        return res;
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
            return val + " -> " + left + " -> " + right;
        }
    }
}



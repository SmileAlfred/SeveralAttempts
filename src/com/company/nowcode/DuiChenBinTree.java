package com.company.nowcode;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.ArrayList;

/**
 * @author SmileAlfred
 * @create 2021-03-13 17:35
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 判断传入的二叉树，是不是对称的二叉树
 */
public class DuiChenBinTree {

    @Test
    public void test() {
        ListNode root = new ListNode(1);
        root.left = new ListNode(2);

        root.left.left = new ListNode(3);
        root.left.left.left = new ListNode(5);
        root.left.left.right = new ListNode(6);

        root.left.right = new ListNode(4);


        root.right = new ListNode(2);

        root.right.left = new ListNode(4);
        root.right.right = new ListNode(3);

        root.right.right.left = new ListNode(6);
        root.right.right.right = new ListNode(5);

        ArrayList<Integer> list = new ArrayList<>();
        root.list(list);
        System.out.print(list);

        boolean compare = isSymmetric(root);
        System.out.println("\t" + compare);
    }

    public boolean compare(ListNode node) {
        if (node == null || (node.left == null && node.right == null)) return true;
        if (node.left == null || node.right == null) return false;

        compare(node.left, node.right);
        return isDuiChen;
    }

    boolean isDuiChen = false;

    public void compare(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            isDuiChen = true;
            return;
        }
        if (node1.val != node2.val) {
            isDuiChen = false;
            return;
        }


        if (node1.left != null && node2.right != null) compare(node1.left, node2.right);
        else if (node1.left == null && node2.right == null) {
            isDuiChen = true;
            return;
        } else {
            isDuiChen = false;
            return;
        }

        if (node1.right != null && node2.left != null) compare(node1.right, node2.left);
        else if (node1.right == null && node2.left == null) {
            isDuiChen = true;
            return;
        } else {
            isDuiChen = false;
            return;
        }

    }


    public boolean compare2(ListNode left, ListNode right) {
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;
        else return compare2(left.left, right.right) && compare2(left.right, right.left);
    }

    public boolean isSymmetric(ListNode root) {
        if (root == null) return true;
        return compare2(root.left, root.right);
    }


    class ListNode {
        int val;
        ListNode left;
        ListNode right;

        ListNode(int x) {
            val = x;
        }

        public ArrayList<Integer> list(ArrayList<Integer> list) {
            if (this == null) return list;

            if (null != this.left) this.left.list(list);
            list.add(this.val);
            if (null != this.right) this.right.list(list);

            return list;
        }
    }
}

package com.company.nowcode;

import org.junit.Test;

import javax.naming.InvalidNameException;

/**
 * @author SmileAlfred
 * @create 2021-03-12 8:24
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 给定一个链表，请判断该链表是否为回文结构。
 * 示例1
 * 输入
 * [1,2,2,1]
 * 返回值
 * true
 */
public class NC96HuiWenLikedList {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);

        boolean pail = isPail(head);
        System.out.println(" 是回文链表吗？ " + pail);

    }

    /**
     * 这里不能用 reverseNode.equals(head)的方法，因为没有重写其方法
     *
     * @param head
     * @return
     */
    public boolean isPail(ListNode head) {
        // write code here
        if (head == null || head.next == null) return true;

        //1.反转链表
        ListNode reverseNode = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode swopNode = new ListNode(temp.val);
            swopNode.next = reverseNode;
            reverseNode = swopNode;
            temp = temp.next;
        }
        System.out.println("head : " + head+"\nreverseNode : " + reverseNode);

        //2.判断该链表是否等于反转后的链表
        boolean flag = true;
        while (reverseNode != null) {
            if (reverseNode.val != head.val) {
                return false;
            } else {
                reverseNode = reverseNode.next;
                head = head.next;
            }
        }
        return flag;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        @Override
        public String toString() {
            return val + " -> " + next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
}

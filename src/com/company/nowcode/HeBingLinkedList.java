package com.company.nowcode;

import java.util.List;

/**
 * @author SmileAlfred
 * @create 2021-03-06 8:43
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 合并两个有序链表，使合并后 依旧有序
 */
public class HeBingLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);


        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        if (null == l1) return l2;
        if (null == l2) return l1;
        //把头节点大的部分作为新的节点
        boolean l1AsHead = l1.val < l2.val;
        ListNode res = new ListNode(l1AsHead ? l1.val : l2.val);
        ListNode temp = res;

        ListNode cur1 = l1AsHead ? l1.next : l1;

        ListNode cur2 = l1AsHead ? l2 : l2.next;
        while (null != cur1 && null != cur2) {

            l1AsHead = cur1.val < cur2.val;
            temp.next = new ListNode(l1AsHead ? cur1.val : cur2.val);
            temp = temp.next;
            cur1 = l1AsHead ? cur1.next : cur1;
            cur2 = l1AsHead ? cur2 : cur2.next;

        }

        if (null == cur1) temp.next = cur2;
        if (null == cur2) temp.next = cur1;


        return res;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return " " + val + " - > " + next;
        }
    }
}

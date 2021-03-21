package com.company.nowcode;

import org.junit.Test;

/**
 * @author SmileAlfred
 * @create 2021-03-17 21:59
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/c087914fae584da886a0091e877f2c79?tpId=188&tqId=38028&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC25删除有序链表中重复的元素
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * 例如：
 * 给出的链表为1 -> 1 -> 2 ,返回1  ->  2.
 * 给出的链表为1 -> 1 ->  2  ->  3  ->  3 ,返回1 ->  2  ->  3 .
 */
public class NC25DelChongFuNode {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);

        System.out.println("去重前链表:" + head);
        ListNode listNode = deleteDuplicates(head);
        System.out.println("去重后链表:" + listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (null == head || null == head.next) return head;
        ListNode temp = head;
        while (null != temp && null != temp.next) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else temp = temp.next;
        }
        return head;
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

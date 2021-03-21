package com.company.nowcode;

import org.junit.Test;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.xml.bind.SchemaOutputResolver;

/**
 * @author SmileAlfred
 * @create 2021-03-18 19:25
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/f95dcdafbde44b22a6d741baf71653f6?tpId=188&tqId=38086&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC53删除链表的倒数第n个节点
 * 题目描述
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 * 例如，
 * 给出的链表为:1->2->3->4->5, n= 2.
 * 删除了链表的倒数第 n 个节点之后,链表变为1->2->3->5.
 * 备注：
 * 题目保证 n一定是有效的
 * 请给出请给出时间复杂度为\ O(n) O(n)的算法
 * <p>
 * 示例1
 * 输入  {1,2},2
 * 返回值  {2}
 */
public class NC53DelNode {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 5;
        System.out.print("链表 " + head + " 删除倒数第 " + n + " 个节点后，结果为：");

        ListNode listNode = removeNthFromEnd(head, n);
        System.out.println(listNode);
    }

    /**
     * 跟前几天做的一道题目一样，我用的方法是栈，有个小哥用的是快慢指针，当让效果差别不大
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if (null == head) return head;

        ListNode fastNode = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        ListNode slowNode = new ListNode(-1);
        //slowNode 指向 head 的前一个结点，方便之后删除该元素。
        slowNode.next = head;

        //这一步有点骚，解决了 fastNode 走完后，应该去除 head 的问题
        if (fastNode == null) return head.next;

        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
    }

    class ListNode {
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

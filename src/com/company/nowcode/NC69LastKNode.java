package com.company.nowcode;

import org.junit.Test;
import org.junit.internal.runners.statements.FailOnTimeout;

import javax.xml.transform.Source;
import java.util.List;
import java.util.Stack;

/**
 * @author SmileAlfred
 * @create 2021-03-17 11:04
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=188&tqId=38050&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC69链表中倒数第 K 个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 示例1 输入 {1,2,3,4,5},1
 * 返回值  {5}
 */
public class NC69LastKNode {
    @Test
    public void test() {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(2);
        pHead.next.next = new ListNode(3);
        pHead.next.next.next = new ListNode(4);
        pHead.next.next.next.next = new ListNode(5);
        System.out.print("链表：" + pHead + "\n\n");

        int k = 2;
        for (int i = -2; i < 8; i++) {

            ListNode listNode = FindKthToTail(pHead, i);
            System.out.println(" 中倒数第 " + i + " 个结点是：" + listNode);
        }
    }

    public ListNode FindKthToTail(ListNode pHead, int k) {
        if (k < 1) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = pHead;
        while (null != temp) {
            stack.push(temp);
            temp = temp.next;
        }


        for (int i = 0; i < k - 1 && !stack.isEmpty(); i++) {
            stack.pop();
        }
        if (!stack.isEmpty()) return stack.pop();
        else return null;

    }

    /**
     * 大神思路：在链表中：倒数的 + 顺数的长度等于链表总长度，所以可以设置两个指针，一个先走K步，
     * 剩下的到链表的末尾要走的步数就是倒数第k个节点，需要从头开始走的步数
     *
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode pHead, int k) {
        // write code here
        ListNode first = pHead;
        for (int i = 0; i < k; i++) {
            if (first == null) return first;
            first = first.next;
        }

        ListNode last = pHead;
        while (first != null) {
            first = first.next;
            last = last.next;
        }
        return last;
    }


    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }
}

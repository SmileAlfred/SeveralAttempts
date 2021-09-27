package com.company.nowcode;

import org.junit.Test;

import java.util.List;

/**
 * @author SmileAlfred
 * @create 2021-03-28 8:03
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=117&tqId=37726&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC21链表内指定区间反转
 * 题目描述
 * 将一个链表\ m m 位置到\ n n 位置之间的区间反转，要求时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)。
 * 例如：
 * 给出的链表为 1→ 2 → 3 → 4 → 5 → NULL, m=2,n=4,
 * 返回 1→ 4→ 3→ 2→ 5→ NULL,
 * 注意：
 * 给出的 mm,nn 满足以下条件：
 * 1 ≤ m ≤ n ≤ 链表长度
 * 示例1
 * 输入  {1,2,3,4,5},2,4
 * 返回值  {1,4,3,2,5}
 */
public class NC21ReverseLinkedlist {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int m = 1, n = 3;
        System.out.println(head + " 翻转 " + m + " ~ " + n + " 后链表为");
        ListNode listNode = reverseBetween(head, m, n);
        System.out.println(listNode);
    }

    /**
     * 注意，此处的 m n 的起始位置是 1，
     * 本题很简单关键在于！当 m==n 时直接返回，当 m = 1 时，需要添加新的 pre,此时在交换过程中，要注意 head 的赋值！不然 head 就丢了
     * 需要的辅助结点：
     * tempHead → 临时性 head, 指向 m 的前一个结点，每次将下一个结点添加到 pre 之后
     * cur → 待交换的结点，该节点首次指向的是 m 的后一个节点，进行交换；
     * lastNode → 其实就是 m 的结点，交换结束后他是最后一个！
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        //TODO:如果 m = 1;的处理
        //tempHead 总是指向，m 的前一个结点
        if (m == n) return head;

        ListNode tempHead = head;
        if (m > 1) {
            for (int i = 1; i < m - 1; i++) {
                tempHead = tempHead.next;
            }
        } else {
            tempHead = new ListNode(-1);
            tempHead.next = head;
        }
        ListNode lastNode = tempHead.next;
        ListNode cur = tempHead.next.next;

        for (int i = 1; null != cur && i <= n - m; i++) {
            lastNode.next = cur.next;
            cur.next = tempHead.next;
            tempHead.next = cur;
            cur = lastNode.next;
        }


        return m == 1 ? tempHead.next : head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + " → " + next;
        }
    }
}

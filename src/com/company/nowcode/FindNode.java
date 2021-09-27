package com.company.nowcode;

import java.util.Queue;

/**
 * @author SmileAlfred
 * @create 2021-03-06 10:26
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/6e630519bf86480296d0f1c868d425ad?tpId=188&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 能给出不利用额外空间的解法么？
 * 难点！从头到第一次相遇的距离 == 快指针从相遇位置转一圈(此时跟慢指针节奏一样)到相遇位置
 */
public class FindNode {
    public ListNode detectCycle(ListNode head) {
        return hasRing(head);
    }

    /**
     * 快慢指针判断是否有环
     *
     * @param head
     * @return
     */
    private ListNode hasRing(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                slow = head;
                while (slow!=null && quick!=null){
                    if(slow == quick){
                        return slow;
                    }
                    slow = slow.next;
                    quick = quick.next;
                }
            }

        }
        return null;
    }
    public ListNode test(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow){                 //利用快慢指针找相遇点
                ListNode slow2=head;    //设置以相同速度的新指针从起始位置出发
                while(slow2!=slow){      //未相遇循环。
                    slow=slow.next;
                    slow2=slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}

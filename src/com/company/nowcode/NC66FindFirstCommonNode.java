package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author SmileAlfred
 * @create 2021-03-11 11:26
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class NC66FindFirstCommonNode {
    @Test
    public void test() {
        ListNode pHead1 = new ListNode(1);
        pHead1.next = new ListNode(2);
        pHead1.next.next = new ListNode(3);

        ListNode pHead2 = new ListNode(2);
        pHead2.next = new ListNode(9);
        pHead2.next.next = pHead1.next;
        System.out.println("链表一：" + pHead1 + "\n链表二：" + pHead2);
        ListNode listNode = FindFirstCommonNode(pHead1, pHead2);
        System.out.println("结点是：" + listNode);
    }


    /**
     * 看下面的链表例子：
     * 0-1-2-3-4-5-null
     * a-b-4-5-null
     * 代码的 if else 语句，对于某个指针 p1 来说，其实就是让它跑了连接好的的链表，长度就变成一样了。
     * 如果有公共结点，那么指针一起走到末尾的部分，也就一定会重叠。看看下面指针的路径吧。
     * p1： 0-1-2-3-4-5-null(此时遇到ifelse)-a-b-4-5-null
     * p2: a-b-4-5-null(此时遇到ifelse)0-1-2-3-4-5-null
     * 因此，两个指针所要遍历的链表就长度一样了！
     * 如果两个链表存在公共结点，那么p1就是该结点，如果不存在那么p1将会是null。
     * @param pHead1
     * @param pHead2
     * @return
     */
    private ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != p2){
                if(p1 == null)p1 = pHead2;
                if(p2 == null)p2 = pHead1;
            }
        }
        return p1;
    }


    //虽然能解决问题，但是思路不对！
    public ListNode FindFirstCommonNodeError(ListNode pHead1, ListNode pHead2) {
        ArrayList<ListNode> res = new ArrayList<>();
        ListNode temp1 = pHead1;
        while (null != temp1) {
            res.add(temp1);
            temp1 = temp1.next;
        }

        ListNode temp2 = pHead2;
        while (null != temp2) {
            if (res.contains(temp2)) return temp2;
            temp2 = temp2.next;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next = null;

        @Override
        public String toString() {
            return val + " -> " + next;
        }

        ListNode(int val) {
            this.val = val;
        }
    }

}


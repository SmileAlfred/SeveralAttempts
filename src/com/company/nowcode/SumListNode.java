package com.company.nowcode;

import com.sun.org.apache.xml.internal.serializer.ToSAXHandler;
import javafx.animation.PauseTransitionBuilder;
import org.junit.Test;

import java.util.Stack;

/**
 * @author SmileAlfred
 * @create 2021-03-10 19:30
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description
 */
public class SumListNode {
    @Test
    public void test() {
        ListNode head1 = new ListNode(9);
        ListNode node3 = new ListNode(3);
        head1.next = node3;
        ListNode node7 = new ListNode(7);
        node3.next = node7;
        ListNode node4 = new ListNode(4);
        node7.next = node4;

        ListNode node6 = new ListNode(3);
        ListNode head2 = new ListNode(6);
        head2.next = node6;

        System.out.println("head1 = " + head1 + " ;\nhead2 = " + head2);

        //错误，递归不好使
        //ListNode listNode = addInList(head1, head2);
        //System.out.println("addInList() " + listNode);

        //使用栈，成功，
        ListNode listNode1 = SumByStack(head1, head2);
        System.out.println("SumByStack() " + listNode1);


    }

    /**
     * 递归法；报错不可行
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        // write code here
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        if (null == temp1.next && null == temp2.next) {
            int sum = (temp1.val + temp2.val) % 10;
            jinwei = (temp1.val + temp2.val) / 10;
            temp1.val = sum;
            temp2.val = sum;

            return head1;
        } else if (temp1.next != null && temp2.next != null) return addInList(temp1.next, temp2.next);
        else if (temp1.next != null && temp2.next == null) return addInList(temp1.next, temp2);
        else return addInList(temp1, temp2.next);

    }

    int jinwei = 0;


    public ListNode SumByStack(ListNode head1, ListNode head2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        while (head1 != null || null != head2) {
            if (head1 != null) {
                stack1.push(head1.val);
                head1 = head1.next;
            }

            if (head2 != null) {
                stack2.push(head2.val);
                head2 = head2.next;
            }
        }

        //查看栈内元素
        /*while (!stack1.empty()) {
            System.out.println("stack1.pop " + stack1.pop());
        }
        System.out.println();
        while (!stack2.empty()) {
            System.out.println("stack2.pop " + stack2.pop());
        }
        return null;*/

        ListNode res = null;
        int sum = 0, jinwei = 0;
        while (!stack1.empty() || !stack2.empty()) {
            int a = stack1.empty() ? 0 : stack1.pop();
            int b = stack2.empty() ? 0 : stack2.pop();

            sum = (jinwei + a + b) % 10;
            jinwei = (jinwei + a + b) / 10;
            ListNode tempNode = new ListNode(sum);

            tempNode.next = res;
            res = tempNode;
        }
        if (jinwei == 1) {
            ListNode firstNode = new ListNode(1);
            firstNode.next = res;
            res = firstNode;
        }

        return res;
    }


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




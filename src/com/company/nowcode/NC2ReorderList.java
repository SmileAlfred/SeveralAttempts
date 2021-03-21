package com.company.nowcode;

import org.junit.Test;
import sun.java2d.pipe.SolidTextRenderer;

import javax.xml.transform.Source;
import java.awt.*;

/**
 * @author SmileAlfred
 * @create 2021-03-12 9:44
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 将给定的单链表 L：  L_0→L_1→…→L_{n-1}→L_ n
 * 重新排序为：       L_0→L_n →L_1→L_{n-1}→L_2→L_{n-2}→…
 * 要求使用原地算法，不能改变节点内部的值，需要对实际的节点进行交换。
 * 例如：
 * 对于给定的单链表{10,20,30,40}，将其重新排序为{10,40,20,30}.
 *
 * 解法有很多，我选择了最笨的法子，其实可以在找到中间节点的时候，让其断成两个链表！方便操作啊！后半部链表翻转，而后插在指定位置；
 * 另一个思路，将链表依次压入栈；最后没遇到一个 空位，就从栈中pop一个节点，插在该空，跳出的条件是：当该空的前或后节点与出栈节点一致，
 * 那么就跳出，并且将该节点 的 next 置为 null;
 */
public class NC2ReorderList {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(4);
        //head.next.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next.next = new ListNode(6);
        //head.next.next.next.next.next.next.next = new ListNode(7);
        //head.next.next.next.next.next.next.next.next = new ListNode(8);
        //head.next.next.next.next.next.next.next.next.next = new ListNode(9);
        //head.next.next.next.next.next.next.next.next.next.next = new ListNode(10);

        System.out.println(head);//0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
        reorderList(head);
        System.out.println(head);//0 -> 10 -> 1 -> 9 -> 2 -> 8 -> 3 -> 7 -> 4 -> 6 -> 5
    }


    /**
     * 三步走，思路很清晰，但是是实现起来太复杂！
     * @param head
     */
    public void reorderList(ListNode head) {
        //1. 快慢指针找到 中间 节点//0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 节点 = 5
        if (null == head || null == head.next || null == head.next.next) return;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (null != fastNode && null != fastNode.next) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        System.out.println("中间节点找到了 " + slowNode);

        //2. 中间节点后的 链表反转//0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 10 -> 9 -> 8 -> 7 -> 6
        ListNode tempNode = slowNode.next;
        ListNode curNode = tempNode;
        while (null != curNode.next) {
            slowNode.next = curNode.next;
            curNode.next = slowNode.next.next;
            slowNode.next.next = tempNode;
            tempNode = slowNode.next;
        }
        System.out.println("反转之后：" + head);//

        //3. 从中间节点开始，依次将之后的元素插在合适的位置；//0 -> 10 -> 1 -> 9 -> 2 -> 8 -> 3 -> 7 -> 4 -> 6 -> 5
        tempNode = head;
        ListNode pre = null;
        while (slowNode.next != null || null == tempNode) {
            //此时，tempNode == slowNode;但右侧仍有一个不为空的 node,应该插在slowNode前；
            if (slowNode == tempNode && slowNode.next != null) break;
            ListNode insertNode = slowNode.next;
            slowNode.next = insertNode.next;
            insertNode.next = tempNode.next;//
            tempNode.next = insertNode;
            pre = tempNode.next;
            tempNode = tempNode.next.next;
            //System.out.println(head);
            System.out.println("tempNode = " + tempNode + " ; slowNode.next  = " + slowNode.next + " ; pre = " + pre);
        }
        if (slowNode.next != null) {
            //此时 insertNode 即 slowNode 的上一个节点，
            pre.next = slowNode.next;
            slowNode.next = null;
            System.out.println("\n" + pre);
            pre.next.next = slowNode;
            System.out.println(pre);
        }

        System.out.println("插入之后：" + head);

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }

}

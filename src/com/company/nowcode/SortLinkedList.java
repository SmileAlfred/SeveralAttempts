package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author SmileAlfred
 * @create 2021-03-06 16:25
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 将多个有序链表 排序
 */
public class SortLinkedList {
    public static void main(String[] args) {
        ArrayList<ListNode> lists = new ArrayList<>();
        lists.add(new ListNode(1));
        lists.add(new ListNode(3));
        lists.add(new ListNode(2));
        lists.add(new ListNode(5));
        //ListNode listNode = mergeKLists(lists);
        //System.out.println(listNode);


        mergeKLists2(lists);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "val=" + val + ", next=" + next;
        }
    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) return null;
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            ListNode node = lists.get(i);
            if (null == node) continue;
            while (null != node) {
                resList.add(node.val);
                node = node.next;
            }
        }
        if (resList.size() < 1) return null;
        Collections.sort(resList);

        ListNode resNode = new ListNode(resList.get(0));
        ListNode temp = resNode;
        for (int i = 1; i < resList.size(); i++) {
            temp.next = new ListNode(resList.get(i));
            temp = temp.next;
        }
        return resNode;


    }


    /**
     * 合并k个已排序的链表并将其作为一个已排序的链表返回。
     * 分析并描述其复杂度。---熟悉mergeSort,返回值不同！！当low>=high,则说明有序，直接返回lists.get(low)
     * @param lists k个已排序的链表
     * @return 一个已排序的链表
     */
    public static ListNode mergeKLists2(ArrayList<ListNode> lists) {
        if(lists==null||lists.size()==0){
            return null;
        }
        return mergeKLists(lists,0,lists.size()-1);
    }

    /**
     * 递归的获取 集合中每一个链表，并将其两两对比排序
     * @param lists
     * @param low
     * @param high
     * @return
     */
    public static ListNode mergeKLists(ArrayList<ListNode> lists,int low,int high){
        if(low>=high){
            return lists.get(low);
        }
        int mid=low+(high-low)/2;
        ListNode l1=mergeKLists(lists,low,mid);
        ListNode l2=mergeKLists(lists,mid+1,high);
        return merge(l1,l2);
    }

    /**
     * 递归的去比较两个 结点 的值的大小
     * @param l1
     * @param l2
     * @return 递增的有序链表
     */
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }

    }


    @Test
    public void test(){
        //String HC05SAddress = "14:A3:2F:63:EB:FA";
        //System.out.println(HC05SAddress + " ; "+HC05SAddress.length());
        System.out.println("34-23-87-40-73-04".replaceAll("-",":"));


    }

}

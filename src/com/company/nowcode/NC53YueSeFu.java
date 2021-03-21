package com.company.nowcode;

import jdk.nashorn.internal.runtime.CodeInstaller;
import jdk.nashorn.internal.runtime.Source;
import org.junit.Test;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SmileAlfred
 * @create 2021-03-18 19:46
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/41c399fdb6004b31a6cbb047c641ed8a?tpId=188&tqId=38087&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC132环形链表的约瑟夫问题
 * 题目描述
 * 编号为1到n的n个人围成一圈。从编号为1的人开始报数1，依次下去，报到m的人离开，问最后留下的一个人，编号是多少？
 * 示例1
 * 输入  5,2
 * 返回值  3
 */
public class NC53YueSeFu {

    @Test
    public void test() {
        int n = 5, m = 2;
        int ysf = ysf(n, m);
        System.out.println(5 + " 个小伙伴围一圈，数 " + m + " 的人出圈。最后留在圈里的人是：" + ysf);
    }

    /**
     * 反推过程：(当前index + m) % 上一轮剩余数字的个数
     * 最终剩下一个人时的安全位置肯定为1，反推安全位置在人数为n时的编号
     * @param n
     * @param m
     * @return
     */
    public int ysf(int n, int m) {
        if (m < 1 || n < 1)
            return -1;
        int last = 0;
        // i代表有目前有个人
        //最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last + 1;
    }

    /**
     * 使用集合解决约瑟夫问题
     * 约瑟夫问题重在理解，一个是环形循环取出，一个是取出当前元素后，下一个元素从 1 开始报数；
     * 这是唯一一个让我满意的代码，因为没有找到Java自带的单链表，自己写一个也没有必要，
     * 其实循环链表本就可以用数组和集合完成，只是数组取出数据不方便，故用集合；
     *
     * @param n
     * @param m
     * @return
     */
    public int mYsf(int n, int m) {
        // write code here
        List<Integer> children = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            children.add(i);
        }
        System.out.println("⚪ " + children);

        int index = 0;
        while (children.size() > 1) {
            //注意：此处异地更要让 index 取模，而且取模的对象不是 n，而是实际 list.size()；
            index = (index + m - 1) % children.size();
            System.out.println("index = " + index + " ; size = " + children.size() + " ; 即将移出的是 " + children.get(index));
            children.remove(index);
        }

        return children.get(0);
    }
}

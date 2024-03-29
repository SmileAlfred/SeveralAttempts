package com.company.nowcode;


import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

/**
 * @author SmileAlfred
 * @create 2021-03-05 16:28
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 * 示例1
 * 输入
 * 复制
 * [[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
 * 返回值
 * 复制
 * [1,-1]
 * 说明
 * 第一次操作后：最常使用的记录为("1", 1)
 * 第二次操作后：最常使用的记录为("2", 2)，("1", 1)变为最不常用的
 * 第三次操作后：最常使用的记录为("3", 2)，("1", 1)还是最不常用的
 * 第四次操作后：最常用的记录为("1", 1)，("2", 2)变为最不常用的
 * 第五次操作后：大小超过了3，所以移除此时最不常使用的记录("2", 2)，加入记录("4", 4)，并且为最常使用的记录，然后("3", 2)变为最不常使用的记录
 */

public class Solution {
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int k;

    public static void main(String[] args) {
        //用来测试
        Solution solution = new Solution();
        int[][] operators = new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int k = 3;
        int[] lru = solution.LRU(operators, k);
        System.out.println(Arrays.toString(lru));
    }

    public int[] LRU(int[][] operators, int k) {
        this.k = k;
        head.next = tail;
        tail.prev = head;
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        for (int i = 0, j = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                res[j++] = get(operators[i][1]);
            }
        }
        return res;
    }

    private void set(int key, int val) {
        if (get(key) > -1) {
            map.get(k).val = val;
        } else {
            if (map.size() == k) {
                int rk = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                map.remove(rk);
            }
            Node node = new Node(key, val);
            map.put(key, node);
            moveToHead(node);
        }
    }

    private int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    static class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
package com.company.nowcode;

import org.junit.Test;

import java.util.*;

/**
 * @author SmileAlfred
 * @create 2021-03-12 15:26
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 题目描述
 * 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 示例1 输入  [[1,3],[1,2],[1,1],[3],[2],[3]]
 * 返回值   [1,2]；注意，getMin() 进返回值，并不进行pop;pop 并没有返回值；却影响栈的结构
 */
public class NC90GetMinStack {
    @Test
    public void Test() {
        int[][] op = new int[][]{{1, 3}, {1, 2}, {1, 1}, {3}, {2}, {3}};
        int[] minStack = getMinStack(op);
        System.out.println(Arrays.toString(minStack));
    }

    public int[] getMinStack(int[][] op) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        //数据、和 i
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < op.length; i++) {
            if (op[i].length == 2) {
                stack.push(op[i][1]);
                map.put(op[i][1], map.size());
                continue;
            }
            if (op[i][0] == 2) {
                Integer pop = stack.pop();
                map.remove(pop, map.size() - 1);
            }
            if (op[i][0] == 3) {
                Set<Integer> integers = map.keySet();
                list.add(Collections.min(integers));
            }

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

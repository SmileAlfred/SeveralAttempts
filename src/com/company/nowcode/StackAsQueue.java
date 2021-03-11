package com.company.nowcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author SmileAlfred
 * @create 2021-03-09 13:43
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 使用两个 stack 代替 queue
 */
public class StackAsQueue {
    @Test
    public void test2() {
        //["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
        push(1);
        push(2);
        push(3);
        pop();
        pop();
        push(4);
        pop();
        push(5);
        pop();
        pop();

    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

        /*if (stack1.isEmpty()) {
            stack1.push(node);
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(node);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }*/
    }

    public int pop() {
        int node = 0;
        if (stack1.isEmpty()) return 0;
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        node = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        System.out.println(node);
        return node;
    }
}

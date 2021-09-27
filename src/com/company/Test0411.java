package com.company;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author SmileAlfred
 * @create 2021-04-11 13:56
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description
 */
public class Test0411 {

    @Test
    public void test3(){
        int  a = 6,b=3;
        int maxNum = getMaxNum(a, b);
        System.out.println(a + " 和 " + b +" 互质吗？" + (maxNum ==1?"是":"否"));
    }
    public int getMaxNum(int a, int b) {
        if (b == 0) return a;
        return a % b == 0 ? b : getMaxNum(b, a % b);
        //return getMaxNum(b, a % b);
    }


    public static void main(String[] agrs) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        char[] c = new char[100];
        int m = solve(n, 26, c);
        for (int i = m; i >= 0; i--)
            System.out.print(c[i]);
    }

    /**
     * 进制转换：
     *
     * @param n 代转换的数据
     * @param r 进制数：如 26 进制，r = 26
     * @param c 转换后的结果存在在其中，实对 值 的修改！
     * @return 返回的是 转换进之后多少位！
     */
    public static int solve(int n, int r, char c[]) {
        int i = -1;
        while (n > 0) {
            i++;
            int t = n % r;
            //巧妙解决 26 / 26 = 0 的问题
            n = (n - 1) / r;
            //解决 26 % 26 = 0 的问题
            if (t == 0) t = 26;
            //java中强制转化；将值修改到数组里
            c[i] = (char) ('A' + t - 1);
        }
        return i;
    }


    @Test
    public void test2() {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};

        res(preOrder, inOrder);
    }

    /**
     * 依次找出结点，逆序添加到 inOrder
     *
     * @param preOrder
     * @param inOrder
     */
    private void res(int[] preOrder, int[] inOrder) {

    }


    @Test
    public void test() {
        int n = 13;
        int res = 0;
        findIt(n);
        System.out.println(res);
    }

    /**
     * 输入 13 ，找到 4 + 9  、16 25 36……
     * 要求返回的数要最少！
     *
     * @param n 返回个数，即 4 9 返回 2；
     * @return
     */
    int sum = 0, i = 1;

    public void findIt(int n) {


    }


}

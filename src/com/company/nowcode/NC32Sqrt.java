package com.company.nowcode;

import org.junit.Test;

/**
 * @author SmileAlfred
 * @create 2021-03-11 20:30
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 实现函数 int sqrt(int x).
 * 计算并返回x的平方根（向下取整）
 * 示例1
 * 输入
 * 2
 * 返回值
 * 1
 */
public class NC32Sqrt {
    @Test
    public void test() {
        int x = 2;
        for (int i = -3; i < 50; i++) {
            int sqrt = sqrt2(i);
            System.out.println(i + " 的平方根是：" + sqrt);
        }
    }


    public int sqrt(int x) {
        // write code here
        if (x <= 0) return 0;
        for (int i = 0; i <= x / 2 + 1; i++) {
            int temp = i * i;
            if (temp == x) {
                return i;
            } else if (temp > x) {
                return i - 1;
            }
        }
        return 0;
    }

    public int sqrt2(int x) {
        double res = x;
        for (int i = 0; i < 10; i++) {
            res = res - ((res * res - x) / (2 * res));
        }
        return (int) res;
    }
}

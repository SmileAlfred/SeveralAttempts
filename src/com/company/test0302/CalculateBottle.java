package com.company.test0302;

/**
 * @author SmileAlfred
 * @create 2021-03-02 21:25
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description
 */
public class CalculateBottle {
    static int money = 40;

    public static void main(String[] args) {
        CalculateBottle calculateBottle = new CalculateBottle();// 10/2: 10只拥有的金额, 2是指汽水两块钱一瓶 这里的金额可以动态改变
        int calculateBottle1 = calculateBottle.calculateBottle(10 / 2, 0, 0);
        System.out.println(calculateBottle1);
    }

    /**
     * 传入金额 计算可以换购的总汽水的数量
     * 一瓶汽水2元 3个瓶盖换一瓶汽水 2个瓶身换一瓶汽水
     * 问用40,60,80元分别最多可以换购多少汽水
     *
     * @param total* @return
     */
    public int calculateBottle(int total, int cap, int bottle) {
        int captotal = 0, bottletotal = 0;
        if (total == 0 && cap < 3 && bottle < 2) {
            return total;
        }
        if (cap > 2) {
            captotal = cap / 3;
            cap = cap % 3;
        }
        if (bottle > 1) {
            bottletotal = bottle / 2;
            bottle = bottle % 2;
        }
        return total + calculateBottle(captotal + bottletotal, cap + total, bottle + total);
    }
}

package com.company.nowcode;

import org.junit.Test;

/**
 * @author SmileAlfred
 * @create 2021-03-11 21:55
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 进制转换
 */
public class NC112JinZhiTransfer {

    @Test
    public void test() {
        String solve = solve(-4, 3);
        System.out.println(solve);
    }

    public String solve(int M, int N) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int shang = Math.abs(M);
        int yushu = 0;

        while (Math.abs(shang) > N) {
            yushu = shang % N;
            shang = shang / N;
            if (yushu < 10) sb.append(yushu);
            else sb.append(Character.valueOf((char) (55 + yushu)));
        }
        sb.append(shang);
        if (M < 0) sb.append("-");
        sb = sb.reverse();
        return sb.toString();
    }
}

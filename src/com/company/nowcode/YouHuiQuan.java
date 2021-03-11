package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author SmileAlfred
 * @create 2021-03-09 13:39
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 3.2 日 猿辅导的面试算法题
 */
public class YouHuiQuan {
    ArrayList<Integer> result = new ArrayList<Integer>();
    HashMap<Integer, ArrayList> map = new HashMap<>();

    /**
     * 优惠券问题 现有 20 30 50 120 券数张，找出组合使其综合不超过 110
     *
     * @param sum
     */
    public void YouHuiQuan(int sum) {
        int[] quan = {20, 30, 50, 120};

        if (sum > 110) {
            return;
        }

        for (int i = 0; i < quan.length; i++) {

            sum = sum + quan[i];
            result.add(quan[i]);

            YouHuiQuan(sum);
            //System.out.print(sum + " ; " +result + "\t");
            if (result.size() > 0) sum = sum - result.get(result.size() - 1);
            if (result.size() > 0) result.remove(result.size() - 1);
            map.put(sum,new ArrayList<>(result));
            //System.out.println(" i = " + i + " ; " + sum + " ; " + result + "\n");
        }
    }
    @Test
    public void test4() {
        YouHuiQuan(0);
        System.out.println(map);
    }

}

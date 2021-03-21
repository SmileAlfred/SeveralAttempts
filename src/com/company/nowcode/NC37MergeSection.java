package com.company.nowcode;

import org.junit.Test;

import javax.management.ImmutableDescriptor;
import javax.management.MXBean;
import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author SmileAlfred
 * @create 2021-03-16 10:18
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/69f4e5b7ad284a478777cb2a17fb5e6a?tpId=188&tqId=38073&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC37合并区间
 * 给出一组区间，请合并所有重叠的区间。 请保证合并后的区间按区间起点升序排列。
 * 输入  * [[10,30],[20,60],[80,100],[150,180]]
 * 返回值  * [[10,60],[80,100],[150,180]]
 */
public class NC37MergeSection {

    @Test
    public void test() {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(1, 10));

        System.out.println("原集合：" + intervals + " ; " + intervals.get(intervals.size() - 1));
        //while (intervals.contains(null)) {
        //    intervals.remove(null);
        //}
        //System.out.println("除去null：" + intervals + " ; " + intervals.get(intervals.size() - 1));
        ArrayList<Interval> res = merge(intervals);
        System.out.println("结果：" + res);
    }

    /**
     * 大手写法，以 左边界排序，随后如果 取出的 intercal 的左边界小于上一个的 有边界，那么把上一个区间扩张，知道不满足，跳出后添加到 res 中
     * @param intervals
     * @return
     */
    private ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        Collections.sort(intervals,(a, b)->a.start-b.start);
        int len = intervals.size();
        int i = 0;
        while (i < len) {
            int left = intervals.get(i).start;
            int right = intervals.get(i).end;
            while (i < len-1 && intervals.get(i+1).start <= right) {
                right = Math.max(right,intervals.get(i+1).end);
                i++;
            }
            res.add(new Interval(left,right));
            i++;
        }
        return res;
    }

    /**
     * 修修补补，最后还是错！思路错了，在努力都是白费！
     *
     * @param intervals
     * @return
     */
    public ArrayList<Interval> mergeError(ArrayList<Interval> intervals) {
        if (intervals.size() < 2) return intervals;


        if (intervals.size() == 2) {
            if (intervals.get(0).end >= intervals.get(1).start &&
                    intervals.get(0).start <= intervals.get(1).end) {
                Interval temp = new Interval(Math.min(intervals.get(0).start, intervals.get(1).start), Math.max(intervals.get(0).end, intervals.get(1).end));
                intervals.remove(0);
                intervals.remove(0);
                intervals.add(0, temp);
                intervals.add(0, null);
                intervals.remove(null);
                return intervals;
            } else {
                intervals.sort(new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return o1.start - o2.start;
                    }
                });
                return intervals;
            }
        }


        //2. 遍历判断当前的 end 是否小于下个节点的 start；如果是那么 continue 进行下一个；否则进行合并，
        for (
                int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end < intervals.get(i + 1).start &&
                    intervals.get(i).start > intervals.get(i + 1).end) continue;
            else {
                Interval temp = new Interval(Math.min(intervals.get(i).start, intervals.get(i + 1).start), Math.max(intervals.get(i).end, intervals.get(i + 1).end));
                intervals.remove(0);
                intervals.remove(0);
                intervals.add(0, temp);
                intervals.add(0, null);
                if (i == intervals.size() - 2) intervals.remove(intervals.size() - 1);
            }

            System.out.println("\n第 " + i + " 个 for 循环：" + intervals);
        }


        while (intervals.contains(null)) {
            intervals.remove(null);
        }
        //1. 以 start 为准，做增序排列
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        System.out.println("排序后：" + intervals);
        return intervals;
    }

    /**
     * 使用一个标记位，将重叠的都重置这个标记位；问题，只有一个标记位……
     *
     * @param intervals
     * @return
     */
    public ArrayList<Interval> mergeError2(ArrayList<Interval> intervals) {
        if (intervals.size() < 2) return intervals;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval maxIntercal = intervals.get(0);
        ArrayList<Interval> res = new ArrayList<Interval>();

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= maxIntercal.end &&
                    intervals.get(i).end >= maxIntercal.start) {
                maxIntercal = new Interval(Math.min(intervals.get(i).start, maxIntercal.start),
                        Math.max(intervals.get(i).end, maxIntercal.end));
            } else res.add(intervals.get(i));
        }
        res.add(maxIntercal);

        res.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        return res;
    }



}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}
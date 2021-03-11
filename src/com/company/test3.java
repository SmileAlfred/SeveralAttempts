package com.company;

import org.junit.Test;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test3 {
    public static int[][] array = new int[][]{
            {1, 2, 3, 4, 5, 6, 7},
            {2, 3, 4, 5, 6, 7, 8},
            {3, 4, 5, 6, 7, 8, 9},
            {4, 5, 6, 7, 8, 9, 10},
            {5, 6, 7, 8, 9, 10, 11},
            {6, 7, 8, 9, 10, 11, 12},
            {7, 8, 9, 10, 11, 12, 13}};

    public static void main(String[] args) {
        String[] names = new String[]{"白田欣雨", "蔡昊天", "蔡卓恒", "陈日坤", "陈小婷", "范天庆", "高文静",
                "高逸轩", "韩杰茹", "郝迥超", "黄根", "蒋丛稷", "李丹阳", "李家森", "刘傲", "刘博伟", "刘科言",
                "刘素云", "李万军", "李文莉", "李昕宸", "卢怡如", "孟璐", "隋志远", "孙红彬", "孙雨", "谭博仁"};

        System.out.print("请输入名单：");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String hadNames = "";
        System.out.println("");
        while (!input.contains("..")) {
            input = scanner.nextLine();
            hadNames += input;
        }
        for (int i = 0; i < names.length; i++) {
            if (!hadNames.contains(names[i])) {
                System.out.print(names[i] + "、");
            }
        }


        //quickSort();
        //luhailin();
        //luhailin2(10000);

        //StringBuffer str = new StringBuffer("Hello World");
        //System.out.println(replaceSpace(str));
        // int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        // int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        //reConstructBinaryTree(pre,in);

        //doubleTest();

        //String temp = "the sky is            blue!";
        //temp = "jifgykoserhurjkcnhskdncvgkiyhnsjdukzecrunyst 827136547tr8yh74f8o9l3w92qujwhe8iu7ryhf uincymh9oxw,z.ej/09l8kyut8w9o,x.9elo58km4yu ;78p0[2845){*(){P:T*#Q)I(OPUQjfpii[upOYHUIYG 9430q80965tpyw4[h 898888888888888888888888888888888888888888 iouy4ewrt8iu7hgfo2UIYTRFYJHMGDSAI f87e6rwtyugfhkjhki ZHONGGUOGONGCHANDANGWANSUI MAOZHUXIWANSUI";
        //System.out.println("输出结果：" + reverseStr(temp));


        //String strs = "1 2 3 1";
        //System.out.println(Arrays.toString(chooseNote(4, strs)));

        //String str = "333.03";
        //System.out.println(str.matches("\\d+\\.\\d+"));//匹配小数

       /* String address = "14:A3:2F:63:EB:FA";//14A32F63EBFA
        String newAddress = "14A32F63EBFA";
        String result = "";
        for (int i = 0; i < newAddress.length(); i++) {
            result += newAddress.charAt(i);
            if (i % 2 != 0 && i < newAddress.length() - 1) {//偶！数！位！最后一个位置不补 :
                result += ":";
            }
        }
        System.out.println(result);*/


        /*String str = "P:123I:456D:789";
        str = str.replace("P:","").replace("I","").replace("D","");
        String[] strs = str.split(":");
        System.out.println(strs.length + " ; " + Arrays.toString(strs));*/

        /*String str1 = "PV:3536 SV:3500  -657";
        str1 = str1.replace(" ", "").replaceAll("PV:", "")
                .replaceAll("SV:", "");//PV:3536SV:3500-657

        try {
            byte[] be = str1.getBytes("gbk");
            String pv = new String(be, 0, getStrIndex(be, 4), "gbk");
            str1 =  str1.replace(pv,"");
            be = str1.getBytes("gbk");
            System.out.println("pv = " + pv );

            String sv = new String(be, 0, getStrIndex(be, 4), "gbk");
            System.out.println("sv = " + sv);
            str1 =  str1.replace(sv,"");
            System.out.println("pw = " + str1.replaceAll(sv,""));
        } catch (UnsupportedEncodingException e) {
            System.out.println("报错:" + e.getMessage());
        }*/

        //System.out.println(fillString("0100", 4));

        //    System.out.println(Integer.parseInt("0100"));
    }

    /**
     * @param res          eg:12
     * @param targetLength eg:4
     * @return eg:0012
     */
    public static String fillString(String res, int targetLength) {
        if (res.length() >= targetLength) return res;
        int resLen = res.length();
        for (int i = 0; i < targetLength - resLen; i++) {
            res = "0" + res;
        }
        return res;
    }

    public static int getStrIndex(byte[] be, int i) {
        //截取字节长度必须小于字符串字节长度
        if (i < be.length) {
            //asi小于0 则递归
            if (be[i] < 0) {
                i--;
                if (i > 0) {
                    getStrIndex(be, i);
                }
            }
        }
        return i;
    }


    /**
     * 正则表达式中\s匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v]
     * <p>
     * \f -> 匹配一个换页
     * \n -> 匹配一个换行符
     * \r -> 匹配一个回车符
     * \t -> 匹配一个制表符
     * \v -> 匹配一个垂直制表符
     * 而“\s+”则表示匹配任意多个上面的字符。另因为反斜杠在Java里是转义字符，所以在Java里，我们要这么用“\\s+”.
     * <p>
     * 那么问题来了，“\\s+”有啥使用场景呢？
     * <p>
     * 注:
     * <p>
     * [\s]表示，只要出现空白就匹配
     * [\S]表示，非空白就匹配
     */

    //挑选笔记
    public static int[] chooseNote(int count, String lover) {
        int jiShuHe = 0, ouShuHe = 0;
        String[] temps = lover.split(" ");
        int ouConunt = 0, jiCount = 0;
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                ouShuHe += (Integer.parseInt(temps[i]));
                ouConunt++;
            }
            if (i % 2 == 1) {
                jiShuHe += (Integer.parseInt(temps[i]));
                jiCount++;
            }
        }
        int tempCount = 0;
        int loverR = (jiShuHe > ouShuHe) ? jiShuHe : ouShuHe;
        tempCount = (jiShuHe > ouShuHe) ? jiCount : ouConunt;
        int index = (jiShuHe > ouShuHe) ? 1 : 0;
        for (; index < tempCount; ) {
            if (Integer.parseInt(temps[index]) == 0)
                tempCount--;
            index += 2;
        }

        int[] result = new int[]{loverR, tempCount};
        return result;
    }


    //字符串倒序
    public static String reverseStr(String str) {
        if (str.isEmpty()) return null;
        String[] splits = str.split(" ");
        List<String> list = new ArrayList();
        for (int i = 0; i < splits.length; i++) {
            splits[i] = splits[i].replaceAll(" ", "");
            if (!splits[i].isEmpty()) list.add(splits[i]);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = list.size() - 1; i > -1; i--) {
            stringBuffer.append(list.get(i) + " ");
        }
        return stringBuffer.toString();
    }


    public static void doubleTest() {

        double temp = 281.731832 / 3.14;
        System.out.println("temp = " + temp);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        System.out.println(" // " + root.val);
        return root;
    }


    public static String replaceSpace(StringBuffer str) {
        String mString = str.toString();
        mString = mString.replaceAll(" ", "%20");
        return mString;
    }


    /**
     * 连续两位数字，后一位比前一位大；比如：12；124；167；
     * 输出 1 - 10000 之间符合要求的数字
     */
    public static void luhailin() {
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            if (i < 100 && i > 11) {
                int gewei = i % 10;
                int shiwei = i / 10;
                if (gewei > shiwei) {
                    System.out.println(i + " 个位数 = " + gewei + " 十位数 = " + shiwei);
                    count++;
                }
            } else if (i < 1000 && i > 100) {
                int gewei = i % 10;
                int shiweishu = (i / 10) % 10;
                int baiweishu = i / 100;
                if (gewei > shiweishu || shiweishu > baiweishu) {
                    System.out.println(i + " 个位数 = " + gewei + " 十位数 = " + shiweishu + "  百位数 = " + baiweishu);
                    count++;
                }
            } else if (i > 1000) {
                int gweishu = i % 10;
                int shiweishu = (i / 10) % 10;
                int baiweishu = (i / 100) % 10;
                int qianweishu = i / 1000;
                if (gweishu > shiweishu || shiweishu > baiweishu || baiweishu > qianweishu) {
                    System.out.println(i + " 个位数 = " + gweishu + " 十位数 = " + shiweishu + "  百位数 = " + baiweishu + " 千位数 = " + qianweishu);
                    count++;
                }
            }
        }
        System.out.println("count = " + count);
    }

    public static void luhailin2(int num) {
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (compare(i)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("count = " + count);
    }

    public static boolean compare(int num) {
        boolean result = false;
        int yushu = num % 10;
        int shang = num / 10;
        if (shang == 0) {
            return false;
        }
        int yushu2 = shang % 10;

        if (yushu <= yushu2) {
            //坑;迭代结束还会回到 这里！
            if (compare(shang)) {
                return true;
            } else {
                return false;
            }
        } else {
            result = true;
        }
        return result;
    }

    //快速排序：从低到高
    private static void quickSort() {
        int[] origin = new int[10];
        System.out.print("原顺序：");
        for (int i = 0; i < origin.length; i++) {
            origin[i] = (int) (Math.random() * 100 + 1);
            System.out.print(origin[i] + " ; ");
        }
        quickSort(origin);
        //输出有序数组
        System.out.println("\n快速排序后：" + Arrays.toString(origin));
    }

    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
    }

    private static int partition(int[] arr, int low, int high) {
        //指定左指针i和右指针j
        int i = low;
        int j = high;

        //将第一个数作为基准值。挖坑
        int x = arr[low];

        //使用循环实现分区操作
        while (i < j) {//5  8
            //1.从右向左移动j，找到第一个小于基准值的值 arr[j]
            while (arr[j] >= x && i < j) {
                j--;
            }
            //2.将右侧找到小于基准数的值加入到左边的（坑）位置， 左指针想中间移动一个位置i++
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            //3.从左向右移动i，找到第一个大于等于基准值的值 arr[i]
            while (arr[i] < x && i < j) {
                i++;
            }
            //4.将左侧找到的打印等于基准值的值加入到右边的坑中，右指针向中间移动一个位置 j--
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        //使用基准值填坑，这就是基准值的最终位置
        arr[i] = x;//arr[j] = y;
        //返回基准值的位置索引
        return i; //return j;
    }

    private static void quickSort(int[] arr, int low, int high) {//???递归何时结束
        if (low < high) {
            //分区操作，将一个数组分成两个分区，返回分区界限索引
            int index = partition(arr, low, high);
            //对左分区进行快排
            quickSort(arr, low, index - 1);
            //对右分区进行快排
            quickSort(arr, index + 1, high);
        }

    }

    //冒泡排序:从高到低
    private static void maopao() {
        int[] origin = new int[10];
        System.out.print("原顺序：");
        for (int i = 0; i < origin.length; i++) {
            origin[i] = (int) (Math.random() * 100 + 1);
            System.out.print(origin[i] + " ; ");
        }

        int temp = 0;
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin.length - 1 - i; j++) {
                if (origin[j] < origin[j + 1]) {
                    temp = origin[j + 1];
                    origin[j + 1] = origin[j];
                    origin[j] = temp;
                }
            }
        }

        System.out.print("\n排序后：");
        for (int i = 0; i < origin.length; i++) {
            System.out.print(origin[i] + " ; ");
        }

    }

    //Q5 找零；10 日元、50 日元、100 日元和500
    private static int returnCharge(int money) {
        int ways = 0;
        //500
        for (int i = 0; i < 1 + money / 500; i++) {
            //100
            for (int j = 0; j < 1 + money / 100; j++) {
                //50
                for (int k = 0; k < 1 + money / 50; k++) {
                    //10
                    for (int l = 0; l < 1 + money / 10; l++) {
                        if (money == i * 500 + j * 100 + k * 50 + 10 * l) {
                            ways++;
                        }
                    }
                }
            }
        }
        return ways;
    }

    //Q4 切木棍 - 递归递归！
    public static int cutBar(int peoplenNum, int bars, int current) {
        int time = 0;
        if (current >= bars) {
            return 0;
        } else if (current < peoplenNum) {
            time = 1 + cutBar(peoplenNum, bars, 2 * current);
        } else {
            time = 1 + cutBar(peoplenNum, bars, current + peoplenNum);
        }
        return time;
    }

    //Q3 翻牌问题
    private void reverseCard() {
        System.out.println(1);
        int temp = 0;
        for (int i = 2; i < 101; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    temp = temp + 1;
                }
            }
            if (temp % 2 == 0) {
                System.out.println(i);
            }
            temp = 0;
        }
    }

    //Q2 数列的四则运算
    private static void customMath() {
        int qianweishu = 0;
        int baiweishu = 0;
        int shiweishu = 0;
        int geweishu = 0;
        int other = 0;
        int target = 0;
        for (int i = 1000; i < 9999; i++) {
            target = Integer.parseInt(new StringBuilder(i + "").reverse().toString());
            qianweishu = i / 1000;
            baiweishu = (i / 100) % 10;
            shiweishu = (i / 10) % 10;
            geweishu = i % 10;
            //if ( i  ==  2345)System.out.println("千 = " + qianweishu+  " ; 百 = "+baiweishu + " 十 = " + shiweishu + " ;个 = " + geweishu);
            //1 * 1*1*1
            if (target == qianweishu * baiweishu * shiweishu * geweishu) {
                System.out.println(i + " ; 1111");
                continue;
            }
            //1*2*1
            if (target == qianweishu * geweishu * (baiweishu * 10 + shiweishu)) {
                System.out.println(i + " ; 121");
                continue;
            }
            //1*1*2
            if (target == qianweishu * baiweishu * (shiweishu * 10 + geweishu)) {
                System.out.println(i + " ; 112");
                continue;
            }
            //2*1*1
            if (target == shiweishu * geweishu * (qianweishu * 10 + baiweishu)) {
                System.out.println(i + " ; 211");
                continue;
            }
            //1*3
            if (target == qianweishu * (baiweishu * 100 + shiweishu * 10 + geweishu)) {
                System.out.println(i + " ; 13");
                continue;
            }
            //3*1
            if (target == (qianweishu * 100 + baiweishu * 10 + shiweishu) * geweishu) {
                System.out.println(i + " ; 31");
                continue;
            }
        }
    }


    //Q1 回文数(产生左右对称的十进制数)
    private static void reverseNum() {

        for (int j = 1; j < 9; j++) {
            StringBuilder stringBuilder = new StringBuilder("");
            int target = 0;
            for (int i = 0; i < 9; i++) {
                stringBuilder.append(j).append(i).append(j);
                target = Integer.valueOf(stringBuilder.toString());

                if (compare28(target)) {
                    System.out.println(target);
                    break;
                }
                stringBuilder.setLength(0);
            }
        }
    }

    //Q1 对比二进制和八进制数
    private static boolean compare28(int target) {
        //二进制
        StringBuilder jinzhi2 = new StringBuilder("");
        int temp2 = 0;
        int shang = 0;
        int tempTarget = target;
        while (true) {
            shang = tempTarget / 2;
            temp2 = tempTarget % 2;
            jinzhi2.append(temp2);
            tempTarget = shang;
            if (shang == 0) {
                break;
            }
        }
        jinzhi2.reverse();

        boolean is2 = true;
        for (int k = 0; k < jinzhi2.length(); k++) {
            if (jinzhi2.charAt(k) != jinzhi2.charAt(jinzhi2.length() - 1 - k)) {
                is2 = false;
                break;
            }
        }

        if (!is2) return false;


        //八进制
        StringBuilder jinzhi8 = new StringBuilder("");
        int temp8 = 0;
        int shang8 = 0;
        int tempTarget8 = target;
        while (true) {
            shang8 = tempTarget8 / 8;
            temp8 = tempTarget8 % 8;
            jinzhi8.append(temp8);
            tempTarget8 = shang8;
            if (shang8 == 0) {
                break;
            }
        }
        jinzhi8.reverse();

        int is8 = 0;
        for (int k = 0; k < jinzhi8.length(); k++) {
            if (jinzhi8.charAt(k) != jinzhi8.charAt(jinzhi8.length() - 1 - k)) {
                is8 = -1;
                break;
            }
            if (k == jinzhi8.length() / 2) {
                is8++;
            }
        }

        //System.out.println(target + " ; 2 - " + jinzhi2 + " ; 8 - " + jinzhi8 + " ; " + is8);
        jinzhi2.setLength(0);
        jinzhi8.setLength(0);

        return (is8 > 0);
    }

    /**
     * 激光器和磁栅的对齐规则
     */
    private void testBuChang() {
        for (int i = 0; i < 200; i++) {
            double doubleOrigin = (double) i * 50 / 16384;
            double doubleNew = (3.0423 * i + 293.70) / 1000;
            System.out.println("doubleOrigin = " + doubleOrigin + " ;" + " " + " doubleNew  = " + doubleNew + " " + " ;差值 = " + (doubleOrigin - doubleNew));
        }
    }


    @Test
    public void test1() {
        File file = new File("D:/OneDrive/2020.12CET-6_准考证(刘赛赛).pdf");
        long length = file.length();
        String s = formatFileSize("" + length);
        System.out.println(s);
    }

    public String formatFileSize(String fileSize) {
        String[] arr = {"Bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        float srcsize = Float.valueOf(fileSize);
        int index = (int) (Math.floor(Math.log(srcsize) / Math.log(1024)));
        double size = srcsize / Math.pow(1024, index);
        size = Double.valueOf(new DecimalFormat("#.00").format(size));
        return size + arr[index];
    }


}
package com.company.test0302;

import org.junit.Test;

import javax.xml.transform.Source;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author SmileAlfred
 * @create 2021-03-02 17:51
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 排序测试
 */
public class Main {
    class test {

    }

    public static void main(String[] args) {
        /*int i = JumpFloor(4);
        System.out.println(i);

        Main ma = new Main();
        test t = ma.new test();*/


    }

    public static int JumpFloor(int target) {
        int a = 1, b = 1;
        for (int i = 1; i < target; i++) {
            a = a + b;
            b = a - b;
        }

        return a;
    }


    public int[] arr = {5, 8, 7, 3, 1, 6, 9, 4};

    //希尔排序
    @Test
    public void shellOrder() {
        //step:步长
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //对一个步长区间进行比较 [step,arr.length)
            for (int i = step; i < arr.length; i++) {
                int value = arr[i];
                int j;

                //对步长区间中具体的元素进行比较
                for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
                    //j为左区间的取值，j+step为右区间与左区间的对应值。
                    arr[j + step] = arr[j];
                }
                //此时step为一个负数，[j + step]为左区间上的初始交换值
                arr[j + step] = value;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序
    @Test
    public void bubbleSort() {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void quickSort() {
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int left, int right) {


        if (left > right) {
            return;
        }

        //pivot  就是基准位；temp 是临时变量，用来交换；l,r用来查找不满足排序的索引
        int l = left, r = right, pivot = arr[left], temp;

        while (l < r) {
            //先看右边，依次往左递减
            while (pivot <= arr[r] && l < r) {
                r--;
            }
            //再看左边，依次往右递增
            while (pivot >= arr[l] && l < r) {
                l++;
            }
            //如果满足条件则交换
            if (l < r) {
                temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }

        //最后将基准为与 i 和 j 相等位置的数字交换; 注意；每次找完左右的数据后，都要将 pivot 放在中间位置，i 的位置
        arr[left] = arr[l];
        arr[l] = pivot;

        //递归调用左半数组
        quickSort(arr, left, r - 1);
        //递归调用右半数组
        quickSort(arr, r + 1, right);
    }

    @Test
    public void test() {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{1, 3, 2, 4};

        //1.boolean equals(int[] a,int[] b):判断两个数组是否相等。
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);

        //2.String toString(int[] a):输出数组信息。
        System.out.println(Arrays.toString(arr1));


        //3.void fill(int[] a,int val):将指定值填充到数组之中。
        Arrays.fill(arr1, 10);
        System.out.println("fill 方法：" + Arrays.toString(arr1));


        //4.void sort(int[] a):对数组进行排序。
        Arrays.sort(arr2);
        System.out.println("sort 方法：" + Arrays.toString(arr2));

        //5.int binarySearch(int[] a,int key)
        int[] arr3 = new int[]{-98, -34, 2, 34, 54, 66, 79, 105, 210, 333};
        int index = Arrays.binarySearch(arr3, 210);
        if (index >= 0) {
            System.out.println(index);
        } else {
            System.out.println("未找到");
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{2, 3, 1, 5, 7};
        int[] arr2 = arr;
        System.out.println("修改前：" + Arrays.toString(arr) + " ; " + Arrays.toString(arr2));
        arr2[0] = 10;
        System.out.println("修改后：" + Arrays.toString(arr) + " ; " + Arrays.toString(arr2));
    }


    @Test
    public void test3() {
        Data data = new Data();
        data.m = 10;
        data.n = 20;
        System.out.println(data);
        swap(data);
        System.out.println(data);


        int m = 10;
        int n = 20;
        System.out.println("m = " + m + " ; n = " + n); // 10 20
        swap(m, n);
        System.out.println("m = " + m + " ; n = " + n); // 10 20
    }

    private void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
        System.out.println("方法中 m = " + m + " ; n = " + n); //20 10
    }

    private void swap(Data data) {
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }

    @Test
    public void test4() {
        NewData no = new NewData(20);
        System.out.println("============");
        NewData n1o = new NewData();
        System.out.println("============");
        NewData n2o = new NewData(20, 10, 30);
    }

    class NewData extends Data {
        int newM;

        public NewData() {
            System.out.println("NewData  空参 构造器");
        }

        public NewData(int newM) {
            this.newM = newM;
            System.out.println("NewData  构造器 newM");
        }

        public NewData(int m, int n, int newM) {
            super(m, n);
            this.newM = newM;
            System.out.println("NewData  构造器 newM m n ");
        }
    }

    class Data {
        int m;
        int n;

        public Data() {
            System.out.println("Data  空参 构造器");
        }

        public Data(int m, int n) {
            this.m = m;
            this.n = n;
            System.out.println("Data 构造器 m n ");
        }

        @Override
        public String toString() {
            return "Data{" +
                    "m=" + m +
                    ", n=" + n +
                    '}';
        }
    }

    @Test
    public void test5() {
        System.out.println(1 == 0.2f);
    }


    @Test
    public void test6() {
        new Leaf();
        System.out.println();
        new Leaf();
    }

    static class Root {
        static {
            System.out.println("Root的静态初始化块");
        }

        {
            System.out.println("Root的普通初始化块");
        }

        public Root() {
            super();
            System.out.println("Root的无参数的构造器");
        }
    }

    static class Mid extends Root {
        static {
            System.out.println("Mid的静态初始化块");
        }

        {
            System.out.println("Mid的普通初始化块");
        }

        public Mid() {
            super();
            System.out.println("Mid的无参数的构造器");
        }

        public Mid(String msg) {
            //通过this调用同一类中重载的构造器
            this();
            System.out.println("Mid的带参数构造器，其参数值："
                    + msg);
        }
    }

    static class Leaf extends Mid {
        static {
            System.out.println("Leaf的静态初始化块");
        }

        {
            System.out.println("Leaf的普通初始化块");
        }

        public Leaf() {
            //通过super调用父类中有一个字符串参数的构造器
            super("尚硅谷");
            System.out.println("Leaf的构造器");
        }
    }


    interface interface1 {
        void in11();

        void in12();
    }

    interface interface2 {
        void in21();

        void in22();
    }

    //接口可以实现 多 继承性
    interface in3 extends interface1, interface2 {
        void in21();

        void in22();
    }
    //报错：class 的 单继承性
    //class in4 extends Root ,Main{
    //
    //}

    @Test
    public void test7() {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread() {
            @Override
            public void run() {

                synchronized (s1) {

                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {

                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }


    @Test
    public void test8() {
        //1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
        //System.out.println(service.getClass());
        //service1.setCorePoolSize(15);
        //service1.setKeepAliveTime();


        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合适用于Runnable
        service.execute(new NumberThread1());//适合适用于Runnable

        //service.submit(Callable callable);//适合使用于Callable
        //3.关闭连接池
        service.shutdown();
    }

    class NumberThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }
    }

    class NumberThread1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }
    }


    @Test
    public void test10() {
        String s1 = "javaEEhadoop";
        final String s4 = "javaEE";//s4:常量
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);//true

        String s7 = "javaEE";//s4:常量
        String s8 = s7 + "hadoop";
        System.out.println(s1 == s8);//false
    }

    @Test
    public void test11() {
        String str1 = "123";
//        int num = (int)str1;//错误的
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);//"123"
        String str3 = num + "";

        System.out.println(str2 == str3);
    }

    @Test
    public void test12() throws UnsupportedEncodingException {
        String str = "I love 中国！";
        byte[] bytes = str.getBytes();
        String res = new String(bytes);
        String resGbk = new String(bytes, "GBK");
        System.out.println(res + " ; " + resGbk);

        StringBuilder stringBuilder;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1");

    }

    @Test
    public void test13() throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        stringBuilder.append("a");
                    }
                }
            }).start();
        }

        Thread.sleep(100);
        System.out.println(stringBuilder.length());

    }

    @Test
    public void test14() {
        //方式一：创建其子类（GregorianCalendar的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }

    @Test
    public void test15() {
        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.get(0));


        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println();
        System.out.print(arr2.get(0));
        System.out.print(" ; ");
        System.out.print(arr2.get(1));


    }

    @Test
    public void test16() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);     //class com.company.test0302.Person

        //方式二：通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);     //class com.company.test0302.Person

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.company.test0302.Person");//全类名
        //clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);     //class com.company.test0302.Main

        System.out.println(clazz1 == clazz2);//
        System.out.println(clazz1 == clazz3);//

        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = Main.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.company.test0302.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz4);
    }

}
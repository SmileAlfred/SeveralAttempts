package com.company.nowcode;

import org.junit.Test;

/**
 * @author SmileAlfred
 * @create 2021-03-11 21:37
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description
 */
public class SomeTest {

    class A {
        public A(String str) {
        }
    }

    @Test
    public void Test1() {
        A classa = new A("he");
        A classb = new A("he");
        System.out.println(classa == classb);       //false;在 堆 中，不是同一个地址
        System.out.println(classa.equals(classb));  //false;没有重写 equals 方法；

        A varName = new A("Test");
        System.out.println(varName);
    }


}

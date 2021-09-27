package com.company;

/**
 * @author SmileAlfred
 * @create 2021-04-08 13:50
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description
 */
public class SingleInstance {
    //线程安全的 懒汉式 单例模式
    private volatile static SingleInstance instance;

    public SingleInstance() {
    }

    public static SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }
}

package com.company;

import java.io.File;
import java.util.Scanner;

/**
 * @author SmileAlfred
 * @create 2021-02-19 11:59
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 通过界面批量实现 对 文件的重命名
 */
public class MReName {
    public static String path;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入【待批量重命名的】文件目录：");
        path = scanner.next();
        File file = new File(path);        //获取其file对象
        String args1 = "", args2 = "";

        while (true) {
            System.out.println("\n1.批量删除");
            System.out.println("2.删除指定区间文字（包含首尾）");
            System.out.println("3.删除指定字节前的文字（并删除该字节）");
            System.out.println("4.在指定位置处插入内容");
            System.out.println("5.结束重命名\n");
            String input = scanner.next();

            if ("5".equals(input)) {
                System.out.println("完成重命名！");
                break;
            }
            switch (input) {
                case "1":
                    System.out.println("输入批量删除的文字");
                    args1 = scanner.next();
                    break;
                case "2":
                    System.out.println("输入左侧区间的文字");
                    args1 = scanner.next();
                    System.out.println("输入右侧区间的文字");
                    args2 = scanner.next();
                    break;
                case "3":
                    System.out.println("输入指定的文字");
                    args1 = scanner.next();

                    break;
                case "4":
                    System.out.println("输入插入的位置【原先此处文字后移，从1开始】");
                    args1 = scanner.next();
                    System.out.println("输入插入的文字");
                    args2 = scanner.next();

                    break;
                default:
                    break;
            }
            try {
                func(file, input, args1, args2);
            } catch (Exception e) {
                System.out.println("瞎基尔搞！" + e.getMessage());
            }
        }
    }

    /**
     * @param file  遍历的文件目录
     * @param order 操作命令
     * @param args1 第一个参数
     * @param args2 第二个参数
     */
    private static void func(File file, String order, String args1, String args2) throws Exception {
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                func(f, order, args1, args2);
            if (f.isFile()) {        //若是文件，直接打印
                String newFileName = f.getAbsolutePath().replace("\\", "/");
                String[] paths = newFileName.split("/");

                //System.out.println(newFileName +"\n新名字：" + path + "/" + reName(paths[paths.length - 1], order, args1, args2));//F:/1118/3pad/50/2020-11-18/2020-11-18_112630.txt

                file = new File(newFileName); //指定文件名及路径
                file.renameTo(new File(path + "/" + reName(paths[paths.length - 1], order, args1, args2)));
            }
        }
    }

    /**
     * @param oldName 文件名
     * @param order   重命名操作
     * @param args1   第一个参数
     * @param args2   第二个参数
     * @return 返回新的文件名
     */
    public static String reName(String oldName, String order, String args1, String args2) throws Exception {
        String temp;
        switch (order) {
            //1.批量删除");
            case "1":
                oldName = oldName.replace(args1, "");
                break;
            //2.删除指定区间文字（包含首尾）"
            case "2":
                temp = oldName.substring(oldName.indexOf(args1), oldName.indexOf(args2) + 1);
                oldName = oldName.replace(temp, "");
                break;
            //3.删除指定字节前的文字（并删除该字节）"
            case "3":
                oldName = oldName.substring(oldName.indexOf(args1) + 1, oldName.length());
                break;
            //4.在指定位置处插入内容"
            case "4":
                int index = Integer.parseInt(args1);
                if (index == 1) {
                    oldName = args2 + oldName;
                } else {
                    temp = oldName.substring(0, index - 1);
                    oldName = oldName.replace(temp, temp + args2);
                }
                break;
            default:
                break;
        }
        return oldName;
    }

}

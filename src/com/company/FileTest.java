package com.company;

import org.junit.Test;
import sun.awt.shell.Win32ShellFolderManager2;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileTest {
    public static String path = "G:/2.JavaWeb/尚硅谷2020最新版JavaWeb全套教程,java web零基础入门完整版";//要遍历的路径

    public static String[] names;

    public static void main(String[] args) {
        names = name.split("\n");

        File file = new File(path);        //获取其file对象
        func(file);

        //reverseContent();
        //scaleData("C:/Users/我是刘优秀/Desktop/踏面/1.txt");
        //getData("C:/Users/我是刘优秀/Desktop/2020-10-05_202920.txt");

        // get60Standard();
        //String oldName = "2.[尚硅谷]_宋红康_2-Oracle数据库管理(Av21400096,P2).mp4";

        //replaceData(fileName);

        //File file = new File("C:/Users/我是刘优秀/Desktop/test");        //获取其file对象
        //func(file);

        /*String allClassMates = "是非:\n" +
                "无\n" +
                "\n" +
                "BJ.李丹阳:\n" +
                "无\n" +
                "\n" +
                "BJ.孙雨:\n" +
                "无\n" +
                "\n" +
                "BJ.蒋丛稷:\n" +
                "无\n" +
                "\n" +
                "BJ.孟璐:\n" +
                "无\n" +
                "\n" +
                "BJ.刘傲:\n" +
                "无\n" +
                "\n" +
                "BJ.刘素云:\n" +
                "无\n" +
                "\n" +
                "BJ.李家森:\n" +
                "无\n" +
                "\n" +
                "BJ.高文静:\n" +
                "无\n" +
                "\n" +
                "BJ.李昕宸:\n" +
                "无\n" +
                "\n" +
                "BJ.范天庆:\n" +
                "无\n" +
                "\n" +
                "BJ.韩杰茹:\n" +
                "无\n" +
                "\n" +
                "BJ.陈小婷:\n" +
                "无\n" +
                "\n" +
                "BJ.孙红彬:\n" +
                "无\n" +
                "\n" +
                "BJ.刘科言:\n" +
                "无\n" +
                "\n" +
                "BJ.陈日坤:\n" +
                "无\n" +
                "\n" +
                "BJ.蔡昊天:\n" +
                "无\n" +
                "\n" +
                "BJ.卢怡如:\n" +
                "无\n" +
                "\n" +
                "BJ.白田欣雨:\n" +
                "无\n" +
                "\n" +
                "BJ.李万军:\n" +
                "无\n" +
                "BJ.刘博伟:\n" +
                "无\n" +
                "\n" +
                "BJ.隋志远:\n" +
                "无\n"+
                "BJ.黄根:\n" +
                "无\n" +
                "\n" +
                "BJ.蔡卓恒:\n" +
                "无\n"+
                "BJ.谭博仁:\n" +
                "无\n";*/

        //catchIt(allClassMates);
    }

    private static ArrayList<String> catchIt(String having) {
        String[] classMates = new String[]{"白田欣雨", "蔡昊天", "蔡卓恒", "陈日坤", "陈小婷", "范天庆", "高文静",
                "高逸轩", "韩杰茹", "郝迥超", "黄根", "蒋丛稷", "李丹阳", "李家森", "刘傲", "刘博伟", "刘科言",
                "刘素云", "李万军", "李文莉", "李昕宸", "卢怡如", "孟璐", "隋志远", "孙红彬", "孙雨", "谭博仁"};

        ArrayList<String> havingName = new ArrayList<>();
        String[] havingContaints = having.split("\n");
        for (int i = 0; i < havingContaints.length; i++) {
            if (!havingContaints[i].isEmpty() && havingContaints[i].contains("BJ.")) {
                havingName.add(havingContaints[i].replaceAll("BJ.", "").replace(":", ""));
            }
        }
        int count = 0;
        for (int i = 0; i < classMates.length; i++) {
            if (!havingName.contains(classMates[i])) {
                System.out.println(++count + " : " + classMates[i]);
            }
        }

        return havingName;
    }

    /**
     * 获取指定 txt 的内容；把其中 每句话中间添加的回车取消掉
     */
    public static void replaceData(String fileName) {
        InputStreamReader isr;
        StringBuffer sb = new StringBuffer("");
        try {
            isr = new InputStreamReader(new FileInputStream(fileName), "utf-8");
            BufferedReader read = new BufferedReader(isr);
            String s = null;
            List<String> list = new ArrayList<String>();
            while ((s = read.readLine()) != null) {
                sb.append(s + "\n");
            }
        } catch (UnsupportedEncodingException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        String str = sb.toString().replaceAll("\n\n", "===").replaceAll("\n", "").replaceAll("===", "\r\n\r\n");

        try {
            File file = new File(fileName);
            BufferedWriter newFileWriter = new BufferedWriter(new FileWriter(file, false));

            newFileWriter.write(str.toCharArray());

            newFileWriter.flush();
            newFileWriter.close();
            System.out.println("\n" + file.getName() + " 修改完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 重命名尚硅谷视频课的 文件名
     *
     * @param oldName "2.[尚硅谷]_宋红康_2-Oracle数据库管理(Av21400096,P2).mp4";
     * @return
     */
    public static String reName(String oldName) {
        //if(oldName.length()<10)return oldName;
        System.out.println("reName 前 = " + oldName + " ; length = " + oldName.length());
        //String[] arr = oldName.split("\\.");
        //oldName ="第"+arr[0]+"集." + arr[1];

        String regex = oldName.substring(oldName.indexOf('('), oldName.lastIndexOf(')') + 1);
        System.out.println("regex = " + regex);
        oldName = oldName.replace(regex, "").replace("蔡礼旭老师细讲《弟子规》幸福人生讲座40集 -", "");

        oldName = oldName.substring(oldName.indexOf('.') + 1, oldName.length());
        //String[] temps = oldName.split("\\.");
        //oldName = "第"+ temps[1]+"集." + temps[2];
        System.out.println("reName 后 = " + oldName);
        return oldName;

        /*char[] chars = oldName.toCharArray();
        StringBuffer sb = new StringBuffer();
        boolean noRead = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') noRead = true;
            if (chars[i] == ')') noRead = false;
            if (noRead) continue;
            sb.append(chars[i]);
        }
        return sb.toString().replace(")", "");*/
    }

    /**
     * 根据 60.txt 修改格式   X\tY\n
     */
    private static void get60Standard() {
        String path = "C:/Users/我是刘优秀/Desktop/jm.txt";
        File file = new File(path);
        try {
            BufferedReader reader = null;
            String tempString = null;
            int line = 1;
            StringBuffer sb = new StringBuffer();//存放正确的结果
            reader = new BufferedReader(new FileReader(file));
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
                line++;
            }

            String[] points = sb.toString().split(" ");

            StringBuffer newSb = new StringBuffer();//存放正确的结果
            double x = 0.0;
            for (int i = points.length - 1; i >= 0; i -= 2) {
                //修改轮对文件
                newSb.append(x + "\t");
                newSb.append(Double.parseDouble(points[i]) + 30 + "\r\n");
                x += 0.1;

                //修改钢轨文件
                //newSb.append(points[i]+"\t");
                //newSb.append(points[i+1]+"\r\n");
            }
            reader.close();
            System.out.println(newSb.toString());

            /*BufferedWriter newFileWriter = new BufferedWriter(new FileWriter(file, false));
            newFileWriter.write(newSb.toString());
            newFileWriter.flush();
            newFileWriter.close();
            System.out.println(file.getName() + " 修改完成！");*/
        } catch (Exception e) {
            System.out.println("报错：" + e.getMessage());
        }
    }

    private static void scaleData(String biggerFileName) {
        File file = new File(biggerFileName);
        try {
            BufferedReader reader = null;
            String tempString = null;
            int line = 1;
            StringBuffer sb = new StringBuffer();
            reader = new BufferedReader(new FileReader(file));
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString + "\r\n");
                line++;
            }
            String[] XYPoints = sb.toString().split("\r\n");
            String[] XPoints = new String[XYPoints.length];
            String[] YPoints = new String[XYPoints.length];

            double[] deErTaX = new double[XYPoints.length - 1];
            double[] deErTaY = new double[XYPoints.length - 1];

            for (int i = 0; i < XYPoints.length; i++) {
                String[] XYTemp = XYPoints[i].split("   ");
                XPoints[i] = XYTemp[0];
                YPoints[i] = XYTemp[1];

                if (i > 0) {
                    deErTaX[i - 1] = Double.parseDouble(XPoints[i]) - Double.parseDouble(XPoints[i - 1]);
                    deErTaY[i - 1] = Double.parseDouble(YPoints[i]) - Double.parseDouble(YPoints[i - 1]);
                }
            }

            /**
             * chaX chaY 数据中最大最小值之差
             */
            double chaX = Double.parseDouble(XPoints[XPoints.length - 1]) - Double.parseDouble(XPoints[0]);
            double maxY = 0.0;
            for (int i = 0; i < YPoints.length; i++) {
                maxY = maxY > Double.parseDouble(YPoints[i]) ? maxY : Double.parseDouble(YPoints[i]);
            }
            double chaY = maxY - Double.parseDouble(YPoints[YPoints.length - 1]);

            System.out.println("maxY = " + maxY + " ; chaY = " + chaY);

            double scaleX = 140.00 / chaX;
            double scaleY = (60.00 - 20.781) / chaY;

            double[] newX = new double[XPoints.length];
            double[] newY = new double[YPoints.length];
            newX[0] = Double.parseDouble(XPoints[0]);
            newY[0] = Double.parseDouble(YPoints[0]);
            for (int i = 1; i < newX.length; i++) {
                newX[i] = deErTaX[i - 1] * scaleX + newX[i - 1];
                newY[i] = deErTaY[i - 1] * scaleY + newY[i - 1];
            }
            double originX = newX[0], originY = newY[0];
            for (int i = 0; i < newX.length; i++) {
                newX[i] += (0 - originX);
                newY[i] += (36.868 - originY);
            }

            StringBuffer newSb = new StringBuffer();//存放正确的结果
            for (int i = 0; i < newY.length; i++) {
                newSb.append(newX[i] + "\t");
                newSb.append(newY[i] + "\r\n");
            }
            System.out.println(newSb.toString());
            /*BufferedWriter newFileWriter = new BufferedWriter(new FileWriter(file, false));
            newFileWriter.write(newSb.toString());
            newFileWriter.flush();
            newFileWriter.close();
            System.out.println(file.getName() + " 修改完成！");
            reader.close();*/
        } catch (Exception e) {
            System.out.println("scaleData 报错：" + e.getMessage());
        }

    }

    private static void reverseContent() {
        String path = "C:/Users/我是刘优秀/Desktop/reverse.txt";
        File file = new File(path);
        try {
            BufferedReader reader = null;
            String tempString = null;
            int line = 1;
            List<String> points = new ArrayList<>();
            reader = new BufferedReader(new FileReader(file));
            while ((tempString = reader.readLine()) != null) {
                points.add(tempString);
                line++;
            }

            StringBuffer newSb = new StringBuffer();//存放正确的结果
            for (int i = 0; i < points.size(); i++) {
                newSb.append(points.get(points.size() - 1 - i) + "\r\n");
            }
            reader.close();

            BufferedWriter newFileWriter = new BufferedWriter(new FileWriter(file, false));
            newFileWriter.write(newSb.toString());
            newFileWriter.flush();
            newFileWriter.close();
            System.out.println(file.getName() + " 修改完成！");
        } catch (Exception e) {
            System.out.println("报错：" + e.getMessage());
        }
    }

    public static int index = 0;

    private static void func(File file) {
        List<String> fileNameList = new ArrayList<>();
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                func(f);
            if (f.isFile()) {        //若是文件，直接打印
                String newFileName = f.getAbsolutePath().replace("\\", "/");
                String[] paths = newFileName.split("/");

                //getWearTab(newFileName);
                System.out.println("原名字\t" + paths[paths.length - 1]);
                for (int i = 0; i < names.length; i++) {
                    String oldName = paths[paths.length - 1].replaceAll(".mp4","");
                    String temp = names[i].substring(8);
                    if (temp.contains(oldName)) {
                        file = new File(newFileName);
                        file.renameTo(new File(path + "/" + names[i] + ".mp4"));
                        System.out.println("修改成了\t" + names[i] + ".mp4");
                        break;
                    }
                }

                //System.out.println(newFileName + " ； 新名字：" + path + "/" + reName(paths[paths.length - 1]));//F:/1118/3pad/50/2020-11-18/2020-11-18_112630.txt

                //file = new File(newFileName); //指定文件名及路径
                //file.renameTo(new File(path + "/" + reName(paths[paths.length - 1])));
                //index++;

                //fileNameList.add(newFileName);
            }
        }
       /* for (int i = 0; i < fileNameList.size(); i++) {
            getData(fileNameList.get(i));
        }*/
    }

    /**
     * 根据参数 从本地文件中获取该次测量的 各点坐标以及X距离；
     */
    private static String fileName = "C:/Users/我是刘优秀/Desktop/test.txt";


    /**
     * 根据测量结果获得其磨耗参数的表格
     *
     * @param fileName
     */
    public static void getWearTab(String fileName) {
        File wearTab = new File("C:/Users/我是刘优秀/Desktop/wearTab.txt");
        File file = new File(fileName);
        try {
            BufferedReader reader = null;
            String tempString = null;
            int line = 1;
            StringBuffer sb = new StringBuffer();
            reader = new BufferedReader(new FileReader(file));
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString + " ");
                line++;
            }
            String[] Strs = sb.toString().split(" ");

            StringBuffer newSb = new StringBuffer();//存放正确的结果
            //newSb.append("WheelTreadMeasurement" + "\r\n");
            newSb.append(Strs[5] + "\t");
            newSb.append(Strs[6] + "\t");
            newSb.append(Strs[9] + "\t");
            newSb.append(Strs[10] + "\t");
            newSb.append(Strs[11] + "\t");
            newSb.append(Strs[12] + "\r\n");

            reader.close();

            BufferedWriter newFileWriter = new BufferedWriter(new FileWriter(wearTab, true));
            newFileWriter.write(newSb.toString());
            newFileWriter.flush();
            newFileWriter.close();
        } catch (Exception e) {
            System.out.println("报错：" + e.getMessage());
        }
    }


    public static void getData(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = null;
            String tempString = null;
            int line = 1;
            StringBuffer sb = new StringBuffer();
            reader = new BufferedReader(new FileReader(file));
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
                line++;
            }
            String[] Strs = sb.toString().split(" ");

            StringBuffer newSb = new StringBuffer();//存放正确的结果
            newSb.append("RailMeasurement" + "\r\n");
            //newSb.append("WheelTreadMeasurement" + "\r\n");
            for (int i = 0; i < Strs.length; i++) {
                if (i <= 11) {
                    if (i == 4) newSb.append("60" + "\r\n");
                    newSb.append(Strs[i] + "\r\n");
                }
                if (i > 11 && i % 2 == 0) newSb.append(Strs[i] + "\t");
                if (i > 11 && i % 2 != 0) newSb.append(Strs[i] + "\r\n");
            }
            reader.close();

            BufferedWriter newFileWriter = new BufferedWriter(new FileWriter(file, false));
            newFileWriter.write(newSb.toString());
            newFileWriter.flush();
            newFileWriter.close();
            System.out.println(file.getName() + " 修改完成！");
        } catch (Exception e) {
            System.out.println("报错：" + e.getMessage());
        }
    }


    @Test
    public void test3() {

        String res = ":\"404.尚硅谷_IDEA的使用与多线程-IDEA的使用与多线程的概述\",\"duration\":600,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457125,\"page\":407,\"from\":\"vupload\",\"part\":\"405.尚硅谷_IDEA的使用与多线程-IDEA的卸载\",\"duration\":530,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457270,\"page\":408,\"from\":\"vupload\",\"part\":\"406.尚硅谷_IDEA的使用与多线程-IDEA的介绍\",\"duration\":864,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457287,\"page\":409,\"from\":\"vupload\",\"part\":\"407.尚硅谷_IDEA的使用与多线程-IDEA的安装\",\"duration\":567,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457114,\"page\":410,\"from\":\"vupload\",\"part\":\"408.尚硅谷_IDEA的使用与多线程-启动IDEA并完成HelloWorld\",\"duration\":545,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103456909,\"page\":411,\"from\":\"vupload\",\"part\":\"409.尚硅谷_IDEA的使用与多线程-Module的理解和创建\",\"duration\":457,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457556,\"page\":412,\"from\":\"vupload\",\"part\":\"410.尚硅谷_IDEA的使用与多线程-IDEA的常用设置\",\"duration\":1095,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457242,\"page\":413,\"from\":\"vupload\",\"part\":\"411.尚硅谷_IDEA的使用与多线程-快捷键的设置\",\"duration\":443,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457268,\"page\":414,\"from\":\"vupload\",\"part\":\"412.尚硅谷_IDEA的使用与多线程-模板的使用和设置\",\"duration\":550,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457686,\"page\":415,\"from\":\"vupload\",\"part\":\"413.尚硅谷_IDEA的使用与多线程-章节概述_程序进程线程的概念\",\"duration\":1215,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457395,\"page\":416,\"from\":\"vupload\",\"part\":\"414.尚硅谷_IDEA的使用与多线程-单核与多核CPU的任务执行_并行与并发\",\"duration\":554,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457358,\"page\":417,\"from\":\"vupload\",\"part\":\"415.尚硅谷_IDEA的使用与多线程-多线程的优点等\",\"duration\":558,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457419,\"page\":418,\"from\":\"vupload\",\"part\":\"416.尚硅谷_IDEA的使用与多线程-创建多线程方式一：继承Thread类\",\"duration\":1002,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457467,\"page\":419,\"from\":\"vupload\",\"part\":\"417.尚硅谷_IDEA的使用与多线程-创建过程中两个问题的说明\",\"duration\":679,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457521,\"page\":420,\"from\":\"vupload\",\"part\":\"418.尚硅谷_IDEA的使用与多线程-继承方式的课后练习\",\"duration\":597,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457955,\"page\":421,\"from\":\"vupload\",\"part\":\"419.尚硅谷_IDEA的使用与多线程-线程的常用方法\",\"duration\":1964,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457560,\"page\":422,\"from\":\"vupload\",\"part\":\"420.尚硅谷_IDEA的使用与多线程-线程优先级的设置\",\"duration\":732,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457787,\"page\":423,\"from\":\"vupload\",\"part\":\"421.尚硅谷_IDEA的使用与多线程-例题：继承Thread方式，多窗口卖票\",\"duration\":1028,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457689,\"page\":424,\"from\":\"vupload\",\"part\":\"422.尚硅谷_IDEA的使用与多线程-创建多线程的方式二：实现Runnable接口\",\"duration\":851,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457626,\"page\":425,\"from\":\"vupload\",\"part\":\"423.尚硅谷_IDEA的使用与多线程-例题：实现Runnable方式，多窗口卖票\",\"duration\":320,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103457726,\"page\":426,\"from\":\"vupload\",\"part\":\"424.尚硅谷_IDEA的使用与多线程-两种创建方式的对比\",\"duration\":522,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467024,\"page\":427,\"from\":\"vupload\",\"part\":\"425.尚硅谷_多线程-每天一考\",\"duration\":770,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467282,\"page\":428,\"from\":\"vupload\",\"part\":\"426.尚硅谷_多线程-复习：IDEA使用与多线程基本概念\",\"duration\":944,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467121,\"page\":429,\"from\":\"vupload\",\"part\":\"427.尚硅谷_多线程-复习：线程的创建与常用方法\",\"duration\":589,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467112,\"page\":430,\"from\":\"vupload\",\"part\":\"428.尚硅谷_多线程-线程的生命周期\",\"duration\":1333,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103466928,\"page\":431,\"from\":\"vupload\",\"part\":\"429.尚硅谷_多线程-理解线程的安全问题\",\"duration\":357,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467138,\"page\":432,\"from\":\"vupload\",\"part\":\"430.尚硅谷_多线程-线程安全问题的举例和解决措施\",\"duration\":1242,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467214,\"page\":433,\"from\":\"vupload\",\"part\":\"431.尚硅谷_多线程-同步代码块处理实现Runnable的线程安全问题\",\"duration\":1031,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467364,\"page\":434,\"from\":\"vupload\",\"part\":\"432.尚硅谷_多线程-同步代码块处理继承Thread类的线程安全问题\",\"duration\":1394,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467226,\"page\":435,\"from\":\"vupload\",\"part\":\"433.尚硅谷_多线程-同步方法处理实现Runnable的线程安全问题\",\"duration\":434,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467281,\"page\":436,\"from\":\"vupload\",\"part\":\"434.尚硅谷_多线程-同步方法处理继承Thread类的线程安全问题\",\"duration\":500,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467489,\"page\":437,\"from\":\"vupload\",\"part\":\"435.尚硅谷_多线程-线程安全的单例模式之懒汉式\",\"duration\":1001,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467433,\"page\":438,\"from\":\"vupload\",\"part\":\"436.尚硅谷_多线程-死锁的问题\",\"duration\":1200,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467406,\"page\":439,\"from\":\"vupload\",\"part\":\"437.尚硅谷_多线程-Lock锁方式解决线程安全问题\",\"duration\":936,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467464,\"page\":440,\"from\":\"vupload\",\"part\":\"438.尚硅谷_多线程-同步机制的课后练习\",\"duration\":911,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467633,\"page\":441,\"from\":\"vupload\",\"part\":\"439.尚硅谷_多线程-线程通信的例题\",\"duration\":1208,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467486,\"page\":442,\"from\":\"vupload\",\"part\":\"440.尚硅谷_多线程-sleep()和wait()的异同\",\"duration\":317,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467902,\"page\":443,\"from\":\"vupload\",\"part\":\"441.尚硅谷_多线程-线程通信：生产者消费者例题\",\"duration\":1439,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467736,\"page\":444,\"from\":\"vupload\",\"part\":\"442.尚硅谷_多线程-创建多线程的方式三：实现Callable接口\",\"duration\":1246,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467625,\"page\":445,\"from\":\"vupload\",\"part\":\"443.尚硅谷_多线程-使用线程池的好处\",\"duration\":653,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467640,\"page\":446,\"from\":\"vupload\",\"part\":\"444.尚硅谷_多线程-创建多线程的方式四：使用线程池\",\"duration\":831,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467794,\"page\":447,\"from\":\"vupload\",\"part\":\"445.尚硅谷_常用类-每天一考\",\"duration\":1339,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103468043,\"page\":448,\"from\":\"vupload\",\"part\":\"446.尚硅谷_常用类-复习：生命周期与同步机制\",\"duration\":1265,\"vid\":\"\",\"weblink\":\"\",\"dimension\":{\"width\":1366,\"height\":768,\"rotate\":0}},{\"cid\":103467898,\"page\":449,\"from\":\"vupload\",\"part\":\"447.尚硅谷_常用类-复习：线程通信和新的线程创建方式等\",";
        String[] ress = res.split(",");

        for (int i = 0; i < ress.length; i++) {
            if (ress[i].contains("尚硅谷_")) System.out.println(ress[i]
                    .replaceAll(":", "")
                    .replaceAll("part", "")
                    .replaceAll("\"", "")
                    .replaceAll("尚硅谷_", ""));
        }
    }

    /**
     * 隔一行删一行
     */
    @Test
    public void test4() {
        InputStreamReader isr;
        StringBuffer sb = new StringBuffer("");
        try {
            isr = new InputStreamReader(new FileInputStream("C:/Users/我是刘优秀/Desktop/Smiall_rail60.txt"), "utf-8");
            BufferedReader read = new BufferedReader(isr);
            String s = null;
            List<String> list = new ArrayList<String>();
            int index = 0;
            while ((s = read.readLine()) != null) {
                if (index++ % 2 == 0) sb.append(s + "\n");
            }
        } catch (Exception e) {
        }
        System.out.println(sb.toString());
    }

    public static String name = "001-尚硅谷-HTML和CSS-引课\n" +
            "002.尚硅谷_HTML和CSS-BS软件的结构\n" +
            "003.尚硅谷_HTML和CSS-前端的开发流程\n" +
            "004.尚硅谷_HTML和CSS-网页的组成部分\n" +
            "005.尚硅谷_HTML和CSS-HTML简介\n" +
            "006.尚硅谷_HTML和CSS-创建HTML页面\n" +
            "007.尚硅谷_HTML和CSS-html的书写规范\n" +
            "008.尚硅谷_HTML和CSS-HTML标签的介绍\n" +
            "009.尚硅谷_HTML和CSS-HTML标签的语法\n" +
            "010.尚硅谷_HTML和CSS-font标签\n" +
            "011.尚硅谷_HTML和CSS-特殊字符\n" +
            "012.尚硅谷_HTML和CSS-标题标签h1 - h6\n" +
            "013.尚硅谷_HTML和CSS-超连接标签\n" +
            "014.尚硅谷_HTML和CSS-无序列表\n" +
            "015.尚硅谷_HTML和CSS-img标签\n" +
            "016.尚硅谷_HTML和CSS-table标签\n" +
            "017.尚硅谷_HTML和CSS-表格的跨行跨列\n" +
            "018.尚硅谷_HTML和CSS-ifarme标签介绍\n" +
            "019.尚硅谷_HTML和CSS-表单显示\n" +
            "020.尚硅谷_HTML和CSS-表单格式化\n" +
            "021.尚硅谷_HTML和CSS-表单提交的细节\n" +
            "022.尚硅谷_HTML和CSS-其他标签div、span、p\n" +
            "023.尚硅谷_HTML和CSS-CSS介绍\n" +
            "024.尚硅谷_HTML和CSS-CSS语法介绍\n" +
            "025.尚硅谷_HTML和CSS-CSS与HTML结合使用的第一种方式\n" +
            "026.尚硅谷_HTML和CSS-CSS与HTML结合使用的第二种方式\n" +
            "027.尚硅谷_HTML和CSS-CSS与HTML结合使用的第三种方式\n" +
            "028.尚硅谷_HTML和CSS-标签名选择器\n" +
            "029.尚硅谷_HTML和CSS-id选择器\n" +
            "030.尚硅谷_HTML和CSS-class类型选择器\n" +
            "031.尚硅谷_HTML和CSS-组合选择器\n" +
            "032.尚硅谷_HTML和CSS-css常用样式\n" +
            "033-尚硅谷-JavaScript-JavaScript介绍\n" +
            "034.尚硅谷_JavaScript-JavaScript与HTML结合使用的第一种方式\n" +
            "035.尚硅谷_JavaScript-JavaScript与HTML结合使用的第二种方式\n" +
            "036.尚硅谷_JavaScript-JavaScript的变量和数据类型介绍\n" +
            "037.尚硅谷_JavaScript-JavaScript的关系运算\n" +
            "038.尚硅谷_JavaScript-JavaScript的逻辑运算\n" +
            "039.尚硅谷_JavaScript-JavaScript的数组\n" +
            "040.尚硅谷_JavaScript-函数的第一种定义方式\n" +
            "041.尚硅谷_JavaScript-函数的第二种定义方式\n" +
            "042.尚硅谷_JavaScript-js中的函数不允许重载\n" +
            "043.尚硅谷_JavaScript-隐形参数arguments\n" +
            "044.尚硅谷_JavaScript-Object形式的自定义对象\n" +
            "045.尚硅谷_JavaScript-花括号形式的自定义对象\n" +
            "046.尚硅谷_JavaScript-事件介绍\n" +
            "047.尚硅谷_JavaScript-两种事件注册的介绍\n" +
            "048.尚硅谷_JavaScript-onload事件\n" +
            "049.尚硅谷_JavaScript-onclick事件\n" +
            "050.尚硅谷_JavaScript-onblur事件\n" +
            "051.尚硅谷_JavaScript-onchange事件\n" +
            "052.尚硅谷_JavaScript-onsubmit事件\n" +
            "053.尚硅谷_JavaScript-document对象概念介绍\n" +
            "054.尚硅谷_JavaScript-验证用户名是否有效\n" +
            "055.尚硅谷_JavaScript-正则表达式对象\n" +
            "056.尚硅谷_JavaScript-两种常见的验证提示效果\n" +
            "057.尚硅谷_JavaScript-getElementsByName方法\n" +
            "058.尚硅谷_JavaScript-getElementsByTagName方法\n" +
            "059.尚硅谷_JavaScript-document对象三个查询方法的使用注意事项\n" +
            "060.尚硅谷_JavaScript-dom对象查询练习\n" +
            "061.尚硅谷_JavaScript-document对象补充说明\n" +
            "062-尚硅谷-jQuery-jQuery介绍\n" +
            "063.尚硅谷_jQuery-jQuery的Hello程序示例\n" +
            "064.尚硅谷_jQuery-jQuery的Hello程序常见问题\n" +
            "065.尚硅谷_jQuery-jQuery的函数核心介绍\n" +
            "066.尚硅谷_jQuery-如何区分DOM对象和jQuery对象\n" +
            "067.尚硅谷_jQuery-jQuery对象的本质\n" +
            "068.尚硅谷_jQuery-jQuery对象和DOM对象使用上的区别\n" +
            "069.尚硅谷_jQuery-jQuery对象和DOM对象的相互转换\n" +
            "070.尚硅谷_jQuery-基础选择器\n" +
            "071.尚硅谷_jQuery-层级选择器\n" +
            "072.尚硅谷_jQuery-基本过滤选择器\n" +
            "073.尚硅谷_jQuery-内容过滤选择器\n" +
            "074.尚硅谷_jQuery-属性过滤选择器\n" +
            "075.尚硅谷_jQuery-表单过滤选择器\n" +
            "076.尚硅谷_jQuery-元素的筛选\n" +
            "077-尚硅谷-jQuery-html()、text()、val()方法\n" +
            "078.尚硅谷_jQuery-attr() 和 prop() 方法\n" +
            "079.尚硅谷_jQuery-练习：全选、全不选、反选\n" +
            "080.尚硅谷_jQuery-dom的增，删，改\n" +
            "081.尚硅谷_jQuery-练习：从左到右，从右到左\n" +
            "082.尚硅谷_jQuery-练习：动态添加和删除行记录\n" +
            "083.尚硅谷_jQuery-css样式操作\n" +
            "084.尚硅谷_jQuery-动画操作\n" +
            "085.尚硅谷_jQuery-练习：品牌展示\n" +
            "086.尚硅谷_jQuery-原生js和jQuery页面加载完成之后的区别\n" +
            "087.尚硅谷_jQuery-jQuery中常用的事件处理方法\n" +
            "088.尚硅谷_jQuery-事件的冒泡\n" +
            "089.尚硅谷_jQuery-事件对象\n" +
            "090.尚硅谷_jQuery-练习：图片跟随\n" +
            "091.尚硅谷_书城项目-第一阶段：表单验证的说明\n" +
            "092.尚硅谷_书城项目-第一阶段：表单验证的实现\n" +
            "093-尚硅谷-xml-什么是XML以及它的作用\n" +
            "094.尚硅谷_xml-第一个xml示例文件\n" +
            "095.尚硅谷_xml-xml语法介绍\n" +
            "096.尚硅谷_xml-xml解析技术介绍\n" +
            "097.尚硅谷_xml-使用dom4j读取xml文件得到Document对象\n" +
            "098.尚硅谷_xml-使用dom4j解析xml\n" +
            "099-尚硅谷-Tomcat-JavaWeb概念\n" +
            "100.尚硅谷_Tomcat-Web资源的分类\n" +
            "101.尚硅谷_Tomcat-常见Web服务器\n" +
            "102.尚硅谷_Tomcat-Tomcat服务器和Servlet版本的对应关系\n" +
            "103.尚硅谷_Tomcat-Tomcat服务器的安装\n" +
            "104.尚硅谷_Tomcat-Tomcat目录的介绍\n" +
            "105.尚硅谷_Tomcat-如何启动Tomcat服务器\n" +
            "106.尚硅谷_Tomcat-常见Tomcat启动失败的原因\n" +
            "107.尚硅谷_Tomcat-JAVA_HOME配置失败的几种常见情况\n" +
            "108.尚硅谷_Tomcat-另一种启动Tomcat服务器的方式catalina run\n" +
            "109.尚硅谷_Tomcat-停止Tomcat服务器的几种方式\n" +
            "110.尚硅谷_Tomcat-修改Tomcat默认端口号\n" +
            "111.尚硅谷_Tomcat-第一种部署web工程的方式\n" +
            "112.尚硅谷_Tomcat-第二种部署web工程的方式\n" +
            "113.尚硅谷_Tomcat-手托html页面和在浏览器中输入地址访问的背后不同原因\n" +
            "114.尚硅谷_Tomcat-默认访问的工程和默认访问的资源\n" +
            "115.尚硅谷_Tomcat-IDEA整合Tomcat服务器\n" +
            "116.尚硅谷_Tomcat-如何创建动态的web工程\n" +
            "117.尚硅谷_Tomcat-动态web工程目录的介绍\n" +
            "118.尚硅谷_Tomcat-给Tomcat添加第三方jar包\n" +
            "119.尚硅谷_Tomcat-如何在IDEA中启动部署web模板\n" +
            "120.尚硅谷_Tomcat-Tomcat实例使用的其他细节说明\n" +
            "121-尚硅谷-Servlet-什么是Servlet\n" +
            "122.尚硅谷_Servlet-第一个Servlet程序\n" +
            "123.尚硅谷_Servlet-Servlet程序常见错误\n" +
            "124.尚硅谷_Servlet-url地址如何定位到Servlet程序去访问\n" +
            "125.尚硅谷_Servlet-Servlet生命周期方法\n" +
            "126.尚硅谷_Servlet-请求的分发处理\n" +
            "127.尚硅谷_Servlet-通过继承HttpServlet类实现Servlet程序\n" +
            "128.尚硅谷_Servlet-IDEA菜单生成Servlet程序\n" +
            "129.尚硅谷_Servlet-整个Servlet类的继承体系\n" +
            "130.尚硅谷_Servlet-ServletConfig类使用介绍\n" +
            "131.尚硅谷_Servlet-ServletConfig类的补充说明\n" +
            "132.尚硅谷_Servlet-ServletContext对象的介绍\n" +
            "133.尚硅谷_Servlet-ServletContext对象作用的演示\n" +
            "134.尚硅谷_Servlet-ServletContext像map一样存取数据\n" +
            "135.尚硅谷_Servlet-什么是HTTP协议\n" +
            "136.尚硅谷_Servlet-GET请求HTTP协议内容介绍\n" +
            "137.尚硅谷_Servlet-POST请求HTTP协议内容介绍\n" +
            "138.尚硅谷_Servlet-常用请求头\n" +
            "139.尚硅谷_Servlet-哪些是GET请求，哪些是POST请求\n" +
            "140.尚硅谷_Servlet-响应的HTTP协议介绍\n" +
            "141.尚硅谷_Servlet-常见的响应状态码说明\n" +
            "142.尚硅谷_Servlet-MIME数据类型\n" +
            "143.尚硅谷_Servlet-谷歌浏览器和火狐浏览器如何查看HTTP协议\n" +
            "144-尚硅谷-Servlet-HttpServletRequest类的介绍\n" +
            "145.尚硅谷_Servlet-Request常用API的演示\n" +
            "146.尚硅谷_Servlet-获取请求的参数值---补充\n" +
            "147.尚硅谷_Servlet-获取请求的参数值\n" +
            "148.尚硅谷_Servlet-解决post请求中文乱码问题\n" +
            "149.尚硅谷_Servlet-请求转发\n" +
            "150.尚硅谷_Servlet-base标签的作用\n" +
            "151.尚硅谷_Servlet-回顾javaweb中的路径\n" +
            "152.尚硅谷_Servlet-斜杠在web中的不同意义\n" +
            "153.尚硅谷_Servlet-HttpServletResponse类的介绍\n" +
            "154.尚硅谷_Servlet-两个响应流的介绍\n" +
            "155.尚硅谷_Servlet-给客户端回传字符串数据\n" +
            "156.尚硅谷_Servlet-解决响应的中文乱码\n" +
            "157.尚硅谷_Servlet-解决响应中文乱码方案二\n" +
            "158.尚硅谷_Servlet-请求重定向\n" +
            "159.尚硅谷_Servlet-请求重定向第二种实现方案\n" +
            "160-尚硅谷-书城项目-第二阶段：用户登录和注册功能的介绍\n" +
            "161-尚硅谷-书城项目-JavaEE三层架构介绍\n" +
            "162.尚硅谷_书城项目-搭建书城项目环境\n" +
            "163.尚硅谷_书城项目-创建数据库和t_user用户表\n" +
            "164.尚硅谷_书城项目-创建数据库表对应的User类\n" +
            "165.尚硅谷_书城项目-JdbcUtils工具类的编写和测试\n" +
            "166.尚硅谷_书城项目-编写BaseDao\n" +
            "167.尚硅谷_书城项目-编写UserDao和测试\n" +
            "168.尚硅谷_书城项目-编写UserService和测试\n" +
            "169.尚硅谷_书城项目-实现用户注册的功能\n" +
            "170.尚硅谷_书城项目-IDEA工具Debug的使用\n" +
            "171.尚硅谷_书城项目-用户登录功能实现\n" +
            "172-尚硅谷-jsp-什么是jsp，以及它有什么作用\n" +
            "173.尚硅谷_jsp-jsp的小结\n" +
            "174.尚硅谷_jsp-jsp页面的本质\n" +
            "175.尚硅谷_jsp-jsp的page指令\n" +
            "176.尚硅谷_jsp-声明脚本\n" +
            "177.尚硅谷_jsp-表达式脚本\n" +
            "178.尚硅谷_jsp-代码脚本\n" +
            "179.尚硅谷_jsp-jsp中的三种注释\n" +
            "180.尚硅谷_jsp-jsp中的九大内置对象\n" +
            "181.尚硅谷_jsp-四个域对象的演示\n" +
            "182.尚硅谷_jsp-out和response输出的区别\n" +
            "183.尚硅谷_jsp-常用标签 之 静态包含\n" +
            "184.尚硅谷_jsp-常用标签 之 动态包含\n" +
            "185.尚硅谷_jsp-常用标签 之 请求转发\n" +
            "186.尚硅谷_jsp-练习一：九九乘法口诀表\n" +
            "187.尚硅谷_jsp-练习二：遍历输出10个学生信息到表格中\n" +
            "188.尚硅谷_jsp-请求转发的使用说明\n" +
            "189.尚硅谷_jsp-什么是Listener监听器\n" +
            "190.尚硅谷_jsp-ServletContextListener监听器演示\n" +
            "191-尚硅谷-EL表达式-什么是EL表达式，以及它的作用\n" +
            "192.尚硅谷_EL表达式-EL表达式搜索四个域的顺序\n" +
            "193.尚硅谷_EL表达式-EL表达式输出复杂的Bean对象\n" +
            "194.尚硅谷_EL表达式-关系运算\n" +
            "195.尚硅谷_EL表达式-逻辑运算\n" +
            "196.尚硅谷_EL表达式-算术运算\n" +
            "197.尚硅谷_EL表达式-empty运算\n" +
            "198.尚硅谷_EL表达式-点运算和中括号运算\n" +
            "199.尚硅谷_EL表达式-11个EL隐含对象的介绍\n" +
            "200.尚硅谷_EL表达式-pageScope、requestScope、sessionScope、applicationScope的示例\n" +
            "201.尚硅谷_EL表达式-pageContext演示\n" +
            "202.尚硅谷_EL表达式-其他EL隐含对象的示例\n" +
            "203.尚硅谷_JSTL标签库-JSTL标签库的介绍\n" +
            "204.尚硅谷_JSTL标签库-标签库的使用步骤\n" +
            "205.尚硅谷_JSTL标签库-set标签\n" +
            "206.尚硅谷_JSTL标签库-if标签\n" +
            "207.尚硅谷_JSTL标签库-choose、when、otherwise标签\n" +
            "208.尚硅谷_JSTL标签库-使用forEach遍历1到10的情况\n" +
            "209.尚硅谷_JSTL标签库-使用forEach遍历Object数组\n" +
            "210.尚硅谷_JSTL标签库-使用forEach遍历Map集合\n" +
            "211.尚硅谷_JSTL标签库-使用forEach遍历List集合\n" +
            "212.尚硅谷_JSTL标签库-forEach标签所有属性组合使用介绍\n" +
            "213-尚硅谷-文件上传-文件上传的介绍\n" +
            "214.尚硅谷_文件上传-上传的http协议内容介绍\n" +
            "215.尚硅谷_文件上传-上传合用到的类和方法的介绍\n" +
            "216.尚硅谷_文件上传-使用fileupload解析上传的数据\n" +
            "217.尚硅谷_文件下载-文件下载的实现\n" +
            "218.尚硅谷_文件下载-使用URLEncoder解决谷歌和IE浏览器中文下载名乱码问题\n" +
            "219.尚硅谷_文件下载-Base64编解码操作\n" +
            "220.尚硅谷_文件下载-使用Base64编解码解决火狐浏览器附件中文乱码问题\n" +
            "221.尚硅谷_文件下载-使用User-Agent请求头判断，动态切换不同的方案解决所有浏览器附件中文乱码问题\n" +
            "222-尚硅谷-书城项目-第三阶段：修改所有html页面为jsp页面\n" +
            "223.尚硅谷_书城项目-第三阶段：抽取所有jsp页面中公共内容\n" +
            "224.尚硅谷_书城项目-动态的base标签值\n" +
            "225.尚硅谷_书城项目-表单提交失败的错误回显\n" +
            "226.尚硅谷_书城项目-代码优化：合并LoginServlet和RegistServlet程序为UserServlet程序\n" +
            "227.尚硅谷_书城项目-代码优化二：使用反射优化大量else if代码\n" +
            "228.尚硅谷_书城项目-代码优化三：抽取BaseServlet程序\n" +
            "229.尚硅谷_书城项目-BeanUtils工具类的使用\n" +
            "230.尚硅谷_书城项目-书城项目第四阶段，使用EL表达式实现表单错误回显\n" +
            "231-尚硅谷-书城项目-第五阶段：内容介绍\n" +
            "232.尚硅谷_书城项目-MVC概念的介绍\n" +
            "233.尚硅谷_书城项目-创建图书模块的数据库表\n" +
            "234.尚硅谷_书城项目-编写图书模块的JavaBean类Book\n" +
            "235.尚硅谷_书城项目-编写图书模块的Dao和测试\n" +
            "236.尚硅谷_书城项目-编写图书模块的Service和测试\n" +
            "237.尚硅谷_书城项目-图书列表功能的实现\n" +
            "238.尚硅谷_书城项目-前后台的简单介绍\n" +
            "239.尚硅谷_书城项目-添加图书功能实现\n" +
            "240.尚硅谷_书城项目-删除图书功能的实现\n" +
            "241.尚硅谷_书城项目-修改图书第一步，回显修改的信息\n" +
            "242.尚硅谷_书城项目-修改图书第二步，提交给服务器保存修改\n" +
            "243.尚硅谷_书城项目-第五阶段：图书分页的分析\n" +
            "244.尚硅谷_书城项目-分页模型Page对象的创建\n" +
            "245.尚硅谷_书城项目-分页初步实现\n" +
            "246.尚硅谷_书城项目-首页、上一页、下一页、末页的实现\n" +
            "247.尚硅谷_书城项目-跳到指定页码功能的实现\n" +
            "248.尚硅谷_书城项目-数据有效边境检查\n" +
            "249.尚硅谷_书城项目-分页条页码的输出\n" +
            "250.尚硅谷_书城项目-修改分页对原来，添加、删除、修改的影响\n" +
            "251.尚硅谷_书城项目-前台分页的初步实现\n" +
            "252.尚硅谷_书城项目-分页条的抽取\n" +
            "253.尚硅谷_书城项目-价格区间搜索并分页的分析\n" +
            "254.尚硅谷_书城项目-价格区间搜索并分页功能的实现\n" +
            "255.尚硅谷_书城项目-搜索价格区间的回显\n" +
            "256.尚硅谷_书城项目-解决分页条中不带价格区间的bug\n" +
            "257-尚硅谷-Cookie-什么是Cookie\n" +
            "258.尚硅谷_Cookie-Cookie的创建\n" +
            "259.尚硅谷_Cookie-Cookie的获取\n" +
            "260.尚硅谷_Cookie-Cookie值的修改\n" +
            "261.尚硅谷_Cookie-谷歌和火狐浏览器如何查看Cookie\n" +
            "262.尚硅谷_Cookie-Cookie的存活设置\n" +
            "263.尚硅谷_Cookie-Cookie的path属性\n" +
            "264.尚硅谷_Cookie-Cookie练习之免用户名登录\n" +
            "265.尚硅谷_Session-什么是Session\n" +
            "266.尚硅谷_Session-Session的创建和获取\n" +
            "267.尚硅谷_Session-Session域中数据的存取\n" +
            "268.尚硅谷_Session-Session超时的控制\n" +
            "269.尚硅谷_Session-浏览器和Session之间关联的技术内幕\n" +
            "270.尚硅谷_书城项目-显示登录的用户信息\n" +
            "271.尚硅谷_书城项目-注销登录\n" +
            "272.尚硅谷_书城项目-表单重复提交的三种常见情况\n" +
            "273.尚硅谷_书城项目-验证码底层原理\n" +
            "274.尚硅谷_书城项目-谷歌验证码的使用\n" +
            "275.尚硅谷_书城项目-把谷歌验证码加入到书城中使用\n" +
            "276.尚硅谷_书城项目-验证码的切换\n" +
            "277-尚硅谷-书城项目-购物车模块的分析\n" +
            "278.尚硅谷_书城项目-购物车模型的创建\n" +
            "279.尚硅谷_书城项目-购物车功能方法的实现和测试\n" +
            "280.尚硅谷_书城项目-添加商品到购物车功能的实现\n" +
            "281.尚硅谷_书城项目-购物车的展示\n" +
            "282.尚硅谷_书城项目-删除购物车中的商品项\n" +
            "283.尚硅谷_书城项目-清空购物车的实现\n" +
            "284.尚硅谷_书城项目-修改购物车商品数量\n" +
            "285.尚硅谷_书城项目-首页购物车数据展示\n" +
            "286.尚硅谷_书城项目-订单模块的分析\n" +
            "287.尚硅谷_书城项目-创建订单模型的数据库表\n" +
            "288.尚硅谷_书城项目-编写订单模块的两个数据模型Order和OrderItem\n" +
            "289.尚硅谷_书城项目-编写订单模块的Dao和测试\n" +
            "290.尚硅谷_书城项目-编写订单模块的Service和测试\n" +
            "291.尚硅谷_书城项目-结账功能实现，生成订单\n" +
            "292.尚硅谷_书城项目-解决生成订单的bug\n" +
            "293-尚硅谷-Filter-什么是Filter过滤器\n" +
            "294.尚硅谷_Filter-Filter过滤器的基本使用示例\n" +
            "295.尚硅谷_Filter-完整的用户登录和权限检查\n" +
            "296.尚硅谷_Filter-Filter的生命周期\n" +
            "297.尚硅谷_Filter-FilterConfig类介绍\n" +
            "298.尚硅谷_Filter-FilterChain多个过滤器执行的细节\n" +
            "299.尚硅谷_Filter-Filter拦截路径的三种配置方式\n" +
            "300.尚硅谷_书城项目-使用Filter过滤器实现后台的权限管理\n" +
            "301.尚硅谷_书城项目-ThreadLocal使用介绍\n" +
            "302.尚硅谷_书城项目-使用ThreadLocal确保所有操作都使用同一个Connection来实现事务管理\n" +
            "303.尚硅谷_书城项目-使用Filter统一给所有Service方法都加上try-catch来管理事务\n" +
            "304.尚硅谷_书城项目-使用Tomcat统一管理异常，展示友好的错误页面\n" +
            "305-尚硅谷-JSON-什么是JSON\n" +
            "306.尚硅谷_JSON-JSON的定义和访问\n" +
            "307.尚硅谷_JSON-JSON在JavaScript中两种常用的转换方法\n" +
            "308.尚硅谷_JSON-JavaBean和json的相互转换\n" +
            "309.尚硅谷_JSON-List集合和json的相互转换\n" +
            "310.尚硅谷_JSON-Map集合和json的相互转换\n" +
            "311.尚硅谷_AJAX-什么是AJAX请求\n" +
            "312.尚硅谷_AJAX-原生JavaScript的AJAX请求示例\n" +
            "313.尚硅谷_AJAX-AJAX请求的特点说明\n" +
            "314.尚硅谷_AJAX-jQuery的ajax方法\n" +
            "315.尚硅谷_AJAX-jQuery的get和post方法\n" +
            "316.尚硅谷_AJAX-jQuery的getJSON方法\n" +
            "317.尚硅谷_AJAX-jQuery的serialize方法\n" +
            "318.尚硅谷_书城项目-使用AJAX请求验证用户名是否可用\n" +
            "319.尚硅谷_书城项目-使用AJAX请求修改添加商品到购物车的实现\n" +
            "320.尚硅谷_i18n-什么是i18n国际化\n" +
            "321.尚硅谷_i18n-i18n国际化三要素介绍\n" +
            "322.尚硅谷_i18n-i18n国际化基础示例\n" +
            "323.尚硅谷_i18n-通过请求头实现国际化\n" +
            "324.尚硅谷_i18n-通过语言类型选择实现国际化\n" +
            "325.尚硅谷_i18n-使用JSTL标签库fmt实现国际化";

}

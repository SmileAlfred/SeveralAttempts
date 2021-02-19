package com.company;

import org.junit.Test;
import sun.awt.shell.Win32ShellFolderManager2;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileTest {
    public static String path = "F:/0.圣贤教育/5.蔡礼旭《幸福人生讲座》Av12247594";//要遍历的路径
    public static String name = "404.IDEA的使用与多线程-IDEA的使用与多线程的概述\n" +
            "405.IDEA的使用与多线程-IDEA的卸载\n" +
            "406.IDEA的使用与多线程-IDEA的介绍\n" +
            "407.IDEA的使用与多线程-IDEA的安装\n" +
            "408.IDEA的使用与多线程-启动IDEA并完成HelloWorld\n" +
            "409.IDEA的使用与多线程-Module的理解和创建\n" +
            "410.IDEA的使用与多线程-IDEA的常用设置\n" +
            "411.IDEA的使用与多线程-快捷键的设置\n" +
            "412.IDEA的使用与多线程-模板的使用和设置\n" +
            "413.IDEA的使用与多线程-章节概述_程序进程线程的概念\n" +
            "414.IDEA的使用与多线程-单核与多核CPU的任务执行_并行与并发\n" +
            "415.IDEA的使用与多线程-多线程的优点等\n" +
            "416.IDEA的使用与多线程-创建多线程方式一：继承Thread类\n" +
            "417.IDEA的使用与多线程-创建过程中两个问题的说明\n" +
            "418.IDEA的使用与多线程-继承方式的课后练习\n" +
            "419.IDEA的使用与多线程-线程的常用方法\n" +
            "420.IDEA的使用与多线程-线程优先级的设置\n" +
            "421.IDEA的使用与多线程-例题：继承Thread方式，多窗口卖票\n" +
            "422.IDEA的使用与多线程-创建多线程的方式二：实现Runnable接口\n" +
            "423.IDEA的使用与多线程-例题：实现Runnable方式，多窗口卖票\n" +
            "424.IDEA的使用与多线程-两种创建方式的对比\n" +
            "425.多线程-每天一考\n" +
            "426.多线程-复习：IDEA使用与多线程基本概念\n" +
            "427.多线程-复习：线程的创建与常用方法\n" +
            "428.多线程-线程的生命周期\n" +
            "429.多线程-理解线程的安全问题\n" +
            "430.多线程-线程安全问题的举例和解决措施\n" +
            "431.多线程-同步代码块处理实现Runnable的线程安全问题\n" +
            "432.多线程-同步代码块处理继承Thread类的线程安全问题\n" +
            "433.多线程-同步方法处理实现Runnable的线程安全问题\n" +
            "434.多线程-同步方法处理继承Thread类的线程安全问题\n" +
            "435.多线程-线程安全的单例模式之懒汉式\n" +
            "436.多线程-死锁的问题\n" +
            "437.多线程-Lock锁方式解决线程安全问题\n" +
            "438.多线程-同步机制的课后练习\n" +
            "439.多线程-线程通信的例题\n" +
            "440.多线程-sleep()和wait()的异同\n" +
            "441.多线程-线程通信：生产者消费者例题\n" +
            "442.多线程-创建多线程的方式三：实现Callable接口\n" +
            "443.多线程-使用线程池的好处\n" +
            "444.多线程-创建多线程的方式四：使用线程池\n" +
            "445.常用类-每天一考\n" +
            "446.常用类-复习：生命周期与同步机制\n" +
            "447.常用类-复习：线程通信和新的线程创建方式等\n";
    public static String[] names;

    public static void main(String[] args) {
        //names = name.split("\n");

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

        String regex = oldName.substring(oldName.indexOf('('),oldName.lastIndexOf(')')+1);
        System.out.println("regex = "  + regex);
        oldName = oldName.replace(regex,"").replace("蔡礼旭老师细讲《弟子规》幸福人生讲座40集 -","");

        oldName = oldName.substring(oldName.indexOf('.')+1,oldName.length());
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

                System.out.println(newFileName + " ； 新名字：" + path + "/" + reName(paths[paths.length - 1]));//F:/1118/3pad/50/2020-11-18/2020-11-18_112630.txt

                file = new File(newFileName); //指定文件名及路径
                file.renameTo(new File(path + "/" + reName(paths[paths.length - 1])));
                index++;
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


}

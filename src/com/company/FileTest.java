package com.company;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileTest {
    public static String path = "G:/2.JavaWeb/1.JavaWeb2020新版/尚硅谷2020最新版JavaWeb全套教程,java web零基础入门完整版";//要遍历的路径

    public static void main(String[] args) {
        //File file = new File(path);        //获取其file对象
        //func(file);

        //reverseContent();
        //scaleData("C:/Users/我是刘优秀/Desktop/踏面/1.txt");
        //getData("C:/Users/我是刘优秀/Desktop/2020-10-05_202920.txt");

        // get60Standard();
        //String oldName = "2.[尚硅谷]_宋红康_2-Oracle数据库管理(Av21400096,P2).mp4";

        //replaceData(fileName);

        //File file = new File("C:/Users/我是刘优秀/Desktop/test");        //获取其file对象
        //func(file);

        String allClassMates = "是非:\n" +
                "BJ.刘傲:\n" +
                "收到\n" +
                "\n" +
                "BJ.范天庆:\n" +
                "收到\n" +
                "\n" +
                "BJ.刘素云:\n" +
                "收到\n" +
                "\n" +
                "BJ.刘博伟:\n" +
                "收到\n" +
                "\n" +
                "BJ.李丹阳:\n" +
                "收到\n" +
                "\n" +
                "BJ.刘科言:\n" +
                "收到\n" +
                "\n" +
                "BJ.李家森:\n" +
                "收到\n" +
                "\n" +
                "BJ.谭博仁:\n" +
                "收到\n" +
                "\n" +
                "BJ.蔡昊天:\n" +
                "收到\n" +
                "\n" +
                "是非:\n" +
                "收到\n" +
                "\n" +
                "BJ.陈小婷:\n" +
                "收到\n" +
                "\n" +
                "BJ.高文静:\n" +
                "收到\n" +
                "\n" +
                "BJ.蔡卓恒:\n" +
                "收到\n" +
                "\n" +
                "BJ.李文莉:\n" +
                "收到\n" +
                "\n" +
                "BJ.蒋丛稷:\n" +
                "收到\n" +
                "\n" +
                "BJ.郝迥超:\n" +
                "收到\n" +
                "\n" +
                "BJ.黄根:\n" +
                "收到\n" +
                "\n" +
                "BJ.韩杰茹:\n" +
                "收到\n" +
                "\n" +
                "BJ.卢怡如:\n" +
                "收到\n" +
                "\n" +
                "BJ.隋志远:\n" +
                "收到\n" +
                "\n" +
                "BJ.孙雨:\n" +
                "收到\n" +
                "\n" +
                "BJ.孙红彬:\n" +
                "收到\n" +
                "\n" +
                "BJ.白田欣雨:\n" +
                "收到\n" +
                "\n" +
                "BJ.李昕宸:\n" +
                "收到\n" +
                "\n" +
                "BJ.陈日坤:\n" +
                "收到\n";

        catchIt(allClassMates);
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
        for (int i = 0; i < classMates.length; i++) {
            if (!havingName.contains(classMates[i])){
                System.out.println(classMates[i]);
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
        String[] arr = oldName.split("\\.");
        //oldName = oldName.replaceAll("[尚硅谷]_宋红康_", "").replaceAll(arr[0] + "\\.", "").replaceAll("\\[" + "尚硅谷" + "\\]" + "_宋红康_","");
        oldName = oldName.replaceAll("尚硅谷_", "").replaceAll(arr[0] + "\\.", "");
        char[] chars = oldName.toCharArray();
        StringBuffer sb = new StringBuffer();
        boolean noRead = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') noRead = true;
            if (chars[i] == ')') noRead = false;
            if (noRead) continue;
            sb.append(chars[i]);
        }
        return sb.toString().replace(")", "");
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

    private static void func(File file) {
        List<String> fileNameList = new ArrayList<>();
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                func(f);
            if (f.isFile()) {        //若是文件，直接打印
                String newFileName = f.getAbsolutePath().replace("\\", "/");
                String[] paths = newFileName.split("/");

                getWearTab(newFileName);

                //System.out.println(newFileName);//F:/1118/3pad/50/2020-11-18/2020-11-18_112630.txt

                //file = new File(newFileName); //指定文件名及路径
                //file.renameTo(new File(path + "/" + reName(paths[paths.length - 1])));

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
}

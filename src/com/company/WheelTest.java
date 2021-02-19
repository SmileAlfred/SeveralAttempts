package com.company;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WheelTest {
    private static double interval = 0.05;
    //tilt = -0.006;

    public static double xBias, yBias; //标准图形与测量图形最高点的距离
    public static double flangeThicknessN, flangeHeightN, qRValueN, felloeWidthN;
    public static int whetherWrong = 0, recieveSize;//=1 wrong
    public static double[] AfterTiltCompensate;
    public static List<Double> carryForCalculate = new ArrayList<Double>();

    public static void main(String[] args) {
        /*double two, one, i = 11765;
       for (; i < 16555; ) {
            //two = i * 0.top = i;9944 + 0.00007 * i * i + 1.2266;
            two = i * 50 / 16384;
            //y = 3.0371 * x + 352.93
            one = (i * 3.0371 + 352.93) / 1000;
            System.out.println("i= " + i + " ; 二次 = " + two + " 一次 = " + one + " ; 差 = " + (two - one));
            i += 5;
        }*/


        /*File file = new File("D:/OneDrive/刘赛赛_研究生期间_工作留底/实验/200909_轮对_重复性实验/0.原始数据/LM");        //获取其file对象
        func(file);

        for (int i = 0; i < thicks.size(); i++) {
            thick += thicks.get(i);
            hight += hights.get(i);
            qr += qrs.get(i);
            width += widths.get(i);
        }

        thick /= thicks.size();
        hight /= thicks.size();
        qr /= thicks.size();
        width /= thicks.size();*/

        //downloadData("C:/Users/我是刘优秀/Desktop/140lm.txt");
        downloadData("D:/OneDrive/刘赛赛_研究生期间_工作留底/实验/200909_轮对_重复性实验/0.原始数据/LM/2.txt");


        //System.out.println("thicks.size() = " + thicks.size());
        //System.out.println("均值：/t  " + thick + "/t" + hight + "\t" + qr + "\t" + width);
        //System.out.println("差值：\t  " + (thickStan - thick) + "\t" + (hightStan - hight) + "\t" + (qrStan - qr) + "\t" + (widthStan - width));
    }

    public static final double thickStan = 32.0187, hightStan = 26.948, qrStan = 10.3703, widthStan = 140.002;
    public static double thick = 0, hight = 0, qr = 0, width = 0;

    private static void func(File file) {
        List<String> fileNameList = new ArrayList<>();
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                func(f);
            if (f.isFile()) {        //若是文件，直接打印
                String newFileName = f.getAbsolutePath().replace("/", "/");
                downloadData(newFileName);
            }
        }
    }

    public static double[] measureDataCalc;

    public static void downloadData(String path) {
        carryForCalculate.clear();

        measureDataCalc = readData(path);

        if (measureDataCalc != null) {

            //double[] AfterGlassCompensate = new double[measureDataCalc.length];
            // AfterGlassCompensate = glassCompensate(measureDataCalc);
            // AfterTiltCompensate = new double[measureDataCalc.length];
            //AfterTiltCompensate = tiltCompensate(AfterGlassCompensate);

            //calculateValue(AfterTiltCompensate);

            /**
             * 查看计算前的数据
             */
            /*for (int i = 0; i < measureDataCalc.length; i++) {
                System.out.println(measureDataCalc[i]);
            }*/

            calculateValue(measureDataCalc);
        } else {
            System.out.println("whetherWrong = 1");
        }
    }


    /**
     * 读取 二进制文件 （原始数据）
     *
     * @param fileNameLast
     * @return
     */
    public static double[] readData(String fileNameLast) {
        int[] b = new int[3000];
        double[] cPaint;
        double[] cCalcA = null;
        String fmsg = "";
        int count = 0;
        try {
            File saveFile = new File(fileNameLast);
            FileInputStream is = new FileInputStream(saveFile);
            int length = is.available();

            byte[] buffer = new byte[length];
            int hasRead;
            recieveSize = length / 4;
            if (recieveSize < 2400 || recieveSize > 2700) {
                whetherWrong = 1;
            }
            int k = 0;
            if (whetherWrong != 1) {
                while ((hasRead = is.read(buffer)) != -1) {
                    for (int i = 3; i < buffer.length; i++) {
                        if ((buffer[i] & 0xf0) == (buffer[i - 1] & 0xf0)) {
                            if ((buffer[i] & 0xf0) == (buffer[i - 2] & 0xf0)) {
                                if ((buffer[i] & 0xf0) == (buffer[i - 3] & 0xf0)) {
                                    b[k] = b[k] + (buffer[i] & 0x0f) * 256 * 16;
                                } else {
                                    b[k] = b[k] + (buffer[i] & 0x0f) * 256;
                                }

                            } else {
                                b[k] = b[k] + (buffer[i] & 0x0f) * 16;
                            }
                        } else {
                            //carryForCalculate.add((double) b[k] * 50 / 16384); //张芃

                            carryForCalculate.add((3.0371 * b[k] + 352.93) / 1000); //新的标定
                            k++;
                            b[k] = b[k] + (buffer[i] & 0x0f);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("readData() 报错：" + e.getMessage());
        }
        if (whetherWrong != 1) {
            double[] cPaint2 = new double[carryForCalculate.size()];
            for (int j = 0; j < carryForCalculate.size(); j++) {
                cPaint2[j] = carryForCalculate.get(j);
            }
            int firstPoint = 0;
            for (int j = 1; j < carryForCalculate.size(); j++) {
                if ((carryForCalculate.get(j) == 0) && (carryForCalculate.get(j + 1) > 0)) {
                    firstPoint = j + 1;
                    j = carryForCalculate.size();
                }

            }
            double[] cCalc = new double[carryForCalculate.size() - firstPoint];
            cCalcA = new double[carryForCalculate.size() - firstPoint];
            double[] cCalcB = new double[carryForCalculate.size() - firstPoint];
            for (int j = firstPoint; j < carryForCalculate.size(); j++) {

                cCalc[j - firstPoint] = carryForCalculate.get(j);

            }
            try {
                cCalcA = flitering(cCalc);//零点差值
            } catch (Exception e) {
                // TODO: handle exception
                whetherWrong = 1;
            }
        }
        return cCalcA;
    }

    public static double[] glassCompensate(double[] data) {
        double[] returnData = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                returnData[i] = data[i] * 0.9944 + 0.00007 * data[i] * data[i] + 1.2266;
            } else {
                returnData[i] = 0;
            }
        }
        return returnData;
    }

    public static double[] tiltCompensate(double[] data) {
        double[] returnData = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                //---returnData[i] = Math.cos(tilt) * (data[i] - i * interval / Math.cos(tilt) * Math.sin(tilt));

            } else {
            }
        }
        return returnData;
    }

    public static double[] flitering(double[] data) {
        int k = 0;
        for (int i = 1; i < data.length - 10; i++) {
            k = 0;
            if (data[i] == 0) {
                k = 1;
                while (true) {
                    if (data[i + k] == 0) {
                        k++;
                    } else {
                        break;
                    }
                }
                for (int j = 0; j < k; j++) {
                    data[i + j] = data[i - 1] + (data[i + k] - data[i - 1]) / (k + 1) * (j + 1);
                }
            }
            i = i + k;
        }
        return data;
    }

    public static void calculateValue(double[] data) {
        try {
            int base;//基点
            int top = 0, q = 0, r = 0, sD = 0, first = 0;
            double topX = 0, topY = 0, qX = 0, qY = 0,
                    rX = 0, rY = 0, sDX = 0, sDY = 0,
                    baseX = 0, baseY = 0;
            //找初始点
            for (int i = 1; i < 200; i++) {
                if (data[i - 1] < 0.4 && data[i] > 0.4) {
                    first = i;
                }
            }
            System.out.println("找初始点：" + first);

            double min = 50;

            for (int i = 1; i < data.length; i++) {
                //if ((data[i] - min) < 0.4 && data[i] > 0.4) {//存在问题
                if ((data[i] - min) < 0 && data[i] > 0.4) {
                    min = data[i];
                    top = i;
                }
            }
            System.out.println("找 top：" + top);
            /*System.out.println("找到顶点：" + top );
            for (int i = top - 5; i < top + 5; i++) {
                System.out.println(i + " ：" + data[i] );
            }*/

            //找顶点
            topX = leastSquras(data);
            System.out.println("leastSquras 结束");

            topY = data[(int) Math.floor(topX)] + (topX - (int) Math.floor(topX)) *
                    (data[(int) Math.floor(topX) + 1] - data[(int) Math.floor(topX)]);
            baseX = topX - 54 / interval;
            baseY = data[(int) Math.floor(baseX)] + (baseX - (int) Math.floor(baseX)) *
                    (data[(int) Math.floor(baseX) + 1] - data[(int) Math.floor(baseX)]);
            //找R点
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] - baseY + 10 > 0 && data[i + 1] - baseY + 10 < 0) {
                    r = i;
                    double k = Math.abs(((double) (data[i] - baseY + 10)) / ((double) (data[i + 1] - baseY + 10)));
                    rX = (double) i + k / (k + 1);
                }
                if (data[i] == baseY - 10) {
                    rX = i;
                    rY = data[i];
                }
            }
            System.out.println("找 rX：" + rX);

            /**
             * sD - 轮缘厚度计算的 内测起始位置
             * 数据是旋转了 180° 后的； 实际上 Y 坐标是 棱角到 轮缘顶 遍历的，
             * 轮缘厚度是从 12 毫米处的厚度
             */
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] - baseY + 12 > 0 && data[i + 1] - baseY + 12 < 0) {
                    sD = i;
                    double k = ((double) (data[i] - baseY + 12)) / ((double) (-data[i + 1] + baseY + 12));
                    sDX = (double) i + k / (k + 1);
                    System.out.println("上 sDX = " + sDX + " ; i = " + i + " ; baseY = " + baseY);
                }
                if (data[i] == baseY - 12) {
                    sDX = i;
                    sDY = data[i];
                    System.out.println("下 sDX = " + sDX + " ; i = " + i + " ; baseY = " + baseY);
                }
            }

            /**
             * 目前 QR 算法是 从上往下 2 mm,从基点往上 10 mm
             */
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] - topY - 2 > 0 && data[i + 1] - topY - 2 < 0) {
                    q = i;
                    double k = Math.abs(((double) (data[i] - data[top] - 2)) / ((double) (-data[i + 1] + data[top] - 2)));
                    qX = (double) i + k / (k + 1);
                }
                if (data[i] == topY + 2) {
                    qX = i;
                    qY = data[i];
                }
            }
            System.out.println("找 qX：" + qX);

            xBias = -2382 + topX + 2701 - data.length;
            yBias = -27.0f - data[(int) topX];

            flangeThicknessN = sigFigure((double) ((-sDX + topX) * interval + 16));
            flangeHeightN = sigFigure((double) (-topY + baseY));
            qRValueN = sigFigure((double) ((qX - rX) * interval));
            felloeWidthN = sigFigure((double) ((topX - first - 2) * interval + 16));

            System.out.println("topX \t " + topX
                    + "\tsDX \t " + sDX
                    +"\nflangeThicknessN \t" + flangeThicknessN
                    +  "\tflangeHeightN \t " + flangeHeightN
                    + "\tqRValueN \t " + qRValueN
                    + "\tfelloeWidthN \t " + felloeWidthN);

            thicks.add(flangeThicknessN);
            hights.add(flangeHeightN);
            qrs.add(qRValueN);
            widths.add(felloeWidthN);
        } catch (Exception e) {
            System.out.println("报错在：" + e.getMessage());
        }
        /**
         * 查看 对齐后的 数据
         */
       /* if (recieveSize - 2400 > 0) {
            int k = (recieveSize >= 2681) ? recieveSize - 2680 : 1;
            int chaJu = 0;
            for (; k < measureDataCalc.length; k++) {
                if (k < 10)
                    chaJu = Math.abs((int) (measureDataCalc[k + 1] * 10) - (int) (measureDataCalc[k] * 10));

                if (k < 10 && chaJu > 10) continue;//小尾巴sb
                if ((interval * (measureDataCalc.length - k) + xBias * 0.05) < 16)
                    continue;//付文杰，我不也是为了给你对齐？
                System.out.println((interval * (measureDataCalc.length - k) + xBias * 0.05) + "\t" + (-measureDataCalc[k] - yBias + 30));
            }
        }*/
    }

    private static List<Double> thicks = new ArrayList<>();
    private static List<Double> hights = new ArrayList<>();
    private static List<Double> qrs = new ArrayList<>();
    private static List<Double> widths = new ArrayList<>();

    public static double leastSquras(double cCal[]) {
        try {
            double returnData = 0;
            int top = 0;
            double x1 = 0, x2 = 0, x3 = 0, y1 = 0, y2 = 0, y3 = 0, x1y1 = 0, x1y2 = 0, x2y1 = 0;
            int in = 1;
            double min = 50;
            for (int i = 1; i < cCal.length; i++) {
                if ((cCal[i] - min) < 0 && cCal[i] > 0.4) {
                    min = cCal[i];
                    top = i;
                }
            }
            System.out.println("leastSquras 找 top = " +top);

            int fitOrigin = top - 40;
            int nPa = 80;//拟合点个数
            for (int i = fitOrigin; i < fitOrigin + nPa; i++) {
                x1 = x1 + (i - fitOrigin) * interval;
                x2 = x2 + (i - fitOrigin) * interval * (i - fitOrigin) * interval;
                x3 = x3 + (i - fitOrigin) * (i - fitOrigin) * (i - fitOrigin) * interval * interval * interval;
                y1 = y1 + cCal[i];
                y2 = y2 + cCal[i] * cCal[i];
                y3 = y3 + cCal[i] * cCal[i] * cCal[i];
                x1y1 = x1y1 + (i - fitOrigin) * interval * cCal[i];
                x1y2 = x1y2 + (i - fitOrigin) * interval * cCal[i] * cCal[i];
                x2y1 = x2y1 + (i - fitOrigin) * (i - fitOrigin) * interval * interval * cCal[i];
            }
            System.out.println("拟合结束");

            double cPa, dPa, ePa, gPa, hPa, aPara, bPara, cPara, circleX, circleY, radius;
            cPa = nPa * x2 - x1 * x1;
            dPa = nPa * x1y1 - x1 * y1;
            ePa = nPa * x3 + nPa * x1y2 - (x2 + y2) * x1;
            gPa = nPa * y2 - y1 * y1;
            hPa = nPa * x2y1 + nPa * y3 - (x2 + y2) * y1;
            aPara = (hPa * dPa - ePa * gPa) / (cPa * gPa - dPa * dPa);
            bPara = (hPa * cPa - ePa * dPa) / (dPa * dPa - gPa * cPa);
            cPara = -(aPara * x1 + bPara * y1 + x2 + y2) / nPa;

            circleX = aPara / (-2);
            circleY = bPara / (-2);
            radius = Math.sqrt(aPara * aPara + bPara * bPara - 4 * cPara) / 2;
            returnData = circleX / interval + fitOrigin;
            //interval = interval / Math.cos(tilt);
            return returnData;
        } catch (Exception e) {
            System.out.println("leastSquras 报错：" + e.getMessage());
            return -999;
        }
    }

    public static double sigFigure(double pDouble) {
        int num = 2;
        BigDecimal bd = new BigDecimal(pDouble);
        BigDecimal bd1 = bd.setScale(num, bd.ROUND_HALF_UP);
        pDouble = bd1.doubleValue();
        long ll = Double.doubleToLongBits(pDouble);
        return pDouble;
    }

}

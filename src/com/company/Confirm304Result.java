package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 140mm 车轮试样拿去 304 所做检测，结果跟我们不一致；
 * 现在通过 304 所提供的扫描数据进行反推各个参数，检测是否我们的算法有问题
 */
public class Confirm304Result {
    public static List<Double[]> resultList = new ArrayList<>();

    public static double xBias, yBias; //标准图形与测量图形最高点的距离
    public static double flangeThicknessN, flangeHeightN, qRValueN, felloeWidthN;

    public static void main(String[] args) {
        /**
         * 根据测得的结果 反推 各个参数
         */
        readResultData("C:/Users/我是刘优秀/Desktop/140lm.txt");
    }

    /**
     * 读取 车轮数据，ForPC 目录下的结果
     *
     * @param fileNameLast
     * @return
     */
    private static void readResultData(String fileNameLast) {
        File buildDir = new File(fileNameLast);
        if (!buildDir.exists()) buildDir.mkdirs();
        File saveFile = new File(fileNameLast);

        double[] cCalcA = null;
        resultList.clear();

        try {
            BufferedReader reader = null;
            String tempString = null;
            int line = 1;
            StringBuffer sb = new StringBuffer();
            reader = new BufferedReader(new FileReader(saveFile));
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString + "\r\n");
                line++;
            }
            reader.close();

            final String[] measurePointPairsStr = sb.toString().split("\n");//[(X,Y),(X,Y)]
            double[] yArr = new double[measurePointPairsStr.length];
            double[] xArr = new double[measurePointPairsStr.length];

            /**
             * 倒叙添加，X Y 均倒叙，
             */
            for (int i = measurePointPairsStr.length - 1; i >= 0; i--) {
                String[] zuoBiaoStr = measurePointPairsStr[i].split("\t");
                double x = Double.parseDouble(zuoBiaoStr[0]);
                double y = Double.parseDouble(zuoBiaoStr[1]);
                Double[] zuoBiaoDouble = new Double[]{x, y};

                resultList.add(zuoBiaoDouble);
            }

        } catch (IOException e) {
            System.out.println("readResultData 报错：" + e.getMessage());
            return;
        }

        double[] cPaint2 = new double[resultList.size()];
        for (int j = 0; j < resultList.size(); j++) {
            cPaint2[j] = resultList.get(j)[1];
        }
        int firstPoint = 0;
        for (int j = 1; j < resultList.size(); j++) {
            if ((resultList.get(j)[1] == 0) && (resultList.get(j + 1)[1] > 0)) {
                firstPoint = j + 1;
                j = resultList.size();
            }
        }
        double[] cCalc = new double[resultList.size() - firstPoint];
        cCalcA = new double[resultList.size() - firstPoint];
        double[] cCalcB = new double[resultList.size() - firstPoint];
        for (int j = firstPoint; j < resultList.size(); j++) {

            cCalc[j - firstPoint] = resultList.get(j)[1];

        }
        try {
            cCalcA = flitering(cCalc);//零点差值
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("flitering 报错：" + e.getMessage());
        }

        calculateValue4304(cCalcA);
    }

    public static void calculateValue4304(double[] data) {
        try {
            int base;//基点
            int top = 0, q = 0, r = 0, sD = 0, first = 0;
            double topX = 0, topY = 0, qX = 0, qY = 0,
                    rX = 0, rY = 0, sDX = 0, sDY = 0,
                    baseX = 0, baseY = 0;
            //找初始点
            first = 0;
           /* for (int i = 1; i < 20; i++) {
                if (data[i - 1] < 0 && data[i] > 0.4) {
                    first = i;
                }
            }*/
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
            baseX = 368;
            baseY = 368;
            topX = 695;
            topY = 695;

            //找R点
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] - resultList.get((int) baseY)[1] + 10 > 0 && data[i + 1] - resultList.get((int) baseY)[1] + 10 < 0) {
                    r = i;
                    double k = Math.abs(((double) (data[i] - resultList.get((int) baseY)[1] + 10)) / ((double) (data[i + 1] - resultList.get((int) baseY)[1] + 10)));
                    rX = (double) i + k / (k + 1);
                }
                if (data[i] == resultList.get((int) baseY)[1] - 10) {
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
                if (data[i] - resultList.get((int) baseY)[1] + 12 > 0 && data[i + 1] - resultList.get((int) baseY)[1] + 12 < 0) {
                    sD = i;
                    double k = ((double) (data[i] - resultList.get((int) baseY)[1] + 12)) / ((double) (-data[i + 1] + resultList.get((int) baseY)[1] + 12));
                    sDX = (double) i + k / (k + 1);
                    System.out.println("上 sDX = " + sDX + " ; i = " + i + " ; baseY = " + baseY);
                }
                if (data[i] == resultList.get((int) baseY)[1] - 12) {
                    sDX = i;
                    sDY = data[i];
                    System.out.println("下 sDX = " + sDX + " ; i = " + i + " ; baseY = " + baseY);
                }
            }

            /**
             * 目前 QR 算法是 从上往下 2 mm,从基点往上 10 mm
             */
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] - resultList.get((int) topY)[1] - 2 > 0 && data[i + 1] - resultList.get((int) topY)[1] - 2 < 0) {
                    q = i;
                    double k = Math.abs(((double) (data[i] - data[top] - 2)) / ((double) (-data[i + 1] + data[top] - 2)));
                    qX = (double) i + k / (k + 1);
                }
                if (data[i] == resultList.get((int) topY)[1] + 2) {
                    qX = i;
                    qY = data[i];
                }
            }
            System.out.println("找 qX：" + qX);

            /*xBias = -2382 + topX + 2701 - data.length;
            yBias = -27.0f - data[(int) topX];*/

            flangeThicknessN = sigFigure((double) (Math.abs(resultList.get((int) sDX)[0] - resultList.get((int) topX)[0]) + 16));
            flangeHeightN = sigFigure((double) (Math.abs(resultList.get((int) topY)[1] - resultList.get((int) baseY)[1])));
            qRValueN = sigFigure((double) (Math.abs(resultList.get((int) qX)[0] - resultList.get((int) rX)[0])));
            felloeWidthN = sigFigure((double) (Math.abs(resultList.get((int) topX)[0] - resultList.get((int) first)[0]) + 16));

            final double thickStan = 32.0187, hightStan = 26.948, qrStan = 10.3703, widthStan = 140.002;

            System.out.println("topX \t " + topX
                    + "\tsDX \t " + sDX
                    + "\n结果：\tflangeThicknessN \t" + flangeThicknessN
                    + "\tflangeHeightN \t " + flangeHeightN
                    + "\tqRValueN \t " + qRValueN
                    + "\tfelloeWidthN \t " + felloeWidthN
                    + "\n偏差：\tflangeThicknessN \t" + (thickStan - flangeThicknessN)
                    + "\tflangeHeightN \t " + (hightStan - flangeHeightN)
                    + "\tqRValueN \t " + (qrStan - qRValueN)
                    + "\tfelloeWidthN \t " + (widthStan - felloeWidthN));

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

    public static double sigFigure(double pDouble) {
        int num = 2;
        BigDecimal bd = new BigDecimal(pDouble);
        BigDecimal bd1 = bd.setScale(num, bd.ROUND_HALF_UP);
        pDouble = bd1.doubleValue();
        long ll = Double.doubleToLongBits(pDouble);
        return pDouble;
    }

}

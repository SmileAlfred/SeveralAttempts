package rail_test;


import java.util.Arrays;

/**
 * @author: LiuSaiSai
 * @date: 2020/09/17 15:49
 * @description: 用于接收；电脑端解析发过来的结构体
 */
public class Struct {

    public byte[] buf;
    public static final int

   //打开相机
   ORDER_OPEN_CAMERA_MSG = 12,
    //关闭相机
    ORDER_CLOSE_CAMERA_MSG = 13,
    //接收成功
    ORDER_SUCESS__MSG = 14,
    //开始采集命令
    ORDER_START_COLLECT_MSG = 17,
    //关机命令
    ORDER_SHUT_DOWN_MSG = 1,
    //重启命令
    ORDER_SYSTEM_RESTART__MSG = 19,
    //日期同步
    DATA_DATASYN_MSG = 5,
    //握手
    ORDER_REQUEST_CONNECTION = 16,

    //测量结果上传
    DATA_RESULT_MSG_50 = 50,
            DATA_RESULT_MSG_60 = 60,
    //电脑电池信息上传
    DATA_BATTERY_MSG = 3,
    //PC短软件运行日志
    DATA_STATUS_MSG = 4,

    //电脑内存信息
    DATA_MEMORY_MSG = 6,
    //删除电脑不必要的数据
    DATA_DELETE_FILE_MSG = 7,
    //删除电脑不必要的数据
    DATA_IMAGE_MSG = 8,

    DATA_SAMPLING_MSG = 9,
            DATA_DRAW_MSG = 10,
            CAMERA_STATE_1_CLOSE = 61,
            CAMERA_STATE_2_CLOSE = 62,
            CAMERA_STATE_1_OPEN = 63,
            CAMERA_STATE_2_OPEN = 64;


    public int msg_code;
    //测量的三个参数：double；占用24个字节
    public double[] stResult = new double[3];
    //指针；占8个字节，不读
    public double null_point;
    //传递的点数；占四个字节；接收文件时用来new byte的长度；
    public int nStPointCnt;
    //指针，不读，占8个字节；用以表示例如电量、内存空间等信息
    public double null_pReversedData;
    //接收的长度占 4 个字节；日期时间 的长度
    public int nReversedDataCnt;
    //扫描的图像

    public int getMsg_code() {
        return msg_code;
    }

    public double[] getStResult() {
        return stResult;
    }

    public int getnStPointCnt() {
        return nStPointCnt;
    }

    public int getnReversedDataCnt() {
        return nReversedDataCnt;
    }
    //ST_IMAGE stImage[4];

    /**
     * 对接受的结构体数据进行解析
     *
     * @param buffer 结构体的字节流
     */
    public static Struct getStruct(byte[] buffer) {
        //Log.i(TAG, "getStruct: buffer.length = " + buffer.length);
        Struct struct = new Struct();
        byte[] tempBytes8 = new byte[8];
        byte[] tempBytes4 = new byte[4];

        //获取命令
        System.arraycopy(buffer, 0, tempBytes4, 0, 4);
        struct.msg_code = FormatUtils.byteArrayToInt(tempBytes4);
        // Log.i(TAG, "getStruct: msg_code = " + FormatUtils.byteArrayToInt(tempBytes4) + "; " + Arrays.toString(tempBytes4));

        switch (FormatUtils.byteArrayToInt(tempBytes4)) {
            case ORDER_OPEN_CAMERA_MSG:
                break;//打开相机
            case ORDER_CLOSE_CAMERA_MSG:
                break;//关闭相机
            case ORDER_SUCESS__MSG:
                break;//接收成功
            case ORDER_START_COLLECT_MSG:
                break;//开始采集命令
            case ORDER_SHUT_DOWN_MSG:
                break;//关机命令
            case DATA_DATASYN_MSG:
                break;//日期同步
            case DATA_DELETE_FILE_MSG:
                break;//删除电脑不必要的数据
            case DATA_IMAGE_MSG:
                break;//删除电脑不必要的数据

            case DATA_RESULT_MSG_50:
                break;//测量结果上传
            case DATA_BATTERY_MSG:
                break;//电脑电池信息上传
            case DATA_STATUS_MSG:
                break;//软件运行日志信息上传
            case DATA_MEMORY_MSG:
                break;//电脑内存信息

            case DATA_SAMPLING_MSG:
                break;
            case DATA_DRAW_MSG:
                break;
            default:
                break;
        }
        //获取磨耗参数 1 - ; 2 - ; 3 - ;
        double sw, vw, tw;
        System.arraycopy(buffer, 4, tempBytes8, 0, 8);
        sw = FormatUtils.byteArrayToDouble(tempBytes8);
        //  Log.i(TAG, "getStruct: sw = " + sw + " ;" + Arrays.toString(tempBytes8));
        System.arraycopy(buffer, 12, tempBytes8, 0, 8);
        vw = FormatUtils.byteArrayToDouble(tempBytes8);
        // Log.i(TAG, "getStruct: vw = " + vw + " ;" + Arrays.toString(tempBytes8));
        System.arraycopy(buffer, 20, tempBytes8, 0, 8);
        tw = FormatUtils.byteArrayToDouble(tempBytes8);
        // Log.i(TAG, "getStruct: tw = " + tw + " ;" + Arrays.toString(tempBytes8));
        struct.stResult = new double[]{sw, vw, tw};

        //获取 无意义的 指针  字节对齐的情况下，指针占8个字节
        System.arraycopy(buffer, 28, tempBytes8, 0, 8);

        //获取测量的 TODO：点 的对数 <x,y>为一对
        System.arraycopy(buffer, 36, tempBytes4, 0, 4);
        struct.nStPointCnt = FormatUtils.byteArrayToInt(tempBytes4);
        //Log.i(TAG, "getStruct: nStPointCnt = " + FormatUtils.byteArrayToInt(tempBytes4) + " ;" + Arrays.toString(tempBytes4));

        //获取 无意义的 指针 字节对齐的情况下，指针占8个字节
        System.arraycopy(buffer, 40, tempBytes8, 0, 8);

        //用于表示；例如电量、内存空间等信息的长度
        System.arraycopy(buffer, 48, tempBytes4, 0, 4);
        struct.nReversedDataCnt = FormatUtils.byteArrayToInt(tempBytes4);
        // Log.i(TAG, "getStruct: nReversedDataCnt = " + FormatUtils.byteArrayToInt(tempBytes4) + " ;" + Arrays.toString(tempBytes4));
        //接收不必要的东西
        byte[] tempBytes80 = new byte[80];
        System.arraycopy(buffer, 52, tempBytes80, 0, 80);
        struct.receivePictures = getPicturesInfo(tempBytes80);
        // Log.i(TAG, "getStruct: 解析后的：" + struct.toString() + "; \n" + Arrays.toString(tempBytes80));
        return struct;
    }

    private static final String TAG = Struct.class.getSimpleName();

    public ReceivePicture[] receivePictures;

    //接受图片的的内部类
    public static class ReceivePicture {
        int numPic;
        int[] scalePic;

        public int getNumPic() {
            return numPic;
        }

        public void setNumPic(int numPic) {
            this.numPic = numPic;
        }

        public int[] getScalePic() {
            return scalePic;
        }

        public void setScalePic(int[] scalePic) {
            this.scalePic = scalePic;
        }
    }

    public static ReceivePicture[] getPicturesInfo(byte[] tempBytes80) {
        ReceivePicture[] receivePictures = new ReceivePicture[4];
        byte[] tempBytes20 = new byte[20];
        for (int i = 0; i < receivePictures.length; i++) {
            System.arraycopy(tempBytes80, (i * tempBytes20.length), tempBytes20, 0, tempBytes20.length);
            receivePictures[i] = getPictureInfo(tempBytes20);
        }
        return receivePictures;
    }

    public static ReceivePicture getPictureInfo(byte[] tempBytes20) {
        byte[] tempBytes4 = new byte[4];
        byte[] tempBytes8 = new byte[8];
        ReceivePicture receivePicture = new ReceivePicture();
        System.arraycopy(tempBytes20, 0, tempBytes4, 0, 4);
        receivePicture.setNumPic(FormatUtils.byteArrayToInt(tempBytes4));

        //空指针
        System.arraycopy(tempBytes20, 4, tempBytes8, 0, 8);

        System.arraycopy(tempBytes20, 12, tempBytes4, 0, 4);
        int xPix = (FormatUtils.byteArrayToInt(tempBytes4));//X 方向上的像素
        System.arraycopy(tempBytes20, 16, tempBytes4, 0, 4);
        int yPix = (FormatUtils.byteArrayToInt(tempBytes4));//y 方向上的像素
        receivePicture.setScalePic(new int[]{xPix, yPix});
        return receivePicture;
    }


    public Struct() {
    }

    /**
     * 发送结构体 时的构造器
     */
    public Struct(int ORDER, int m_nReversedDataCnt) {
        this.msg_code = ORDER;
        this.nReversedDataCnt = m_nReversedDataCnt;

        byte[] tempByte4 = new byte[4];
        byte[] tempByte8 = new byte[8];
        byte[] tempByte80 = new byte[80];
        this.buf = new byte[132];

        //发 送命令
        switch (ORDER) {
            case ORDER_OPEN_CAMERA_MSG:
                break;//打开相机
            case ORDER_CLOSE_CAMERA_MSG:
                break;//关闭相机
            case ORDER_SUCESS__MSG:
                break;//接收成功
            case ORDER_START_COLLECT_MSG:
                break;//开始采集命令
            case ORDER_SHUT_DOWN_MSG:
                break;//关机命令
            case DATA_DATASYN_MSG:
                break;//日期同步
            case DATA_DELETE_FILE_MSG:
                break;//删除电脑不必要的数据
            case DATA_IMAGE_MSG:
                break;//删除电脑不必要的数据

            case DATA_RESULT_MSG_50:
                break;//测量结果上传
            case DATA_BATTERY_MSG:
                break;//电脑电池信息上传
            case DATA_STATUS_MSG:
                break;//软件运行日志信息上传
            case DATA_MEMORY_MSG:
                break;//电脑内存信息
            case DATA_SAMPLING_MSG:
                break;
            case DATA_DRAW_MSG:
                break;
            default:
                break;
        }
        tempByte4 = FormatUtils.toLH(this.msg_code);
        System.arraycopy(tempByte4, 0, buf, 0, 4);

        //发送 磨耗参数 1 - ; 2 - ; 3 - ;
        this.stResult = new double[]{1.1, 2.2, 3.3};
        tempByte8 = FormatUtils.toLH(this.stResult[0]);
        System.arraycopy(tempByte8, 0, buf, 4, 8);
        tempByte8 = FormatUtils.toLH(this.stResult[1]);
        System.arraycopy(tempByte8, 0, buf, 12, 8);
        tempByte8 = FormatUtils.toLH(this.stResult[2]);
        System.arraycopy(tempByte8, 0, buf, 20, 8);

        // 发送无意义的指针
        this.null_point = 4.4;
        tempByte8 = FormatUtils.toLH(this.null_point);
        System.arraycopy(tempByte8, 0, buf, 28, 8);

        // 发送 点 的对数
        this.nStPointCnt = 5;
        tempByte4 = FormatUtils.toLH(this.nStPointCnt);
        System.arraycopy(tempByte4, 0, buf, 36, 4);

        //发送 无意义的 指针 ;指针占8个字节
        this.null_pReversedData = 6.6;
        tempByte8 = FormatUtils.toLH(this.null_pReversedData);
        System.arraycopy(tempByte8, 0, buf, 40, 8);

        //用于表示；例如电量、内存空间等信息的长度
        //tempByte4 = toLH(m_nReversedDataCnt);
        tempByte4 = FormatUtils.toLH(this.nReversedDataCnt);
        System.arraycopy(tempByte4, 0, buf, 48, 4);
        //用于表示；无用信息
        tempByte80 = blank.getBytes();
        System.arraycopy(tempByte80, 0, buf, 52, 80);

        //Log.i(TAG, "Struct: 发送的结构体是：" + toString());
    }

    public String blank = "HelloWorld" + "HelloWorld" + "HelloWorld" + "HelloWorld" + "HelloWorld" + "HelloWorld" + "HelloWorld" + "HelloWorld";

    /**
     * 返回要发送的数组
     */
    public byte[] getBuf() {
        return buf;
    }

    @Override
    public String toString() {
        return "Struct{" +
                "msg_code=" + this.msg_code +
                ", stResult=" + Arrays.toString(this.stResult) +
                ", null_point=" + this.null_point +
                ", nStPointCnt=" + this.nStPointCnt +
                ", null_pReversedData=" + this.null_pReversedData +
                ", nReversedDataCnt=" + this.nReversedDataCnt +
                '}';
    }
}
package com.company;

import java.io.*;
import java.net.ServerSocket;//导入ServerSocket类
import java.net.Socket; //导入Socket 类
import java.security.MessageDigest;
import java.sql.Struct;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 模拟qq聊天功能： 实现客户端与服务器（一对一）的聊天功能，客户端首先发起聊天，输入的内容在服务器端和客户端显示，
 * 然后服务器端也可以输入信息，同样信息也在客户端和服务器端显示
 */
public class J2ATransferServe {
    private String dataDir = "E:/AJ_Data";
    //private static final String FilePATH = "C:/Users/我是刘优秀/Desktop/received";
    private BufferedOutputStream bos2 = null;
    private BufferedOutputStream bos1 = null;
    private static final int PORT = 9996;
    private PrintWriter writer;
    private ServerSocket serverSocket = null;
    private static Socket mSocket = null;
    InputStream isMsg = null;
    private String time = "时间";
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    static OutputStream sendOutputStream;

    public J2ATransferServe() {//构造器：创建ServerSocket对象
        try {
            // 1. 创建服务端ServerSocket
            serverSocket = new ServerSocket(PORT);
            // 2. 建立连接
            mSocket = serverSocket.accept();
            isMsg = mSocket.getInputStream();
            System.out.println("连接成功");
            sendOutputStream = mSocket.getOutputStream();
            //String path = "F:/1118/1pad";        //要遍历的路径
            //File file = new File(path);        //获取其file对象
            //func(file);
        } catch (IOException e) {
            System.out.println("构造器报错：" + e.getMessage());
        }
    }

    static List<String> fileNameList;

    private static void func(File file) {
        fileNameList = new ArrayList<>();
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                func(f);
            if (f.isFile()) {        //若是文件，直接打印
                String newFileName = f.getAbsolutePath().replace("\\", "/");
                //System.out.println(newFileName);
                fileNameList.add(newFileName);

            }
        }
        for (int i = 0; i < fileNameList.size(); i++) {
        }
    }


    private final String RECEIVE = "receive";//表示允许接受，

    private boolean isReciving = false;

    //启动服务器类
    public void startServer() {
        FileStruct struct = null;
        // 3. 创建流对象
        // 3.1 获取网络字节缓冲输入流,读取文件数据
        try {
            while (true) {
                if (!isReciving) {
                    byte[] bufferMsg = new byte[128];
                    isMsg.read(bufferMsg);
                     struct = FileStruct.getFileStructInstance(bufferMsg);
                    //TODO:判断是否要去接收

                    //本次发送的是 文件 信息
                    if (struct.isFileInfo == 0) {
                        struct.setIsFileInfo(1);
                        isReciving = true;
                        sendFileData(struct);//接收到文件信息时，发送要文件内容的命令
                    }
                }

                BufferedInputStream isData = new BufferedInputStream(mSocket.getInputStream());

                File file = new File(dataDir);//TODO:文件名
                if (!file.exists()) {
                    file.createNewFile();
                }
                //使用true，即进行append file

                //TODO:上限问题？如果传输文件是 几个G 那么传输的速度太慢
                byte[] bufferData = new byte[1024 * 1024 * 100];//GB
                int size = -1;
                //方式二
                long received = 0L;
                BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream(file, true));
                int mb = 0;

                time = timeFormat.format(new Date());
                System.out.println(time + "开始接收文件！");
                while (true) {
                    size = isData.read(bufferData);
                    System.out.println("size = " + size);
                    received += size;

                    if (mb != Integer.parseInt(received + "") / 1024 / 1024) {
                        if (mb % 10 == 0) System.out.println(timeFormat.format(new Date()) + " 已经接收：" + mb + " MB");
                        mb += 1;
                    }

                    fileOut.write(bufferData, 0, size);
                    fileOut.flush();
                    System.out.println("received = " + received + " ; fileSize = " + struct.fileContentLength);
                    if (received == struct.fileContentLength) break;
                    if (size < bufferData.length && (received < struct.fileContentLength)) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                        }
                    }
                }
                time = timeFormat.format(new Date());
                isReciving = false;
                System.out.println(time + "接受完成！文件大小：" + struct.fileContentLength + " ;" + "接收到的字节数 " + received);
            }
        } catch (IOException ioException) {
            System.out.println("IOException 报错:" + ioException.getMessage());
        }
    }


    /**
     * totalFileNam
     * sendFileName 文件名
     */
    public void sendFileInfo(String totalFileName) {
        try {
            //File sendFile = new File(FilePATH, sendFileName);
            File sendFile = new File(totalFileName);//F:/1118/3pad/50/2020-11-18/2020-11-18_112630.txt
            String[] paths = totalFileName.replace("\\", "/").split("/");

            String confirmStr = md5(sendFile) + "\t" + paths[paths.length - 1] + "\t" + sendFile.length();
            //方式三：可行

            if (sendOutputStream == null) {
                System.out.println("sendOutputStream == null");
                return;
            }
            byte[] info = new byte[128];
            byte[] mInfo = new FileStruct(0, confirmStr.length(), 0L, totalFileName).getBuf();
            System.arraycopy(info, 0, mInfo, 0, mInfo.length);
            sendOutputStream.write(info);//固定验证信息都是 128 个字节

            sendOutputStream.write(totalFileName.getBytes());
            sendOutputStream.flush();
        } catch (IOException e) {
            System.out.println("发送信息报错：" + e.getMessage());
        }
    }

    public void sendFileData(FileStruct fileStruct) {
        if (fileStruct.isFileInfo != 1) return;
        try {
            File sendFile = new File(fileStruct.fileDir);//F:/1118/3pad/50/2020-11-18/2020-11-18_112630.txt
            sendOutputStream.write(new FileStruct(1, 0, sendFile.length(), fileStruct.fileDir).getBuf());
            sendOutputStream.flush();
            BufferedOutputStream outputData = new BufferedOutputStream(sendOutputStream);
            //TODO：发送文件内容
            BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(sendFile));
            //判断是否读到文件末尾
            int singleSendSize = 0;
            long sendedSize = 0L;
            byte[] buffer = new byte[1024 * 1024 * 100];//100MB

            while (true) {
                singleSendSize = fileInput.read(buffer);
                outputData.write(buffer, 0, singleSendSize);
                outputData.flush();

                sendedSize += singleSendSize;
                if (sendedSize == sendFile.length()) {
                    break;
                }
            }
            outputData = null;
            System.out.println("发送 " + sendFile.getAbsolutePath() + " 结束！文件大小 = " + +sendFile.length() + " ; 发送了 " + sendedSize);
        } catch (IOException e) {
            System.out.println("发送文件内容报错：" + e.getMessage());
        }
    }


    public static void main(String[] args) {
        new J2ATransferServe().startServer();
    }

    public String getTxtformat(InputStream bin) {
        int p = 0;
        try {
            p = (bin.read() << 8) + bin.read();
        } catch (IOException e) {
            System.out.println("获取文件编码格式报错！");
        }
        String code = null;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
                break;
        }
        return code;
    }

    public static String md5(File file) {
        if (file == null || !file.isFile() || !file.exists()) {
            return "";
        }
        FileInputStream in = null;
        String result = "";
        byte buffer[] = new byte[8192];
        int len;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                md5.update(buffer, 0, len);
            }
            byte[] bytes = md5.digest();

            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    class FileInfo {
        private String md5;
        private String fileName;
        private long fileSize;
        private ArrayList<byte[]> fileContent;

        public FileInfo(String md5, String fileName, long fileSize) {
            this.md5 = md5;
            this.fileName = fileName;
            this.fileSize = fileSize;
        }

        public FileInfo() {
        }

        private FileInfo getFileInfo(InputStream isInfo) {
            FileInfo file = new FileInfo();
            byte[] bufferMsg = new byte[128];
            int len = 0;
            try {
                len = isInfo.read(bufferMsg);
                String receivedMsg = new String(bufferMsg, "GBK").trim();
                String[] infos = receivedMsg.split("\t");
                file.setMd5(infos[0]);
                file.setFileName(infos[1]);
                file.setFileSize(Long.parseLong(infos[2]));
            } catch (IOException e) {
                System.out.println("报错：" + e.getMessage());
            }
            return file;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public long getFileSize() {
            return fileSize;
        }

        public void setFileSize(long fileSize) {
            this.fileSize = fileSize;
        }

        public ArrayList<byte[]> getFileContent() {
            return fileContent;
        }

        public void setFileContent(ArrayList<byte[]> fileContent) {
            this.fileContent = fileContent;
        }
    }

    /**
     * 通过新协议 是否 是文件信息（0 - 1 ），文件信息长度（int），文件内容长度（long）
     */
    static class FileStruct {
        private int isFileInfo;//0 - 是文件信息；1 - 文件内容
        private int infoLength;//文件信息长度；
        private long fileContentLength;//文件内容长度
        private String fileDir;//文件目录
        public byte[] bufStruct;

        public FileStruct() {
        }

        public FileStruct(int isFileInfo, int infoLength, long fileContentLength, String fileDir) {
            byte[] tempByte4 = new byte[4];
            byte[] tempByte8 = new byte[8];
            byte[] tempByte = new byte[112];
            bufStruct = new byte[16];
            try {
                tempByte4 = intToByteArray(isFileInfo);
                System.arraycopy(tempByte4, 0, bufStruct, 0, 4);

                tempByte4 = intToByteArray(infoLength);
                System.arraycopy(tempByte4, 0, bufStruct, 4, 4);
                tempByte8 = longToByteArray(fileContentLength);
                System.arraycopy(tempByte8, 0, bufStruct, 8, 8);
                tempByte = fileDir.getBytes();
                System.arraycopy(tempByte, 0, bufStruct, 16, 112);
            } catch (IOException e) {
            }
        }

        public String getFileDir() {
            return fileDir;
        }

        public void setFileDir(String fileDir) {
            this.fileDir = fileDir;
        }

        public byte[] getBufStruct() {
            return bufStruct;
        }

        public void setBufStruct(byte[] bufStruct) {
            this.bufStruct = bufStruct;
        }

        /**
         * 通过接收到的 byte[] 对象解析成结构体对象；
         * 注意：PC 接收端，发送的结构体还是 48 个字节，并没有修改，此时的顺序时 code，X[2]，Y[2],data,
         *
         * @param bytes 来自 PC 端的字节流文件；
         * @return
         */
        public static FileStruct getFileStructInstance(byte[] bytes) {
            FileStruct fileStruct = new FileStruct();

            byte[] tempBytes4 = new byte[4];
            byte[] tempBytes8 = new byte[8];
            byte[] tempBytes = new byte[112];
            try {
                System.arraycopy(bytes, 0, tempBytes4, 0, 4);
                fileStruct.setIsFileInfo(byteArrayToInt(tempBytes4));

                System.arraycopy(bytes, 4, tempBytes4, 0, 4);
                fileStruct.setInfoLength(byteArrayToInt(tempBytes4));

                System.arraycopy(bytes, 8, tempBytes8, 0, 8);
                fileStruct.setFileContentLength(byteArrayToLong(tempBytes8));

                System.arraycopy(bytes, 16, tempBytes, 0, 112);
                fileStruct.setFileDir(new String(tempBytes, "GBK"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return fileStruct;
        }

        /**
         * 返回要发送的数组
         */
        public byte[] getBuf() {
            return bufStruct;
        }

        public int getIsFileInfo() {
            return isFileInfo;
        }

        public void setIsFileInfo(int isFileInfo) {
            this.isFileInfo = isFileInfo;
        }

        public int getInfoLength() {
            return infoLength;
        }

        public void setInfoLength(int infoLength) {
            this.infoLength = infoLength;
        }

        public long getFileContentLength() {
            return fileContentLength;
        }

        public void setFileContentLength(long fileContentLength) {
            this.fileContentLength = fileContentLength;
        }


        //byte数组转换成long
        public static long byteArrayToLong(byte[] data) throws IOException {
            ByteArrayInputStream bai = new ByteArrayInputStream(data);
            DataInputStream dis = new DataInputStream(bai);
            return dis.readLong();
        }

        //byte数组转换成int
        public static int byteArrayToInt(byte[] data) throws IOException {
            ByteArrayInputStream bai = new ByteArrayInputStream(data);
            DataInputStream dis = new DataInputStream(bai);
            return dis.readInt();
        }

        //long转换成byte数组
        public byte[] longToByteArray(long l) throws IOException {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bao);
            dos.writeLong(l);
            byte[] buf = bao.toByteArray();
            return buf;
        }

        //int转换成byte数组
        public byte[] intToByteArray(int a) throws IOException {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bao);
            dos.writeInt(a);
            byte[] buf = bao.toByteArray();
            return buf;
        }
    }
}
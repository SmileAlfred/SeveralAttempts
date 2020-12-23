package com.company.gui;


import com.company.J2ATransferServe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 打开、保存 指定文件
 */
public class OpenFileDemo {
    private Frame mFrame;// 定义窗体
    private MenuBar menuBar;// 定义菜单栏
    private TextArea mTextArea;
    private Menu fileMenu;// 定义"文件"和"子菜单"菜单
    private MenuItem openFileItem, saveFileItem, closeFileItem;// 定义条目“退出”和“子条目”菜单项
    private FileDialog openDir, saveDir;// 定义“打开、保存”对话框
    private File file;//定义文件
    private J2ATransferServe serve;

    OpenFileDemo() {
        init();
    }

    public static void main(String[] args) {
        new OpenFileDemo();
    }

    /* 图形用户界面组件初始化 */
    public void init() {
        mFrame = new Frame("选择文件窗口");// 创建窗体对象
        mFrame.setBounds(300, 100, 650, 600);// 设置窗体位置和大小

        menuBar = new MenuBar();// 创建菜单栏
        mTextArea = new TextArea();// 创建文本域

        fileMenu = new Menu("File");// 创建“文件”菜单

        openFileItem = new MenuItem("Open");// 创建“打开"菜单项
        saveFileItem = new MenuItem("Save");// 创建“保存"菜单项
        closeFileItem = new MenuItem("Exit");// 创建“退出"菜单项

        fileMenu.add(openFileItem);// 将“打开”菜单项添加到“文件”菜单上
        fileMenu.add(saveFileItem);// 将“保存”菜单项添加到“文件”菜单上
        fileMenu.add(closeFileItem);// 将“退出”菜单项添加到“文件”菜单上

        menuBar.add(fileMenu);// 将文件添加到菜单栏上

        mFrame.setMenuBar(menuBar);// 将此窗体的菜单栏设置为指定的菜单栏。

        openDir = new FileDialog(mFrame, "打开", FileDialog.LOAD);
        saveDir = new FileDialog(mFrame, "保存", FileDialog.SAVE);

        mFrame.add(mTextArea);// 将文本域添加到窗体内
        onClick();// 加载事件处理

        mFrame.setVisible(true);// 设置窗体可见

        serve = new J2ATransferServe();
    }

    private void onClick() {
        // 打开菜单项监听
        openFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDir.setVisible(true);//显示打开文件对话框

                String dirPath = openDir.getDirectory();//获取打开文件路径并保存到字符串中。
                String fileName = openDir.getFile();//获取打开文件名称并保存到字符串中

                if (dirPath == null || fileName == null)//判断路径和文件是否为空
                    return;
                else
                    mTextArea.setText(null);//文件不为空，清空原来文件内容。
                file = new File(dirPath, fileName);//创建新的路径和名称

                /*try {
                    BufferedReader bufReader = new BufferedReader(new FileReader(file));//尝试从文件中读东西
                    String line = null;//变量字符串初始化为空
                    while ((line = bufReader.readLine()) != null) {
                        mTextArea.append(line + "\r\n");//显示每一行内容
                    }
                    bufReader.close();//关闭文件
                } catch (FileNotFoundException e1) {
                    // 抛出文件路径找不到异常
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // 抛出IO异常
                    e1.printStackTrace();
                }*/
                serve.sendFileInfo(file.getAbsolutePath());
                mTextArea.append("发送的文件名：" + file.getAbsolutePath() + "\r\n");//显示每一行内容
                //D:\OneDrive\刘赛赛工作留底\实验\201011_钢轨_重复性实验\50轨\原始数据\1号Pad\2020-11-19
                String path = "D:/OneDrive/刘赛赛工作留底/实验/201011_钢轨_重复性实验/50轨/原始数据/1号Pad/2020-11-19";//要遍历的路径
                File file = new File(path);        //获取其file对象
                List<String> file2Send =  func(file);
                for (int i = 0; i < file2Send.size(); i++) {
                    serve.sendFileInfo(file2Send.get(i));
                    mTextArea.append("发送的文件名：" + file2Send.get(i) + "\r\n");//显示每一行内容
                }
            }
        });

        // 保存菜单项监听
        saveFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (file == null) {
                    saveDir.setVisible(true);//显示保存文件对话框
                    String dirPath = saveDir.getDirectory();//获取保存文件路径并保存到字符串中。
                    String fileName = saveDir.getFile();////获取打保存文件名称并保存到字符串中

                    if (dirPath == null || fileName == null)//判断路径和文件是否为空
                        return;//空操作
                    else
                        file = new File(dirPath, fileName);//文件不为空，新建一个路径和名称
                }
                try {
                    BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file));

                    String text = mTextArea.getText();//获取文本内容
                    bufWriter.write(text);//将获取文本内容写入到字符输出流

                    bufWriter.close();//关闭文件
                } catch (IOException e1) {
                    //抛出IO异常
                    e1.printStackTrace();
                }
            }
        });

        // 退出菜单项监听
        closeFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // 窗体关闭监听
        mFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private List<String> func(File file) {
        List<String> fileNameList = new ArrayList<>();
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
                fileNameList.add(f.getName());
            if (f.isFile()) {        //若是文件，直接打印
                String newFileName = f.getAbsolutePath().replace("/", "/");
                //System.out.println(newFileName);//F:/1118/3pad/50/2020-11-18/2020-11-18_112630.txt
                fileNameList.add(newFileName);
            }
        }
        return fileNameList;
    }
}


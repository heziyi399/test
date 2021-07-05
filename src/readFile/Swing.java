package readFile;

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class Swing extends JFrame {
//    private static final long serial = 1L;
//    private JPanel jcontenPanel = null;
//    private JTextArea jTextArea = null;
//    private JPanel jcontrolPanel = null;
//    private JButton openButton = null;
//    private JButton closeButton = null;
//
//    public static long getSerial() {
//        return serial;
//    }
//
//    public void setJcontenPanel(JPanel jcontenPanel) {
//        this.jcontenPanel = jcontenPanel;
//    }
//
//    public JTextArea getjTextArea() {
//        return jTextArea;
//    }
//
//    public void setjTextArea(JTextArea jTextArea) {
//        this.jTextArea = jTextArea;
//    }
//
//    public JPanel getJcontrolPanel() {
//        return jcontrolPanel;
//    }
//
//    public void setJcontrolPanel(JPanel jcontrolPanel) {
//        this.jcontrolPanel = jcontrolPanel;
//    }
//
//    public void setOpenButton(JButton openButton) {
//        this.openButton = openButton;
//    }
//
//    public void setCloseButton(JButton closeButton) {
//        this.closeButton = closeButton;
//    }
//
//    private JButton getOpenButton() {
//        if (openButton == null) {
//            openButton = new JButton();
//            openButton.setText("写入文件");
//            openButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    File file = new File("D:\\word.txt");
//                    try {
//                        FileWriter out = new FileWriter(file);
//                        String s = jTextArea.getText();
//                        out.write(s);
//                        out.close();
//                    } catch (Exception e2) {
//                        e2.printStackTrace();
//                    }
//
//                }
//            });
//        }
//        return openButton;
//    }
//
//    private JButton getCloseButton() {
//        if (closeButton == null) {
//            closeButton = new JButton();
//            closeButton.setText("读取文件");//修改按钮的提示信息
//            closeButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    File file = new File("D:\\word.txt");
//                    try {
//                        FileReader in = new FileReader(file);
//                        char byt[] = new char[1024];
//                        int len = in.read(byt);
//                        jTextArea.setText(new String(byt, 0, len));
//                        in.close();
//
//                    } catch (Exception e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            });
//        }
//        return closeButton;
//    }
//
//    public Swing() {
//        super();
//        initialize();
//
//    }
//
//    public void initialize() {
//        this.setSize(300, 200);
//        this.setContentPane(getContentPane());
//        this.setTitle("jframe");
//
//    }
//
//    public JPanel JcontenPanel() {
//        if (jcontenPanel == null) {
//            jcontenPanel = new JPanel();
//            jcontenPanel.setLayout(new BorderLayout());
//            jcontenPanel.add(getjTextArea(), BorderLayout.CENTER);
//            jcontenPanel.add(getJcontrolPanel(), BorderLayout.SOUTH);
//        }
//
//        return jcontenPanel;
//    }
//
//    public static void main(String[] args) {
//        Swing thisClass = new Swing();
//        thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        thisClass.setVisible(true);
//    }
//}


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;


//本实例创建Swing窗体，单击窗体中的“写入文件”按钮实现将文本框中是数据写入到磁盘文件中，
//单击“读取文件”按钮，系统将磁盘文件中的信息显示在文本框中。
import java.awt.*; //*表示所有包
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class Swing extends JFrame { // 创建类，继承JFrame类
    private JScrollPane scrollPane;
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null; // 创建面板对象
    private JTextArea jTextArea = null; // 创建文本域对象
    private JPanel controlPanel = null; // 创建面板对象
    private JButton openButton = null; // 创建按钮对象
    private JButton closeButton = null; // 创建按钮对象


    private JTextArea getJTextArea() {
        if (jTextArea == null) {
            jTextArea = new JTextArea();
        }
        return jTextArea;
    }


    private JPanel getControlPanel() {
        if (controlPanel == null) {
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setVgap(1);
            controlPanel = new JPanel();
            controlPanel.setLayout(flowLayout);
            controlPanel.add(getOpenButton(), null);
            controlPanel.add(getCloseButton(), null);
        }
        return controlPanel;
    }


    private JButton getOpenButton() {
        if (openButton == null) {
            openButton = new JButton();
            openButton.setText("写入文件"); // 修改按钮的提示信息
            openButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { // 按钮的单击事件
                    File file = new File("word.txt"); // 创建文件对象
                    try {
                        FileWriter out = new FileWriter(file); // 创建FileWriter对象
                        String s = jTextArea.getText(); // 获取文本域中的文本
                        out.write(s); // 将信息写入磁盘文件
                        out.close(); // 将流关闭
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
        return openButton;
    }


    private JButton getCloseButton() {
        if (closeButton == null) {
            closeButton = new JButton();
            closeButton.setText("读取文件"); // 修改按钮的提示信息
            closeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { // 按钮的单击事件
                    File file = new File("word.txt"); // 创建文件对象
                    try {
                        FileReader in = new FileReader(file); // 创建FileReader对象
                        char byt[] = new char[1024]; // 创建char型数组
                        int len = in.read(byt); // 将字节读入数组
                        jTextArea.setText(new String(byt, 0, len)); // 设置文本域的显示信息
                        in.close(); // 关闭流
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
        return closeButton;
    }


    public Swing() {
        super();
        initialize();
    }


    public void initialize() {
        this.setSize(300, 200);
        this.setContentPane(getJContentPane());
        this.setTitle("JFrame");
    }


    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getScrollPane(), BorderLayout.CENTER);
            jContentPane.add(getControlPanel(), BorderLayout.SOUTH);
        }
        return jContentPane;
    }


    public static void main(String[] args) { // main主方法
       Swing thisClass = new Swing(); // 创建本类对象
        thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisClass.setVisible(true); // 设置该窗体未显示状态
    }


    protected JScrollPane getScrollPane() {
        if (scrollPane == null) {
            scrollPane = new JScrollPane();
            scrollPane.setViewportView(getJTextArea());
        }
        return scrollPane;
    }
}

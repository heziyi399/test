package ch1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InputArea extends JFrame implements ActionListener {

    JTextField string1,string2,string3;
    JButton button;
    InputArea(String s){

       super(s);
        setLayout(new FlowLayout());
       setVisible(true);
       setBounds(100,100,300,100);
        string1 = new JTextField(12);
        string2 = new JTextField(12);
        string3 = new JTextField(12);
        button = new JButton("连接");
        add(string1);
        add(string2);
        add(string3);
        add(button);
      //  button.addActionListener(this::actionPerformed);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       String str = string1.getText()+string2.getText();

if(e.getSource()==button){
    string3.setText(str);
}
    }

    public static void main(String[]args){
        //InputArea newarea = new InputArea("name");
        Frame f=new Frame("字符串拼接");

        //设置分本框
        TextField tf1=new TextField(8);
        TextField tf2=new TextField(8);
        JButton b=new JButton("连接");
        TextField tf3=new TextField(15);
        //设置文本域
        //TextArea ta=new TextArea(10,40);

        f.setBounds(200, 200, 400, 300);



        //设置按钮功能
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //获取文本框的内容，并去除字符串前面和后面的空格
                String s=tf1.getText();
                String s2 = tf2.getText();

                //将字符串内容设置到文本域中
                //ta.setText(s);

                //追加内容，并换行
                tf3.setText(s+s2);
                tf3.requestFocus();

            }
        });

        //将按钮添加到窗体中
        f.add(tf1);

        f.add(tf2);
        f.add(b);
        f.add(tf3);


        //设置窗体布局模式为流式布局
        f.setLayout(new FlowLayout());

        //关闭窗口
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.setVisible(true);


    }

}

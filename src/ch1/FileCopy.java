package ch1;

import java.io.*;

public class FileCopy {

        public static void main(String[] args) throws IOException {
            //copy1("c:\\word.txt","c:\\word2.txt");
       copy2("c:\\w2.txt","c:\\w3.txt");
        }


    //使用输入流通常包括四个基本步骤：设定输入流的源，创建指向源的输入流，让输入流读取源中的数据，关闭流
    //文件字节输入流：FileInputStream
public static void  copy1(String a,String b) throws IOException {
    FileInputStream input = new FileInputStream(a);
    File file = new File(a);
    if(!file.canRead()||file.length() == 0) return ;
    FileOutputStream output = new FileOutputStream(b);
    byte[] hasRead =new byte[100056];
char c[]=new char[1000];
    int n = -1;
    while((n = input.read() )!= -1) {

    }
  input.close();
    output.close();

}
    //使用输入流通常包括四个基本步骤：设定输入流的源，创建指向源的输入流，让输入流读取源中的数据，关闭流
    //文件字节输入流：FileInputStream
    public static void  copy2(String a,String b) throws IOException {
        FileReader input = new FileReader(a);
        File file = new File(a);
        if(!file.canRead()||file.length() == 0) return ;
        FileWriter output = new FileWriter(b);
        char c[]=new char[1000];

        int n = -1;
        while((n = input.read(c) )!= -1)
        {

            output.write(c);
        }
        input.close();
        output.close();

    }
    }
